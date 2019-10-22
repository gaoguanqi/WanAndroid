package com.maple.wanandroid.view.activity

import android.os.Bundle
import com.maple.baselibrary.base.BaseViewActivity
import com.maple.wanandroid.R
import com.maple.wanandroid.databinding.ActivityLoginBinding
import com.maple.wanandroid.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseViewActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun providerViewModel(): Class<LoginViewModel> = LoginViewModel::class.java


    override fun bindViewModel() {
        binding.viewModel = viewModel
    }


    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.account.value = et_account.text.toString()
        viewModel.password.value = et_password.text.toString()
    }


}
