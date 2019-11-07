package com.maple.baselibrary.exception

import java.lang.RuntimeException

class AppException:RuntimeException {
    constructor():super()
    constructor(message:String):super(message)
}