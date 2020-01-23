package com.karzek.funnycats.data.cat

import com.karzek.funnycats.data.model.CatImageResponse
import com.karzek.funnycats.http.CatApiService
import io.reactivex.Single

class RemoteCatDataSourceImpl(private val catApiService: CatApiService) :
    RemoteCatDataSource {

    override fun getCatImages(): Single<List<CatImageResponse>> {
        return catApiService.getCatImages()
    }

}