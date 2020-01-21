package com.karzek.funnycats.ui

import androidx.lifecycle.ViewModel
import com.karzek.funnycats.domain.GetRandomCatUseCase
import com.karzek.funnycats.domain.GetRandomCatUseCase.Input
import com.karzek.funnycats.domain.model.CatImage
import io.reactivex.Observable
import javax.inject.Inject

class CatViewModel : ViewModel() {

    @Inject private lateinit var getRandomCatUseCase: GetRandomCatUseCase

    private var catImage: Observable<CatImage> by lazy {
        getRandomCatUseCase.execute(Input())
    }

}