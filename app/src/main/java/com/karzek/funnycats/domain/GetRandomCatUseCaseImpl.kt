package com.karzek.funnycats.domain

import com.karzek.funnycats.data.CatRepository
import com.karzek.funnycats.domain.GetRandomCatUseCase.Input
import com.karzek.funnycats.domain.GetRandomCatUseCase.Output
import com.karzek.funnycats.domain.GetRandomCatUseCase.Output.Error
import com.karzek.funnycats.domain.GetRandomCatUseCase.Output.Success
import io.reactivex.Observable
import kotlin.random.Random

class GetRandomCatUseCaseImpl(private val catRepository: CatRepository) : GetRandomCatUseCase {

    override fun execute(input: Input): Observable<Output> {
        return catRepository.getCatImages()
            .toObservable()
            .map {
                val randomIndex = Random.nextInt(1, it.size) - 1
                Success(it[randomIndex]) as Output
            }
            .onErrorReturn {
                Error
            }
    }

}