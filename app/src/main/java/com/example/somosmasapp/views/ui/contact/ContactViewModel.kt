package com.example.somosmasapp.views.ui.contact

import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.*

class ContactViewModel (private val repository: OngApiRepository): ViewModel() {

    private val _blockButton = MutableLiveData<Boolean>(true)
    val blockButton: LiveData<Boolean> = _blockButton
    val success = MutableLiveData<Boolean>(null)
    val data = MutableLiveData<Contact>(null)
    val error = MutableLiveData<String>(null)
    val errors = MutableLiveData<Errors?>(null)
    val message = MutableLiveData<String>(null)

    fun check(name: String,email: String,menssage: String){
        val resultado = checkName(name) && checkMessage(menssage) && checkEmail(email)
        _blockButton.value = !resultado
    }

    private fun checkName(name:String):Boolean{
        return !name.isBlank()
    }

    private fun checkEmail(email:String):Boolean{
        return if(email.isNullOrBlank()){
            false
        } else PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun checkMessage(menssage: String):Boolean{
        return !menssage.isBlank()
    }

    fun sendContact(body: Contact){
        success.value = false
        data.value = null

        repository.sendContact(body, object: ResponseListener<Contact> {
            override fun onResponse(response: RepositoryResponse<Contact>) {
                if(null != response && response.success) {
                    data.value = response.data
                    success.value = response.success
                }
            }

            override fun onError(repositoryError: RepositoryError) {
                Toast.makeText(null, "No se pudo enviar mensaje.", Toast.LENGTH_LONG)
            }

        })
    }

}