package com.example.somosmasapp.views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.somosmasapp.R
import com.example.somosmasapp.data.dto.Register
import com.example.somosmasapp.data.util.CorreoWatcher
import com.example.somosmasapp.data.util.ValidaNombre
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
        binding.signup.setBackgroundColor(Color.GRAY)
        binding.signup.setOnClickListener {
            onRegisterButtonClicked()
        }
        val Watcher = CorreoWatcher(binding.textInputEmail)
        binding.textInputEmail.addTextChangedListener(Watcher)
        val Watcher2 = ValidaNombre(binding.textInputName,)
        binding.textInputName.addTextChangedListener(Watcher2)
        
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
                    onSuccessfullRegister()
                } else {
                    Toast.makeText(this, "Registro Fallido", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun onSuccessfullRegister() {
        val alertDialog = AlertDialog.Builder(this)
        val okDialog = layoutInflater.inflate(R.layout.signup_dialog, null)
        alertDialog.setView(okDialog)
        alertDialog.create().show()

        val okButton: Button = okDialog.findViewById(R.id.okSignupBtn)
        okButton.setOnClickListener {
            onDialogOkBtnClicked()
        }
    }

    fun onDialogOkBtnClicked() {
        val intent = Intent(this, Login::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}