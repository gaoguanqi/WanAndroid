package com.maple.baselibrary.base

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.irozon.sneaker.Sneaker
import com.maple.baselibrary.R
import com.maple.baselibrary.utils.Event
import com.maple.baselibrary.utils.EventBusUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope(), IVIew {


    /**
     * 布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState: Bundle?): Unit


    /**
     * 设置布局文件
     */
    open fun setContentLayout() {
        setContentView(getLayoutId())
    }

    /**
     * 是否使用EventBus,默认不使用
     */
    open fun hasUsedEventBus(): Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
        if (hasUsedEventBus()) {
            EventBusUtils.register(this)
        }
        initData(savedInstanceState)
    }


    /**
     * 四种线程模型
     * EventBus3.0有四种线程模型，分别是：
     * POSTING：默认，表示事件处理函数的线程跟发布事件的线程在同一个线程。
     * MAIN：表示事件处理函数的线程在主线程(UI)线程，因此在这里不能进行耗时操作。
     * BACKGROUND：表示事件处理函数的线程在后台线程，因此不能进行UI操作。如果发布事件的线程是主线程(UI线程)，那么事件处理函数将会开启一个后台线程，如果果发布事件的线程是在后台线程，那么事件处理函数就使用该线程。
     * ASYNC：表示无论事件发布的线程是哪一个，事件处理函数始终会新建一个子线程运行，同样不能进行UI操作。
     */

    /**
     * 接收到普通的Event
     * 封装MAIN线程模式，子类可重写 onEvnetBusReceive,
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun <T> onEventBusReceive(event: Event<T>?) {
        if (event != null) {
            onEventBusDispense(event)
        }
    }

    /**
     * 接收到粘性的Event
     * 封装MAIN线程模式，子类可重写 onStickyEvnetBusReceive,
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    open fun <T> onStickyEventBusReceive(event: Event<T>?) {
        if (event != null) {
            onStickyEventBusDispense(event)
        }
    }


    /**
     * 子类重写onEventBusDispense，处理接收到的普通事件
     */
    open fun <T> onEventBusDispense(event: Event<T>) {}

    /**
     * 子类重写onStickyEventBusDispense，处理接收到的粘性事件
     */
    open fun <T> onStickyEventBusDispense(event: Event<T>) {}


    /**
     * 顶部提示消息
     */
    fun showTopMessage(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            val sneaker = Sneaker.with(this) // Activity, Fragment or ViewGroup
            val view =
                LayoutInflater.from(this).inflate(R.layout.sneaker_view, sneaker.getView(), false)
            view.findViewById<TextView>(R.id.tv_message).text = msg
            sneaker.sneakCustom(view)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        this.cancel()
        if (hasUsedEventBus()) {
            EventBusUtils.unregister(this)
        }
    }
}