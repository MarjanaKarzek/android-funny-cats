package com.karzek.funnycats.data.cat

import com.karzek.funnycats.domain.model.CatImage
import io.reactivex.Single

interface CatRepository {
    fun getCatImages(): Single<List<CatImage>>
}