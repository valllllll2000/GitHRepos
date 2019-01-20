package com.vaxapp.data

import android.util.Log
import retrofit2.Call
import retrofit2.Callback


class ReposDataSource {

    private val restApi = RestApi()

    fun getRepos() {
        restApi.getRepos().enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e(TAG, "Error loading repos", t)
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Log.d(TAG, "response: $response");
            }
        })
    }

    companion object {

        private val TAG = "ReposDataSource"
    }
}