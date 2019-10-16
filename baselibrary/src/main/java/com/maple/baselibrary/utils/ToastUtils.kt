package com.maple.baselibrary.utils

import android.text.TextUtils
import com.blankj.utilcode.util.ColorUtils
import com.maple.baselibrary.R
import com.blankj.utilcode.util.ToastUtils as Toast

class ToastUtils {
    companion object {
        @JvmStatic
        fun showToast(s: String?) {
            if(!TextUtils.isEmpty(s)){
                Toast.setBgColor(ColorUtils.getColor(R.color.colorToast))
                Toast.showShort(s)
            }
        }
    }
}