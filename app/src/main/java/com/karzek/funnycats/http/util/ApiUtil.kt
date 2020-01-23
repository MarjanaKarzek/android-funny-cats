package com.karzek.funnycats.http.util

import android.util.Log
import com.karzek.funnycats.data.token.LocalTokenDataSource
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtil {

    private const val BASE_URL = "https://api.thecatapi.com"

    fun getRetrofit(localTokenDataSource: LocalTokenDataSource): Retrofit {
        return Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getClient(localTokenDataSource))
            .build()
    }

    private fun getClient(localTokenDataSource: LocalTokenDataSource): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val token = localTokenDataSource.getToken().blockingGet()
            val request: Request =
                chain.request().newBuilder().addHeader("x-api-key", token).build()
            Log.d("HTTP REQUEST", request.toString())
            Log.d("HTTP REQUEST", request.headers().toString())

            chain.proceed(request)
        }

        return httpClient.build()
    }

}