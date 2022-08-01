package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.data.repository.PostingRepositoryImpl
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePostingRepository(postingRepositoryImpl: PostingRepositoryImpl): PostingRepository = postingRepositoryImpl

}