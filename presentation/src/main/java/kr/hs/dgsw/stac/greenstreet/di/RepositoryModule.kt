package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.data.repository.PostingRepositoryImpl
import kr.hs.dgsw.stac.data.util.service
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import retrofit2.Retrofit
import javax.inject.Singleton
import kr.hs.dgsw.stac.data.repository.SolutionRepositoryImpl
import kr.hs.dgsw.stac.domain.repository.SolutionRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePostingRepository(retrofit: Retrofit): PostingRepository =
        PostingRepositoryImpl(retrofit.service())

    @Provides
    @Singleton
    fun provideSolutionRepository(retrofit: Retrofit): SolutionRepository =
        SolutionRepositoryImpl(retrofit.service())

}
