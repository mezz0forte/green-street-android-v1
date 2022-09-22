package kr.hs.dgsw.stac.greenstreet.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kr.hs.dgsw.stac.data.util.Constants
import kr.hs.dgsw.stac.greenstreet.widget.GreenStreetApplication
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    internal fun provideTokenInterceptor(): TokenInterceptor = TokenInterceptor()

    @Provides
    @Singleton
    fun provideHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        //val errorResponseInterceptor = ErrorResponseInterceptor()

        val okhttpBuilder = OkHttpClient().newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(tokenInterceptor)
        //    .addInterceptor(errorResponseInterceptor)

        return okhttpBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .build()


    class TokenInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val accessToken = GreenStreetApplication.prefs.getAccessToken()
            val newRequest = request().newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()

            proceed(newRequest)
        }
    }
}
