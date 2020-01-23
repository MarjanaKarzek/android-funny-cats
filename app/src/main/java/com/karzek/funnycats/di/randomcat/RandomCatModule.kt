package com.karzek.funnycats.di.randomcat

import com.karzek.funnycats.data.cat.CatRepository
import com.karzek.funnycats.data.cat.CatRepositoryImpl
import com.karzek.funnycats.data.cat.RemoteCatDataSource
import com.karzek.funnycats.data.cat.RemoteCatDataSourceImpl
import com.karzek.funnycats.domain.cat.GetRandomCatUseCase
import com.karzek.funnycats.domain.cat.GetRandomCatUseCaseImpl
import com.karzek.funnycats.http.CatApiService
import dagger.Module
import dagger.Provides

@Module
class RandomCatModule {

    @Provides
    fun provideRemoteCatDataSource(catApiService: CatApiService): RemoteCatDataSource {
        return RemoteCatDataSourceImpl(catApiService)
    }

    @Provides
    fun provideCatRepository(remoteCatDataSource: RemoteCatDataSource): CatRepository {
        return CatRepositoryImpl(remoteCatDataSource)
    }

    @Provides
    fun provideGetRandomCatUseCase(catRepository: CatRepository): GetRandomCatUseCase {
        return GetRandomCatUseCaseImpl(
            catRepository
        )
    }
}