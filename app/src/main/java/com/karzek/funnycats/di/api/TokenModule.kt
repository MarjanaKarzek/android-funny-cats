package com.karzek.funnycats.di.api

import android.content.SharedPreferences
import com.karzek.funnycats.data.token.LocalTokenDataSource
import com.karzek.funnycats.data.token.LocalTokenDataSourceImpl
import com.karzek.funnycats.data.token.TokenRepository
import com.karzek.funnycats.data.token.TokenRepositoryImpl
import com.karzek.funnycats.domain.token.IsApiTokenAvailableUseCase
import com.karzek.funnycats.domain.token.IsApiTokenAvailableUseCaseImpl
import com.karzek.funnycats.domain.token.UpdateApiTokenUseCase
import com.karzek.funnycats.domain.token.UpdateApiTokenUseCaseImpl
import dagger.Module
import dagger.Provides


@Module
class TokenModule {

    @Provides
    fun provideIsApiTokenAvailableUseCase(tokenRepository: TokenRepository): IsApiTokenAvailableUseCase {
        return IsApiTokenAvailableUseCaseImpl(tokenRepository)
    }

    @Provides
    fun provideUpdateApiTokenUseCase(tokenRepository: TokenRepository): UpdateApiTokenUseCase {
        return UpdateApiTokenUseCaseImpl(tokenRepository)
    }

    @Provides
    fun provideTokenRepository(localTokenDataSource: LocalTokenDataSource): TokenRepository {
        return TokenRepositoryImpl(localTokenDataSource)
    }

    @Provides
    fun provideLocalTokenDataSource(sharedPreferences: SharedPreferences): LocalTokenDataSource {
        return LocalTokenDataSourceImpl(sharedPreferences)
    }

}