package com.vaxapp.repos

import com.vaxapp.data.BuildConfig
import com.vaxapp.data.datasource.ReposDataSource
import com.vaxapp.data.net.RestApi
import com.vaxapp.data.repository.RepoDataRepository
import com.vaxapp.domain.interactor.GetReposUseCase
import com.vaxapp.domain.repository.RepoRepository
import com.vaxapp.repos.list.viewmodel.RepoListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    // viewModel
    viewModel { RepoListViewModel(get()) }

    // domain
    single { provideGetReposUseCase(get()) }
    single<RepoRepository> { provideRepoRepository(get()) }

    // data
    single { provideRepoDataSource(get()) }
    single { provideRestApi(get()) }
    single { provideRetrofit() }
}

fun provideRestApi(retrofit: Retrofit) = RestApi(retrofit)

fun provideRepoDataSource(restApi: RestApi) = ReposDataSource(restApi)

fun provideRepoRepository(reposDataSource: ReposDataSource) = RepoDataRepository(reposDataSource)

fun provideGetReposUseCase(repoRepository: RepoRepository) = GetReposUseCase(repoRepository)

fun provideRetrofit(): Retrofit {
    val interceptor = HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .build()

    return Retrofit.Builder()
        .client(httpClient)
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
