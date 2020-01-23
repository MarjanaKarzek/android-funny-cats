package com.karzek.funnycats.domain.token

import com.karzek.funnycats.data.token.TokenRepository
import com.karzek.funnycats.domain.common.BaseUseCase
import com.karzek.funnycats.domain.common.error.ErrorUnknown
import com.karzek.funnycats.domain.token.UpdateApiTokenUseCase.Success
import io.reactivex.Single

class UpdateApiTokenUseCaseImpl(private val tokenRepository: TokenRepository) :
    UpdateApiTokenUseCase {

    override fun execute(input: UpdateApiTokenUseCase.Input): Single<BaseUseCase.Output> {
        return tokenRepository.updateToken(input.token)
            .toSingle { Success as BaseUseCase.Output }
            .onErrorReturn {
                ErrorUnknown
            }
    }


}