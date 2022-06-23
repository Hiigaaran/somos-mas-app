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

    fun actualizarEmail(email : Boolean){

        emailValidator = true
        compararValidadores()

    }
    fun actualizarNombre(email : Boolean){

        nombreValidator = true
        compararValidadores()

    }
    fun actualizarPass1(email : Boolean){

        passwordValidator = true
        compararValidadores()

    }
    fun actualizarPass2(email : Boolean){

        password2Validator = true
        compararValidadores()

    }
}