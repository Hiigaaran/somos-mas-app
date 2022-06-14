package com.example.somosmasapp.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.somosmasapp.data.OngApiDatasource
import com.example.somosmasapp.data.OngApiRepository

class SignUpViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val ongApiDatasource = OngApiDatasource()
        val ongApiRepository = OngApiRepository(ongApiDatasource)
        return SignUpViewModel(ongApiRepository) as T
    }
}