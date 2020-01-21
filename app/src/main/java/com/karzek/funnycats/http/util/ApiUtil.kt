package com.karzek.funnycats.http.util

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtil {

    private const val BASE_URL = "https://api.thecatapi.com"

    fun getRetrofit(): Retrofit {
        return Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}