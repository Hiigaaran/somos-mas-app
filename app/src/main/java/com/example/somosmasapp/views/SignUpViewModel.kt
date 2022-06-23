package com.example.somosmasapp.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*

class SignUpViewModel(private val repository: OngApiRepository): ViewModel() {
    val success = MutableLiveData<Boolean>(false)
    val message = MutableLiveData<String>(null)
    val user = MutableLiveData<User>(null)
    val token = MutableLiveData<String>(null)
    val error = MutableLiveData<Errors?>(null)

    fun doRegister(body: Register) {
        message.value = null
        success.value = null
        error.value = null
        user.value = null
        token.value = null

        repository.doRegister(body, object: ResponseListener<UserRegister> {
            override fun onResponse(response: RepositoryResponse<UserRegister>) {
                val responseRegister = response
                if (null != responseRegister) {
                    success.value = response.success
                    message.value = response.message
                    user.value = response.data.user
                    token.value = response.data.token
                }
            }

            override fun onError(repositoryError: RepositoryError) {
                if(null != repositoryError) {
                    error.value = repositoryError.errors
                    success.value = false
                }
            }

        })
    }
}