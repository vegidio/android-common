package io.vinicius.common.model

data class Country(
    val code: String,
    val name: Name,
    val capital: String?,
    val region: String,
    val subRegion: String?,
    val languages: List<Language>,
    val currencies: List<Currency>,
    val population: Int,
    val area: Float,
    val coordinates: List<Float>,
    val flags: Flag
) {
    data class Name(
        val common: String,
        val official: String,
        val nativeName: List<NativeName>
    )

    data class NativeName(
        val language: String,
        val common: String,
        val official: String
    )

    data class Language(
        val code: String,
        val name: String
    )

    data class Currency(
        val code: String,
        val name: String,
        val symbol: String?
    )

    data class Flag(
        val png: String,
        val svg: String
    )
}