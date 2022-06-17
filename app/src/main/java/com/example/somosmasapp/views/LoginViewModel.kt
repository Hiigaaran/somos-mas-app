package com.example.somosmasapp.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*
import com.example.somosmasapp.data.dto.Login

class LoginViewModel(private val repository: OngApiRepository): ViewModel() {
    val success = MutableLiveData<Boolean>(null)
    val error = MutableLiveData<Errors?>(null)
    val message = MutableLiveData<String>(null)
    val user = MutableLiveData<User>(null)
    val token = MutableLiveData<String>(null)


    fun doLogin(body: Login){
        success.value = null
        error.value = null
        message.value = null
        user.value = null
        token.value = null

        repository.doLogin(body, object : ResponseListener<UserRegister>{
            override fun onResponse(response: RepositoryResponse<UserRegister>) {
                if (response.success) {
                    user.value = response.data.user
                    token.value = response.data.token
                }
                success.value = response.success
                message.value = response.message
                error.value = response.errors
                println("ERROR " + error.value)
            }

            override fun onError(repositoryError: RepositoryError) {
                error.value = repositoryError.errors
            }
        })
    }
}