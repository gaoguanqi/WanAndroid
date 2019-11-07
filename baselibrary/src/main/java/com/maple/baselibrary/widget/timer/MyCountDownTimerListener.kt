package com.maple.baselibrary.widget.timer

interface MyCountDownTimerListener {
    fun onStart()
    fun onTick(millisUntilFinished: Long)
    fun onFinish()
}