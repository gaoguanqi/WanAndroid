package com.maple.wanandroid.app

import com.maple.baselibrary.app.BaseApplication

class MyApplication : BaseApplication() {

    companion object {
        @JvmStatic
        lateinit var instance: MyApplication
            private set
    }

//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(base)
//        MultiDex.install(base)
//    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initConfig(this)
    }

     private fun initConfig(app: MyApplication) {

    }
}