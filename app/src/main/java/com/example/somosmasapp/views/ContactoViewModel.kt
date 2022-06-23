package com.example.somosmasapp.views

import android.provider.ContactsContract
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*
import com.example.somosmasapp.data.dto.Login

class ContactoViewModel(private val repository: OngApiRepository): ViewModel() {
    val blockButton = MutableLiveData<Boolean>(false)
    val success = MutableLiveData<Boolean>(null)
    val error = MutableLiveData<String>(null)
    val errors = MutableLiveData<Errors?>(null)
    val message = MutableLiveData<String>(null)
    val user = MutableLiveData<User>(null)
    val token = MutableLiveData<String>(null)

    private fun checkName(name:String):Boolean{
        return !name.isBlank()
    }

   private fun checkEmail(email:String):Boolean{
        return if(email.isNullOrBlank()){
            false
        } else PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun checkMessage(menssage: String):Boolean{
        return !menssage.isBlank()
    }

    fun check(name: String,email: String,menssage: String){
        val resultado = checkName(name) && checkMessage(menssage) && checkEmail(email)
        blockButton.value = !resultado
    }


}