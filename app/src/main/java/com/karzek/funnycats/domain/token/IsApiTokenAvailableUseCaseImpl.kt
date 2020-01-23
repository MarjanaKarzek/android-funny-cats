package com.karzek.funnycats.domain.token

import com.karzek.funnycats.data.token.TokenRepository
import com.karzek.funnycats.domain.common.BaseUseCase
import com.karzek.funnycats.domain.common.error.ErrorUnknown
import io.reactivex.Single

class IsApiTokenAvailableUseCaseImpl(private val tokenRepository: TokenRepository) : IsApiTokenAvailableUseCase {

    override fun execute(input: IsApiTokenAvailableUseCase.Input): Single<BaseUseCase.Output> {
        return tokenRepository.isTokenAvailable()
            .map {
                IsApiTokenAvailableUseCase.Output.Success(it) as BaseUseCase.Output
            }
            .onErrorReturn {
                ErrorUnknown
            }
    }


}