package com.example.somosmasapp.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.somosmasapp.R
import com.example.somosmasapp.databinding.SignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: SignupBinding
    private val viewModel: SignUpViewModel by viewModels(
        factoryProducer = { SignUpViewModelFactory() }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}