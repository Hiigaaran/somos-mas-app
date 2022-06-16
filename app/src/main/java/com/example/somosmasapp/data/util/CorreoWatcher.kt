package com.example.somosmasapp.data.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Pattern

class CorreoWatcher(editCorreo : EditText,tipoObjeto : String) : TextWatcher {
        //val textView = findViewById<View>(R.id.titulo1) as TextView
        val editCorreo = editCorreo
        val tipoobjeto = tipoObjeto

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            val correoIngresado = s.toString()
            when (tipoobjeto) {
                "Correo" -> if(!validarEmail(correoIngresado)){
                                editCorreo.setError("Debe ingresar un Correo valido")
                                }
                "Nombre" -> if(editCorreo.length()==0){
                            editCorreo.setError("Debe ingresar un Nombre valido")
                            }
                "Password" -> print("x == 2")
                else -> {
                    //contraseña2
                    print("x is neither 1 nor 2")
                }
            }

        }


    fun validarEmail(email : String ) : Boolean {

        var patroncorreo : Pattern=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

        return patroncorreo.matcher(email).matches()
    }
}


