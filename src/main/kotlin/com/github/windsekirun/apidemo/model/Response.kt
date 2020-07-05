package com.github.windsekirun.apidemo.model

data class Response<T>(val result: Boolean, val message: String, val data: T)