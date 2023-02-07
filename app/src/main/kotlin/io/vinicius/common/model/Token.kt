package io.vinicius.common.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Token(
    val accessToken: String,
    val refreshToken: String
)