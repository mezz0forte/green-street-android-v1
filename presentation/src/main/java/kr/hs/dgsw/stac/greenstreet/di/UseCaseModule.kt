package kr.hs.dgsw.stac.greenstreet.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.hs.dgsw.stac.domain.repository.PostingRepository
import kr.hs.dgsw.stac.domain.usecase.posting.DeletePosting
import kr.hs.dgsw.stac.domain.usecase.posting.GetAllPostings
import kr.hs.dgsw.stac.domain.usecase.posting.GetPostingById
import kr.hs.dgsw.stac.domain.usecase.posting.PatchPosting
import kr.hs.dgsw.stac.domain.usecase.posting.PostPosting
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import javax.inject.Singleton
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler

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

    @Provides
    internal fun providePostScheduler() = AndroidSchedulers.mainThread()

    @Provides
    internal fun provideUseCaseScheduler(postScheduler: Scheduler) =
        UseCaseScheduler(Schedulers.io(), postScheduler)

    @Provides
    internal fun provideLogger(): Logger = object : Logger {
        override fun log(message: () -> String) {
            Log.d("Logger", message.invoke())
        }

        override fun logError(throwable: () -> Throwable) {
            Log.e("LogError", throwable.invoke().message, throwable.invoke())
        }
    }
}
