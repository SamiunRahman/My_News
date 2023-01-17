package com.samiun.mynews.network

import com.samiun.mynews.model.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val BASE_URL =
    "https://newsapi.org"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService{

    @GET("v2/top-headlines?country=us&apiKey=158e738d4a6447db8c51dbbb7d79d7b1")
    suspend fun getArticales(): News

}

object  NewsApi
{
    val retrofitService : NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}