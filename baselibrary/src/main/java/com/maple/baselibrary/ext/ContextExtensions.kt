package com.maple.baselibrary.ext

import android.content.Context
import android.view.LayoutInflater

internal inline val Context.layoutInflater: LayoutInflater get() = LayoutInflater.from(this)