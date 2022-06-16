package com.example.somosmasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.somosmasapp.R
import com.example.somosmasapp.databinding.WindowLoginBinding
import android.content.Intent


class Login : AppCompatActivity() {

    private lateinit var binding : WindowLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.window_login)
        binding = WindowLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewOlvidarlogin.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}