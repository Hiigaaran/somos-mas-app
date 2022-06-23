package com.example.somosmasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import androidx.activity.viewModels
import com.example.somosmasapp.R
import androidx.core.widget.addTextChangedListener
import com.example.somosmasapp.databinding.ContactoBinding


class Contacto : AppCompatActivity() {

    private lateinit var binding : ContactoBinding

    private val viewModel: ContactoViewModel by viewModels(
        //factoryProducer = { LoginViewModelFactory() }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.window_login)
        binding = ContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharePref =
            this.getSharedPreferences(this.getString(R.string.preference_file_key), MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePref.edit()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.textInputName.addTextChangedListener {
            viewModel.check(
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                binding.textInputMensaje.text.toString()
            )
        }
        binding.textInputEmail.addTextChangedListener {
            viewModel.check(
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                binding.textInputMensaje.text.toString()
            )
        }

        binding.textInputMensaje.addTextChangedListener {
            viewModel.check(
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                binding.textInputMensaje.text.toString()
            )
        }

        binding.enviarMje.setOnClickListener {
            onContactButtonClicked(editor)
        }

        binding.enviarMje.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            binding.enviarMje.isEnabled = false
        }

        viewModel.blockButton.observe(this){ value->
            binding.enviarMje.isEnabled = !value
        }
    }

    private fun onContactButtonClicked(editor: SharedPreferences.Editor){

    }
}