package com.example.somosmasapp.views

import android.content.Context
import android.provider.Settings.Global.getString
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.R
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*
import com.example.somosmasapp.data.dto.Login

class LoginViewModel(private val repository: OngApiRepository): ViewModel() {
    val success = MutableLiveData(false)
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
                println ("success: " + response.success)
                if (response.success) {
                    success.value = response.success
                    println("success 2: " + success.value)
                    message.value = response.message
                    user.value = response.data.user
                    token.value = response.data.token
                }else{
                    success.value = false
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