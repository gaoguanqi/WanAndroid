package com.maple.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maple.baselibrary.base.BaseActivity
import com.maple.baselibrary.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setOnClickListener {  showTopMessage("000000")

            ToastUtils.showToast("wwwwwwwwwww")
        }



    }
}
