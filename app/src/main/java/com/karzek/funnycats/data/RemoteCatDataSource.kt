package com.karzek.funnycats.data

import com.karzek.funnycats.data.model.CatImageResponse
import com.karzek.funnycats.http.CatApiService
import io.reactivex.Single

class RemoteCatDataSource(private val catApiService: CatApiService) {

    fun getCatImages(): Single<List<CatImageResponse>> {
        return catApiService.getCatImages()
    }

}