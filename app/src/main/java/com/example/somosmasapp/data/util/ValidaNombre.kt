package com.example.somosmasapp.data.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class ValidaNombre(NombreUsuario : EditText) : TextWatcher {
    val usuario = NombreUsuario
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        val nombreUsuario = s.toString()
        if(nombreUsuario.length==0){
                usuario.setError("Debe ingresar un Nombre valido")
                }
    }

}