package com.vaxapp.data.datasource

import com.vaxapp.data.entity.ApiResponse
import com.vaxapp.data.entity.toDomain
import com.vaxapp.data.net.RestApi
import com.vaxapp.domain.entity.DomainRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposDataSource {

    private val restApi = RestApi()

    fun getRepos(onSuccess: (List<DomainRepo>) -> Unit, onError: () -> Unit) {
        restApi.getRepos().enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                onError.invoke()
            }

            override fun onResponse(call: Call<ApiResponse>?, apiResponse: Response<ApiResponse>?) {
                apiResponse?.let {
                    when {
                        it.isSuccessful -> onSuccess.invoke(toDomain(it.body()))
                        else -> onError.invoke()
                    }
                } ?: run { onError.invoke() }
            }
        })
    }
}
