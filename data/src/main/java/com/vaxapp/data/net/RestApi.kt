package com.vaxapp.data.net

import com.vaxapp.data.BuildConfig
import com.vaxapp.data.entity.ApiResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestApi {

    private val service: GithubApiService

    init {

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

        val retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(GithubApiService::class.java)
    }

    fun getRepos(): Call<ApiResponse> {
        return service.getRepos()
    }
}
