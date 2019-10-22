package com.maple.baselibrary.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders


abstract class BaseViewActivity<DB : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    abstract fun bindViewModel()

    open lateinit var binding: DB
    open lateinit var viewModel: VM

    abstract fun providerViewModel(): Class<VM>


    override fun setContentLayout() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        //当数据改变时，调用executePendingBindings方法立即改变。
        binding.executePendingBindings()
        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this).get(providerViewModel())
        bindViewModel();
    }


}