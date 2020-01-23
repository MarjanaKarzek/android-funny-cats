package com.karzek.funnycats.data.token

import io.reactivex.Completable
import io.reactivex.Single

class TokenRepositoryImpl(private val localTokenDataSource: LocalTokenDataSource) :
    TokenRepository {

    override fun isTokenAvailable(): Single<Boolean> {
        return localTokenDataSource.isTokenAvailable()
    }

    override fun updateToken(token: String): Completable {
        return localTokenDataSource.setToken(token)
    }

}