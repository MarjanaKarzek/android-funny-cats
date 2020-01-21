package com.karzek.funnycats.domain.common

import io.reactivex.Observable

interface BaseObservableUseCase<Input : BaseUseCase.Input, Output : BaseUseCase.Output> : BaseUseCase<Input, Output> {
    fun execute(input: Input): Observable<Output>
}