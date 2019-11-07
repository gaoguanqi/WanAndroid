package com.maple.baselibrary.extensions

import android.view.KeyEvent
import android.view.View

internal inline fun View.onKey(crossinline body: (KeyEvent) -> Boolean) {
    setOnKeyListener { _, _, event -> body(event) }
}