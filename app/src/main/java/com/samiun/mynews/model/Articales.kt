package com.samiun.mynews.model

import android.icu.text.CaseMap.Title

data class Articales(
    val source: Source,
    val aurthor: String,
    val title: String,
    val description : String,
    val url : String,
    val urlToImage: String,
    val publishedAt: String,
    val content : String
)
