package com.example.somosmasapp.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.Errors
import com.example.somosmasapp.data.dto.Register
import com.example.somosmasapp.data.dto.RepositoryError
import com.example.somosmasapp.data.dto.RepositoryResponse

class SignUpViewModel(private val repository: OngApiRepository): ViewModel() {
    val success = MutableLiveData<Boolean>(false)
    val message = MutableLiveData<String>(null)
    val error = MutableLiveData<Errors?>(null)

    fun doRegister(body: Register) {
        message.value = null
        success.value = false
        error.value = null

        repository.doRegister(body, object: ResponseListener<Void> {
            override fun onResponse(response: RepositoryResponse<Void>) {
                val responseRegister = response
                if (null != responseRegister && responseRegister.success) {
                    success.value = response.success
                    message.value = response.message
                }
            }

            override fun onError(repositoryError: RepositoryError) {
                if(null != repositoryError) {
                    error.value = repositoryError.errors
                }
            }

        })
    }
}