package com.vaxapp.data

import retrofit2.Call
import retrofit2.http.GET

interface GithubApiService {

    @GET("https://api.github.com/search/repositories?q=android&sort=stars&order=desc")
    fun getRepos(): Call<Response>
}