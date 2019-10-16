package com.maple.baselibrary.base

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.irozon.sneaker.Sneaker
import com.maple.baselibrary.R
import com.maple.baselibrary.ext.layoutInflater
import com.maple.baselibrary.utils.Event
import com.maple.baselibrary.utils.EventBusUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseFragment :Fragment(){

    /**
     * 是否使用EventBus,默认不使用
     */
    open fun hasUsedEventBus(): Boolean = false


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (hasUsedEventBus()) {
            EventBusUtils.register(this)
        }
    }

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



    fun showTopMessage(msg:String?){
        if(!TextUtils.isEmpty(msg)){
            val sneaker = Sneaker.with(this) // Activity, Fragment or ViewGroup
            val view = (activity as Context).layoutInflater.inflate(R.layout.sneaker_view,  sneaker.getView(), false)
            view.findViewById<TextView>(R.id.tv_message).text = msg
            sneaker.sneakCustom(view)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (hasUsedEventBus()) {
            EventBusUtils.unregister(this)
        }
    }
}