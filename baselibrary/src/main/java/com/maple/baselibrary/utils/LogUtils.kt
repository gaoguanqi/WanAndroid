package com.maple.baselibrary.utils

import android.util.Log
import com.maple.baselibrary.BuildConfig

class LogUtils {
    companion object {
        @JvmStatic
        fun logGGQ(s: String?) {
            if (BuildConfig.DEBUG) {
                Log.i("GGQ", s)
            }
        }
    }
}