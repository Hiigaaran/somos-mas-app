package com.example.somosmasapp.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.somosmasapp.R
import com.example.somosmasapp.data.dto.Register
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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.signup.setOnClickListener {
            onRegisterButtonClicked()
        }
    }

    fun onRegisterButtonClicked() {
        var register = Register(
            binding.textInputName.text.toString(),
            binding.textInputEmail.text.toString(),
            binding.textInputPassword.text.toString()
        )
        viewModel.doRegister(register)

        viewModel.success.observe(this) {
            value ->
            if (null != value) {
                if (value) {
                    Toast.makeText(this,  "Registro Exitoso", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Registro Fallido", Toast.LENGTH_LONG).show()
                }
            }
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}