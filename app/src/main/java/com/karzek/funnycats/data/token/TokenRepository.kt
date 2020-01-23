package com.karzek.funnycats.data.token

import io.reactivex.Completable
import io.reactivex.Single

interface TokenRepository {
    fun isTokenAvailable(): Single<Boolean>
    fun updateToken(token: String): Completable
}