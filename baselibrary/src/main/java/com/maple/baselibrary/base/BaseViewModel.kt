package com.maple.baselibrary.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(app:Application) : AndroidViewModel(app){



    override fun onCleared() {
        super.onCleared()
    }

}