package com.karzek.funnycats.domain.token

import com.karzek.funnycats.domain.common.BaseSingleUseCase
import com.karzek.funnycats.domain.token.IsApiTokenAvailableUseCase.Input
import com.karzek.funnycats.domain.common.BaseUseCase

interface IsApiTokenAvailableUseCase : BaseSingleUseCase<Input, BaseUseCase.Output> {

    class Input: BaseUseCase.Input

    sealed class Output: BaseUseCase.Output {
        data class Success(val available: Boolean) : Output()
    }
}