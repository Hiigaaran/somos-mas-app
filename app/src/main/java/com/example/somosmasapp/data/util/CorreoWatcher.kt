package com.example.somosmasapp.data.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Pattern

class CorreoWatcher(private val editCorreo : EditText, private val listener : (Email : String,isValid : Boolean)->Unit) : TextWatcher {
        //val textView = findViewById<View>(R.id.titulo1) as TextView



        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?){
            val correoIngresado = s.toString()
            if(!validarEmail(correoIngresado)){
                                editCorreo.setError("Debe ingresar un Correo valido")
                                listener.invoke(correoIngresado,false)
                                }
            else{
                listener.invoke(correoIngresado,true)
            }
        }


    fun validarEmail(email : String ) : Boolean {

        var patroncorreo : Pattern=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

        return patroncorreo.matcher(email).matches()
    }
}

