package com.example.somosmasapp.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*
import com.example.somosmasapp.data.dto.Login

class LoginViewModel(private val repository: OngApiRepository): ViewModel() {
    val success = MutableLiveData(false)
    val error = MutableLiveData<Errors?>(null)
    val user = MutableLiveData<User>(null)
    val token = MutableLiveData<String>(null)

    fun doLogin(body: Login){
        success.value = null
        user.value = null
        token.value = null

        repository.doLogin(body, object : ResponseListener<UserRegister>{
            override fun onResponse(response: RepositoryResponse<UserRegister>) {
                //val responseRegister = response
                if (null != response && response.success) {
                    success.value = response.success
                    user.value = response.data.user
                    token.value = response.data.token
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