package com.example.somosmasapp.data.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


class ValidaPass(private val Password1 : EditText,private val Password2 : EditText, private val listener : (isValidpass : Boolean)->Unit) : TextWatcher {
        //val password1 = Password1
        //val password2 = Password2
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
        override fun afterTextChanged(s: Editable?) {

                if(Password1.text.toString()!=Password2.text.toString()){
                        Password2.setError("Las contraseñas no coinciden")
                        listener.invoke(false)
                }
                else{
                        listener.invoke(true)
                }

        }

}
