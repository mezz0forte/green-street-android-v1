package kr.hs.dgsw.stac.greenstreet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.posting.*
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
            patchPosting = PatchPosting(postingRepository),
            uploadFiles = UploadFiles(postingRepository)
        )
}
