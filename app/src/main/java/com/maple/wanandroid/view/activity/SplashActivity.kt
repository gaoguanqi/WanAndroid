package com.maple.wanandroid.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maple.baselibrary.base.BaseActivity
import com.maple.baselibrary.widget.timer.MyCountDownTimer
import com.maple.baselibrary.widget.timer.MyCountDownTimerListener
import com.maple.wanandroid.R
import kotlin.concurrent.timer

class SplashActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_splash

    private lateinit var timer: MyCountDownTimer

    override fun initData(savedInstanceState: Bundle?) {

        timer = MyCountDownTimer(6000,1000,object :MyCountDownTimerListener{
            override fun onStart() {
            }

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                this@SplashActivity.finish()
            }
        })
    }
}
