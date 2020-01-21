package com.karzek.funnycats.domain

import com.karzek.funnycats.domain.GetRandomCatUseCase.Input
import com.karzek.funnycats.domain.GetRandomCatUseCase.Output
import com.karzek.funnycats.domain.common.BaseObservableUseCase
import com.karzek.funnycats.domain.common.BaseUseCase
import com.karzek.funnycats.domain.model.CatImage

interface GetRandomCatUseCase :BaseObservableUseCase<Input, Output> {

    class Input: BaseUseCase.Input

    sealed class Output: BaseUseCase.Output {
        data class Success(val catImage: CatImage) : Output()
        object Error : Output()
    }

}