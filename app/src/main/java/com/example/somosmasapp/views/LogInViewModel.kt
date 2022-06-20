package com.example.somosmasapp.views

import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LogInViewModel:ViewModel(){
    val blockButton = MutableLiveData<Boolean>(false)
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
}