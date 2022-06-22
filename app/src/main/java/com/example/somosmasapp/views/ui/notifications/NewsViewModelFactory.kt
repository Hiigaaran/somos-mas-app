package com.example.somosmasapp.views.ui.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.somosmasapp.data.OngApiDatasource
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.views.SignUpViewModel

class NewsViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val ongApiDatasource = OngApiDatasource()
        val ongApiRepository = OngApiRepository(ongApiDatasource)
        return SignUpViewModel(ongApiRepository) as T
    }
}