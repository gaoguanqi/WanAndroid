package com.maple.wanandroid.view.activity

import android.os.Bundle
import com.maple.baselibrary.base.BaseViewActivity
import com.maple.baselibrary.utils.LogUtils
import com.maple.wanandroid.R
import com.maple.wanandroid.databinding.ActivityLoginBinding
import com.maple.wanandroid.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseViewActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun providerViewModel(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initData(savedInstanceState: Bundle?) {

        binding.account = et_account.text.toString()
        binding.password = et_password.text.toString()

        btn_login.setOnClickListener {
            LogUtils.logGGQ("账号:${binding.account}---密码:${binding.password}")
        }
    }


}
