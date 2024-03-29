package com.maple.baselibrary.http

import android.text.TextUtils
import java.io.Serializable

open class BaseResponse<T> : Serializable {

    private var code: Int = -1
    private var message: String? = null
    private var data: T? = null

    fun isSuccessOK(): Boolean = code == 200
    fun getMessage(): String {
        if (TextUtils.isEmpty(message)) {
            return "未知错误！！！"
        } else {
            return message!!
        }
    }
}