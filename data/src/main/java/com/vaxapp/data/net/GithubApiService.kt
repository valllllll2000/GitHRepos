package com.vaxapp.data.net

import com.vaxapp.data.entity.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface GithubApiService {

    @GET("https://api.github.com/search/repositories?q=android&sort=stars&order=desc")
    fun getRepos(): Call<ApiResponse>
}
