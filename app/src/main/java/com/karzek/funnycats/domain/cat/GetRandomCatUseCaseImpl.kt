package com.karzek.funnycats.domain.cat

import com.karzek.funnycats.data.cat.CatRepository
import com.karzek.funnycats.domain.cat.GetRandomCatUseCase.Input
import com.karzek.funnycats.domain.cat.GetRandomCatUseCase.Success
import com.karzek.funnycats.domain.common.BaseUseCase.Output
import com.karzek.funnycats.domain.common.error.ErrorUnknown
import io.reactivex.Single

class GetRandomCatUseCaseImpl(private val catRepository: CatRepository) :
    GetRandomCatUseCase {

    override fun execute(input: Input): Single<Output> {
        return catRepository.getCatImages()
            .map {
                Success(it.first()) as Output
            }
            .onErrorReturn {
                it.printStackTrace()
                ErrorUnknown
            }
    }

}