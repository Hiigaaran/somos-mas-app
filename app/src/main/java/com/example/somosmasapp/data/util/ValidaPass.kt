package com.example.somosmasapp.data.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


class ValidaPass(Password : EditText) : TextWatcher {
        val password = Password
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            val PassEscrita = s.toString()
        }

}
