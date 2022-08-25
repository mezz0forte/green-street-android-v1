package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.data.mapper.PostingMapper
import kr.hs.dgsw.stac.data.repository.PostingRepositoryImpl
import kr.hs.dgsw.stac.data.util.service
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePostingRepository(retrofit: Retrofit, postingMapper: PostingMapper): PostingRepository =
        PostingRepositoryImpl(retrofit.service(), postingMapper)
}
