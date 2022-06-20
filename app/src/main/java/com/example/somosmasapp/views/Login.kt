package com.example.somosmasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.somosmasapp.data.dto.Login
import com.example.somosmasapp.R
import com.example.somosmasapp.databinding.WindowLoginBinding


class Login : AppCompatActivity() {

    private lateinit var binding : WindowLoginBinding

    private val viewModel: LoginViewModel by viewModels(
        factoryProducer = { LoginViewModelFactory() }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.window_login)
        binding = WindowLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharePref = this.getSharedPreferences(this.getString(R.string.preference_file_key), MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePref.edit()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.buttonEntrarlogin.setOnClickListener{
            onLoginButtonClicked(editor)
        }

        binding.textViewOlvidarlogin.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }


    }

    fun onLoginButtonClicked(editor: SharedPreferences.Editor){
        val login = Login(
            this.binding.editEmaillogin.text.toString(),
            this.binding.editPasswordlogin.text.toString()
        )

        viewModel.doLogin(login)

        viewModel.success.observe(this) { value ->
            if (null != value) {
                if (value) {
                    saveUser(editor)
                } else {
                    showErrorDialog()
                }
            }
        }
    }

    fun saveUser(editor : SharedPreferences.Editor){
        editor.putString("user",viewModel.user.value.toString())
        editor.putString("token",viewModel.token.value.toString())
        editor.apply()
        Toast.makeText(this, "Login OK", Toast.LENGTH_LONG).show()
    }

    fun showErrorDialog(){
        val alertDialog = AlertDialog.Builder(this)
        val errDialog = layoutInflater.inflate(R.layout.window_loginerror, null)
        val textView = errDialog.findViewById<TextView>(R.id.LoginErrorMsg)
        textView.text = "Login Fallido. Intente nuevamente."
        alertDialog.setView(errDialog)
        alertDialog.create().show()

        val okButton: Button = errDialog.findViewById(R.id.okLoginBtn)
        okButton.setOnClickListener {
            val intent = Intent(this, com.example.somosmasapp.views.Login::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
            }
            startActivity(intent)
        }
    }
}