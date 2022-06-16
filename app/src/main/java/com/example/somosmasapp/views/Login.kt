package com.example.somosmasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.activity.viewModels
import com.example.somosmasapp.data.dto.Login
import com.example.somosmasapp.R
import com.example.somosmasapp.databinding.WindowLoginBinding


class Login : AppCompatActivity() {

    private lateinit var binding : WindowLoginBinding

    private val viewModel: LoginViewModel by viewModels(
        factoryProducer = { LoginViewModelFactory() }
    )
    //private var sharePref: SharedPreferences = getSharedPreferences("PREFERENCES", MODE_PRIVATE)
    //private val editor: SharedPreferences.Editor = sharePref.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.window_login)
        binding = WindowLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.buttonEntrarlogin.setOnClickListener{
            onLoginButtonClicked()
        }

        binding.textViewOlvidarlogin.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    fun onLoginButtonClicked(){
        val login = Login(
            this.binding.editEmaillogin.text.toString(),
            this.binding.editPasswordlogin.text.toString()
        )

        viewModel.doLogin(login)

        viewModel.success.observe(this) { value ->
            if (null != value) {
                if (value) {
                    //saveUser()
                } else {
                    Toast.makeText(this, "Login Fallido", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    /*fun saveUser(){
        editor.putString("user",viewModel.user.value.toString())
        editor.putString("token",viewModel.token.value.toString())
        editor.apply()
    }*/
}