package com.maple.wanandroid.view.activity

import android.os.Bundle
import android.view.KeyEvent
import com.maple.baselibrary.base.BaseActivity
import com.maple.baselibrary.utils.ToastUtil
import com.maple.wanandroid.R

class HomeActivity : BaseActivity() {

    private var lastBackPressedMillis:Long = 0

    override fun getLayoutId() = R.layout.activity_home

    override fun initData(savedInstanceState: Bundle?) {

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(lastBackPressedMillis + 2000 > System.currentTimeMillis()){
                //moveTaskToBack(true)
                this@HomeActivity.finish()
            }else{
                lastBackPressedMillis = System.currentTimeMillis()
                ToastUtil.showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
