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
import kr.hs.dgsw.stac.domain.repository.SolutionRepository
import kr.hs.dgsw.stac.domain.repository.UserRepository
import kr.hs.dgsw.stac.domain.usecase.base.Logger
import kr.hs.dgsw.stac.domain.usecase.base.UseCaseScheduler
import kr.hs.dgsw.stac.domain.usecase.posting.CreatePosting
import kr.hs.dgsw.stac.domain.usecase.posting.CreatePostingSympathy
import kr.hs.dgsw.stac.domain.usecase.posting.DeletePosting
import kr.hs.dgsw.stac.domain.usecase.posting.GetPostingById
import kr.hs.dgsw.stac.domain.usecase.posting.GetPostingsByDistance
import kr.hs.dgsw.stac.domain.usecase.posting.PostingUseCases
import kr.hs.dgsw.stac.domain.usecase.posting.UpdatePosting
import kr.hs.dgsw.stac.domain.usecase.solution.CreateSolution
import kr.hs.dgsw.stac.domain.usecase.solution.GetLatestSolution
import kr.hs.dgsw.stac.domain.usecase.solution.GetSolutionById
import kr.hs.dgsw.stac.domain.usecase.solution.GetSolutionByPostingId
import kr.hs.dgsw.stac.domain.usecase.solution.SolutionUseCases
import kr.hs.dgsw.stac.domain.usecase.user.GetMyInfo
import kr.hs.dgsw.stac.domain.usecase.user.UserUseCases
import javax.inject.Singleton
import kr.hs.dgsw.stac.domain.usecase.posting.GetMyPosting

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providePostingUseCases(postingRepository: PostingRepository, postScheduler: Scheduler, logger: Logger): PostingUseCases =
        PostingUseCases(
            getPostingsByDistance = GetPostingsByDistance(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            createPosting = CreatePosting(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            getPostingById = GetPostingById(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            deletePosting = DeletePosting(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            updatePosting = UpdatePosting(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            createPostingSympathy = CreatePostingSympathy(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            getMyPosting = GetMyPosting(postingRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),

        )

    @Provides
    @Singleton
    fun provideSolutionUseCase(solutionRepository: SolutionRepository, postScheduler: Scheduler, logger: Logger): SolutionUseCases =
        SolutionUseCases(
            createSolution = CreateSolution(solutionRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            getLatestSolution = GetLatestSolution(solutionRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            getSolutionById = GetSolutionById(solutionRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),
            getSolutionByPostingId = GetSolutionByPostingId(solutionRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger)

        )

    @Provides
    @Singleton
    fun provideUserUseCase(userRepository: UserRepository, postScheduler: Scheduler, logger: Logger): UserUseCases =
        UserUseCases(
            getMyInfo = GetMyInfo(userRepository, UseCaseScheduler(Schedulers.io(), postScheduler), logger),

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
