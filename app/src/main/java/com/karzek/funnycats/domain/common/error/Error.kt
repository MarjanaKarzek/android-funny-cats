package com.karzek.funnycats.domain.common.error

import com.karzek.funnycats.domain.common.BaseUseCase

sealed class Errors: BaseUseCase.Output

object ErrorUnknown : Errors()
object ErrorNetwork : Errors()
