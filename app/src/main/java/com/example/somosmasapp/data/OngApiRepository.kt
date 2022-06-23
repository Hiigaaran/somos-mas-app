package com.example.somosmasapp.data

import com.example.somosmasapp.data.dto.Login
import com.example.somosmasapp.data.dto.News
import com.example.somosmasapp.data.dto.Register
import com.example.somosmasapp.data.dto.UserRegister

class OngApiRepository(private val ongApiDatasource: OngApiDatasource) {
    fun doRegister(body: Register, listener: ResponseListener<UserRegister>) {
        this.ongApiDatasource.doRegister(body, listener)
    }

    fun doLogin(body: Login, listener: ResponseListener<UserRegister>) {
        this.ongApiDatasource.doLogin(body, listener)
    }

    fun getNews(listener: ResponseListener<ArrayList<News>>) {
        this.ongApiDatasource.getNews(listener)
    }
}