package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.posting.DeletePosting
import kr.hs.dgsw.stac.domain.usecase.posting.GetAllPostings
import kr.hs.dgsw.stac.domain.usecase.posting.GetPostingById
import kr.hs.dgsw.stac.domain.usecase.posting.PatchPosting
import kr.hs.dgsw.stac.domain.usecase.posting.PostPosting
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providePostingUseCases(postingRepository: PostingRepository): PostingUseCases =
        PostingUseCases(
            getAllPostings = GetAllPostings(postingRepository),
            postPosting = PostPosting(postingRepository),
            getPostingById = GetPostingById(postingRepository),
            deletePosting = DeletePosting(postingRepository),
            patchPosting = PatchPosting(postingRepository)
        )
}
