package com.karzek.funnycats.http

import com.karzek.funnycats.data.model.CatImageResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CatApiService {

    @GET("/v1/images/search")
    fun getCatImages() : Single<List<CatImageResponse>>

}