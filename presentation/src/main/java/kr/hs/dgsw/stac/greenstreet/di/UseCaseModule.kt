package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.post.GetListPosting
import kr.hs.dgsw.stac.domain.usecase.post.GetListPostingTest
import kr.hs.dgsw.stac.domain.usecase.post.PostingUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providePostingUseCases(postingRepository: PostingRepository): PostingUseCases =
        PostingUseCases(
            getListPosting = GetListPosting(postingRepository),
            getListPostingTest = GetListPostingTest(postingRepository)
        )
}
