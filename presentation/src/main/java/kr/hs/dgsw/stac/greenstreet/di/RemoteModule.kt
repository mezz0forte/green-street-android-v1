package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.data.network.remote.PostingRemote
import kr.hs.dgsw.stac.data.network.service.PostingService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun providePostingRemote(retrofit: Retrofit): PostingRemote =
        PostingRemote(retrofit.create(PostingService::class.java))

}