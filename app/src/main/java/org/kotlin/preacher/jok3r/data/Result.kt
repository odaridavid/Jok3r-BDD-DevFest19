package org.kotlin.preacher.jok3r.data

sealed class Result<out R>

class Success<out T>(val data: T) : Result<T>()

class Error(val exception: Exception) : Result<Nothing>()

object Loading : Result<Nothing>()