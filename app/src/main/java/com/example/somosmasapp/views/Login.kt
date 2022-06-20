package com.example.somosmasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.util.PatternsCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.databinding.WindowLoginBinding
import java.util.regex.Pattern


class Login : AppCompatActivity() {
    private val viewModel:LogInViewModel by viewModels()
    private lateinit var binding : WindowLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WindowLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrarlogin.isEnabled = false


        binding.editEmaillogin.addTextChangedListener {
            viewModel.check(binding.editEmaillogin.text.toString(),binding.editPasswordlogin.text.toString())
        }
        binding.editPasswordlogin.addTextChangedListener{
            viewModel.check(binding.editEmaillogin.text.toString(),binding.editPasswordlogin.text.toString())
        }

        viewModel.blockButton.observe(this){ value->
            binding.buttonEntrarlogin.isEnabled = !value
        }

    }

}
