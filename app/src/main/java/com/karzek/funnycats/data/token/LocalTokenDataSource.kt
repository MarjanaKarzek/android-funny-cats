package com.karzek.funnycats.data.token

import io.reactivex.Completable
import io.reactivex.Single

interface LocalTokenDataSource {
    fun isTokenAvailable(): Single<Boolean>
    fun getToken(): Single<String>
    fun setToken(token: String): Completable
}