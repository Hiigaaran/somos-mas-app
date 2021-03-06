package com.example.somosmasapp.data

import com.example.somosmasapp.data.dto.*
import com.example.somosmasapp.data.util.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * class to manage api calls
 * Resources covered:
 * 1. Login
 * 2. Register
 */
class OngApiDatasource {
    fun doRegister(body: Register, listener: ResponseListener<UserRegister>) {
        val service = RetrofitService.instance.create(OngApiService::class.java).doRegister(body)

        service.enqueue(object: Callback<RepositoryResponse<UserRegister>> {
            override fun onResponse(call: Call<RepositoryResponse<UserRegister>>, response: Response<RepositoryResponse<UserRegister>>) {
                val callResponse = response.body()
                if(response.isSuccessful && null != callResponse) {
                    listener.onResponse(
                        RepositoryResponse(
                            callResponse.success,
                            callResponse.data,
                            callResponse.message,
                            null)
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            callResponse?.message ?: run { "Unexpected Error"},
                            callResponse?.errors
                        )
                    )
                }
            }

            override fun onFailure(call: Call<RepositoryResponse<UserRegister>>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        "Unexpected Error",
                        null
                    )
                )
            }

        })
    }

    fun doLogin(body: Login, listener: ResponseListener<UserRegister>) {
        val service = RetrofitService.instance.create(OngApiService::class.java).doLogin(body)

        service.enqueue(object: Callback<RepositoryResponse<UserRegister>> {
            override fun onResponse(
                call: Call<RepositoryResponse<UserRegister>>,
                response: Response<RepositoryResponse<UserRegister>>
            ) {
                val callResponse = response.body()
                if (response.isSuccessful && null != callResponse) {
                    listener.onResponse(
                        RepositoryResponse(
                            callResponse.success,
                            callResponse.data,
                            callResponse.message,
                            null
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            callResponse?.message ?: run { "Unexpected Error"},
                            callResponse?.errors
                        )
                    )
                }
            }

            override fun onFailure(call: Call<RepositoryResponse<UserRegister>>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        "Unexpected Error",
                        null
                    )
                )
            }

        })
    }
}