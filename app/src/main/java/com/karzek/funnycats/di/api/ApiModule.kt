package com.karzek.funnycats.di.api

import com.karzek.funnycats.data.token.LocalTokenDataSource
import com.karzek.funnycats.http.CatApiService
import com.karzek.funnycats.http.util.ApiUtil
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun provideCatApiService(localTokenDataSource: LocalTokenDataSource): CatApiService {
        return ApiUtil
            .getRetrofit(localTokenDataSource)
            .create(CatApiService::class.java)
    }

}