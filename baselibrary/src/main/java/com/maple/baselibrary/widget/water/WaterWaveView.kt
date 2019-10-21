package com.maple.baselibrary.widget.water

import android.content.Context
import android.util.AttributeSet
import android.view.View

class WaterWaveView:View {
    constructor(context: Context?):super(context,null,0)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        initView(context,
            attrs,
            defStyleAttr)
    }

    private fun initView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {
        

    }

}