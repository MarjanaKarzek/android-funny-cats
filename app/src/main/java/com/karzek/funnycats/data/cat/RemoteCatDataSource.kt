package com.karzek.funnycats.data.cat

import com.karzek.funnycats.data.model.CatImageResponse
import io.reactivex.Single

/**
 * Created by MarjanaKarzek on 23.01.2020.
 *
 * @author Marjana Karzek
 * @version 1.0
 * @date 23.01.2020
 */
interface RemoteCatDataSource {
    fun getCatImages(): Single<List<CatImageResponse>>
}