package com.maple.baselibrary.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseViewActivity<DB : ViewDataBinding, VM : BaseViewModel> :BaseActivity(){

    private lateinit var binding:DB
    abstract fun getBindingVariable(): Int
    abstract fun getViewModel(): VM

    override fun setContentLayout() {
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        binding.executePendingBindings() //当数据改变时，调用executePendingBindings方法立即改变。
        binding.setVariable(getBindingVariable(), getViewModel())
    }

}