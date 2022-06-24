package com.example.somosmasapp.views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.somosmasapp.R
import com.example.somosmasapp.data.dto.Register
import com.example.somosmasapp.data.util.CorreoWatcher
import com.example.somosmasapp.data.util.ValidaNombre
import com.example.somosmasapp.data.util.ValidaPass
import com.example.somosmasapp.data.util.ValidaReqPassword
import com.example.somosmasapp.databinding.SignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: SignupBinding
    private val viewModelValidator: SignUpValidadorViewModel by viewModels()
    private val viewModel: SignUpViewModel by viewModels(
        factoryProducer = { SignUpViewModelFactory() }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.isEnabled = true
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.signup.setBackgroundColor(Color.GRAY)
        binding.signup.setOnClickListener {
            onRegisterButtonClicked()
        }
        val watcher = CorreoWatcher(binding.textInputEmail){ _, isValid->
            viewModelValidator.actualizarEmail(isValid)
        }
        binding.textInputEmail.addTextChangedListener(watcher)


        val watcher2 = ValidaNombre(binding.textInputName) { _, isValid->
            viewModelValidator.actualizarNombre(isValid)
        }
        binding.textInputName.addTextChangedListener(watcher2)

        val watcher3 = ValidaReqPassword(binding.textInputPassword,binding.textInputReEntryPassword){ _, isValid->
            viewModelValidator.actualizarPass1(isValid)
        }
        binding.textInputPassword.addTextChangedListener(watcher3)


        val watcher4 = ValidaPass(binding.textInputPassword,binding.textInputReEntryPassword){isValid->
            viewModelValidator.actualizarPass2(isValid)
        }
        binding.textInputReEntryPassword.addTextChangedListener(watcher4)

        //observador de variable para cuando cambia el valor
        viewModelValidator.validadorBoton.observe(this){ value->
            binding.signup.isEnabled = value
            if(value){binding.signup.setBackgroundColor(Color.RED)}
            else{
                binding.signup.setBackgroundColor(Color.GRAY)
            }
        }

        binding.signin.setOnClickListener {
            val intent = Intent(this, Login::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
        }
    //passwordconfirm

    }

    private fun onRegisterButtonClicked() {
        binding.signup.isEnabled = false
        val register = Register(
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
                    //Toast.makeText(this, "Registro Fallido", Toast.LENGTH_LONG).show().
                    showErrorDialog()
                    //Toast.makeText(this, "Registro Fallido", Toast.LENGTH_LONG).show()
                    binding.signup.isEnabled = true
                }
            }
        }
    }

    private fun onSuccessfullRegister() {
        val alertDialog = AlertDialog.Builder(this)
        val okDialog = layoutInflater.inflate(R.layout.signup_dialog, null)
        alertDialog.setView(okDialog)
        alertDialog.create().show()

        val okButton: Button = okDialog.findViewById(R.id.okSignupBtn)
        okButton.setOnClickListener {
            onDialogOkBtnClicked()
        }
    }

    private fun onDialogOkBtnClicked() {
        /*val intent = Intent(this, Lo::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
        }*/
        binding.signup.isEnabled = true
        this.finish()
        //startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun showErrorDialog(){
        val alertDialog = AlertDialog.Builder(this)
        val errDialog = layoutInflater.inflate(R.layout.signup_error_mensaje, null)
        alertDialog.setView(errDialog)
        val dialog = alertDialog.create()
        dialog.show()

        val okButton: Button = errDialog.findViewById(R.id.errorsignupBtn)
        okButton.setOnClickListener {
            dialog.dismiss()
            /*val intent = Intent(this, com.example.somosmasapp.views.Login::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
            }*/
            //this.finish()
            //startActivity(intent)
        }
    }
}