package com.example.somosmasapp.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpValidadorViewModel : ViewModel(){
    var validadorBoton = MutableLiveData<Boolean>(false)

    var nombreValidator : Boolean = false
    var emailValidator: Boolean = false
    var passwordValidator: Boolean = false
    var password2Validator: Boolean = false

    fun compararValidadores(){

        validadorBoton.value = nombreValidator && emailValidator && passwordValidator && password2Validator

    }

    fun actualizarEmail(isValueEmail : Boolean){

        emailValidator = isValueEmail
        compararValidadores()

    }
    fun actualizarNombre(isValueName : Boolean){

        nombreValidator = isValueName
        compararValidadores()

    }
    fun actualizarPass1(isValuePass : Boolean){

        passwordValidator = isValuePass
        compararValidadores()

    }
    fun actualizarPass2(isValuePass2 : Boolean){

        password2Validator = isValuePass2
        compararValidadores()

    }
}