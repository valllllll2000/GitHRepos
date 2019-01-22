package com.vaxapp.data.net

import com.vaxapp.data.entity.ApiResponse
import retrofit2.Call
import retrofit2.Retrofit

class RestApi(private val retrofit: Retrofit) {

    fun getRepos(): Call<ApiResponse> {
        return retrofit.create(GithubApiService::class.java).getRepos()
    }
}
