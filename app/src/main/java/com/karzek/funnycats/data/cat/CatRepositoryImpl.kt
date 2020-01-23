package com.karzek.funnycats.data.cat

import com.karzek.funnycats.domain.model.CatImage
import io.reactivex.Single
import java.net.URL

class CatRepositoryImpl(
    private val remoteCatDataSource: RemoteCatDataSource
) : CatRepository {

    override fun getCatImages(): Single<List<CatImage>> {
        return remoteCatDataSource.getCatImages()
            .map {
                it.map { catImageResponse -> CatImage(URL(catImageResponse.url)) }
            }
    }

}