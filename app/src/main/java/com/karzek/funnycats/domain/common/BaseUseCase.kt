package com.karzek.funnycats.domain.common

import com.karzek.funnycats.domain.common.BaseUseCase.Input
import com.karzek.funnycats.domain.common.BaseUseCase.Output

interface BaseUseCase<IN : Input, OUT : Output> {
    interface Input
    interface Output
}