package com.karzek.funnycats.domain.token

import com.karzek.funnycats.domain.common.BaseSingleUseCase
import com.karzek.funnycats.domain.common.BaseUseCase
import com.karzek.funnycats.domain.token.UpdateApiTokenUseCase.Input

interface UpdateApiTokenUseCase : BaseSingleUseCase<Input, BaseUseCase.Output> {

    data class Input(val token: String) : BaseUseCase.Input

    object Success : BaseUseCase.Output

}