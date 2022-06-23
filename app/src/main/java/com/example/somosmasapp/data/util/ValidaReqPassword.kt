package com.example.somosmasapp.data.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Pattern

class ValidaReqPassword (private val Password1 : EditText, private val listener : (Pass1 : String,isValidpass : Boolean)->Unit) : TextWatcher {
    //val password1 = Password1
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

        if (!ValidaPassword(s.toString())) {
            Password1.setError("No cumple con los requisitos de Password")
            listener.invoke(Password1.text.toString(),false)
        }
        else{
            listener.invoke(Password1.text.toString(),true)
        }

    }

    fun ValidaPassword(pass : String) :Boolean{

            val passwordRegex =  Pattern.compile(
                "^\\w\\w\\w\\w+$"
            )

            return if(pass.isNullOrBlank()) {
                false
            } else passwordRegex.matcher(pass).matches()

    }
}