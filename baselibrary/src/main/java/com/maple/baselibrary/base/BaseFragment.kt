package com.maple.baselibrary.base

import android.content.Context
import android.text.TextUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.irozon.sneaker.Sneaker
import com.maple.baselibrary.R
import com.maple.baselibrary.extensions.layoutInflater

abstract class BaseFragment : Fragment() {


    fun showTopMessage(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            val sneaker = Sneaker.with(this) // Activity, Fragment or ViewGroup
            val view = (activity as Context).layoutInflater.inflate(
                R.layout.sneaker_view,
                sneaker.getView(),
                false
            )
            view.findViewById<TextView>(R.id.tv_message).text = msg
            sneaker.sneakCustom(view)
        }
    }

}