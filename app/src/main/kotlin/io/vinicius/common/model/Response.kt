package io.vinicius.common.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response<T>(
    val data: T
)