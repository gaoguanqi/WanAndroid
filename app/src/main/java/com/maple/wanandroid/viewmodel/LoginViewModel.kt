package com.maple.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.maple.baselibrary.base.BaseViewModel
import com.maple.baselibrary.utils.ToastUtil

class LoginViewModel(app:Application) :BaseViewModel(app) {

     val account :MutableLiveData<String> = MutableLiveData()
     val password :MutableLiveData<String> = MutableLiveData()


    init {
        account.value = "123"
        password.value = "456"
    }


    fun onLogin(){
        ToastUtil.showToast("账号$account.value"+"--密码${password.value}")
    }

    override fun onCleared() {
        super.onCleared()
    }

}