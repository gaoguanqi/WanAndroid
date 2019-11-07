package com.maple.baselibrary.widget.timer

import android.os.CountDownTimer

class MyCountDownTimer(
     millisInFuture: Long,
     countDownInterval: Long,
    val listener: MyCountDownTimerListener
) : CountDownTimer(millisInFuture, countDownInterval) {

    init {
        start()
        listener.onStart()
    }

    override fun onTick(millisUntilFinished: Long) {
        listener.onTick(millisUntilFinished)
    }


    override fun onFinish() {
        listener.onFinish()
    }
}