package com.example.myapplication.common

sealed class DomainResult<out T: Any> {
    data class Success<out T: Any>(val data: T) : DomainResult<T>()
    data class Error(val error: String): DomainResult<Nothing>()
}