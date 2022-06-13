package com.example.somosmasapp.data

import com.example.somosmasapp.data.dto.Login
import com.example.somosmasapp.data.dto.Register
import com.example.somosmasapp.data.dto.RepositoryError
import com.example.somosmasapp.data.dto.RepositoryResponse
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
    fun doRegister(body: Register, listener: ResponseListener<Void>) {
        val service = RetrofitService.instance.create(OngApiService::class.java).doRegister(body)

        service.enqueue(object: Callback<RepositoryResponse<Void>> {
            override fun onResponse(call: Call<RepositoryResponse<Void>>, response: Response<RepositoryResponse<Void>>) {
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

            override fun onFailure(call: Call<RepositoryResponse<Void>>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        "Unexpected Error",
                        null
                    )
                )
            }

        })
    }

    fun doLogin(body: Login, listener: ResponseListener<Void>) {
        val service = RetrofitService.instance.create(OngApiService::class.java).doLogin(body)

        service.enqueue(object: Callback<RepositoryResponse<Void>> {
            override fun onResponse(
                call: Call<RepositoryResponse<Void>>,
                response: Response<RepositoryResponse<Void>>
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

            override fun onFailure(call: Call<RepositoryResponse<Void>>, t: Throwable) {
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