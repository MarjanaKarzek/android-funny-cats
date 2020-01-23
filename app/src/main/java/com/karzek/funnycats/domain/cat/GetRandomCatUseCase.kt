package com.karzek.funnycats.domain.cat

import com.karzek.funnycats.domain.cat.GetRandomCatUseCase.Input
import com.karzek.funnycats.domain.common.BaseSingleUseCase
import com.karzek.funnycats.domain.common.BaseUseCase
import com.karzek.funnycats.domain.model.CatImage

interface GetRandomCatUseCase : BaseSingleUseCase<Input, BaseUseCase.Output> {

    class Input : BaseUseCase.Input

    data class Success(val catImage: CatImage) : BaseUseCase.Output

}