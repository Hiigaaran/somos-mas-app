package com.example.somosmasapp.data

import com.example.somosmasapp.data.dto.RepositoryError
import com.example.somosmasapp.data.dto.RepositoryResponse

interface ResponseListener<T> {

    fun onResponse(response: RepositoryResponse<T>)

    fun onError(repositoryError: RepositoryError)


}