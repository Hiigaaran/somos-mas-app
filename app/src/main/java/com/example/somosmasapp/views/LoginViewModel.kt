package com.example.somosmasapp.views

import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*
import com.example.somosmasapp.data.dto.Login

class LoginViewModel(private val repository: OngApiRepository): ViewModel() {
    val blockButton = MutableLiveData<Boolean>(false)
    val success = MutableLiveData<Boolean>(null)
    val error = MutableLiveData<String>(null)
    val errors = MutableLiveData<Errors?>(null)
    val message = MutableLiveData<String>(null)
    val user = MutableLiveData<User>(null)
    val token = MutableLiveData<String>(null)

    private fun checkPassword(pass:String):Boolean{
        val passwordRegex =  Pattern.compile(
            "^\\w\\w\\w\\w+$"
        )

        return if(pass.isNullOrBlank()) {
            false
        } else passwordRegex.matcher(pass).matches()
    }

    private fun checkEmail(email:String):Boolean{
        return if(email.isNullOrBlank()){
            false
        } else PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun check(email: String,pass: String){
        val resultado = checkEmail(email) && checkPassword(pass)
        blockButton.value = !resultado

    }

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
                error.value = response.error
                success.value = response.success
                message.value = response.message
            }

            override fun onError(repositoryError: RepositoryError) {
                errors.value = repositoryError.errors
            }
        })
    }
}