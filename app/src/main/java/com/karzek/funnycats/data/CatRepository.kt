package com.karzek.funnycats.data

import com.karzek.funnycats.domain.model.CatImage
import io.reactivex.Single
import java.net.URL

class CatRepository(
    private val remoteCatDataSource: RemoteCatDataSource
) {

    fun getCatImages(): Single<List<CatImage>> {
        return remoteCatDataSource.getCatImages()
            .map {
                it.map { catImageResponse -> CatImage(URL(catImageResponse.url)) }
            }
    }

}