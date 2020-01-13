package com.mobiquity.utils.entities

sealed class CommonResponse<out T>

data class Success<T>(val data: T?) : CommonResponse<T>()
data class Loading(val msg: String?) : CommonResponse<Any?>()
data class ErrorIn(val code: Int?=null, val message: String?) : CommonResponse<Any?>()