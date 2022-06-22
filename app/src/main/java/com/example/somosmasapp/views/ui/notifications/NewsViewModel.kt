package com.example.somosmasapp.views.ui.notifications

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.somosmasapp.data.OngApiRepository
import com.example.somosmasapp.data.ResponseListener
import com.example.somosmasapp.data.dto.News
import com.example.somosmasapp.data.dto.RepositoryError
import com.example.somosmasapp.data.dto.RepositoryResponse

class NewsViewModel(private val repository: OngApiRepository) : ViewModel() {

    val success = MutableLiveData<Boolean>(false)
    val data = MutableLiveData<List<News>>(null)

    fun getNews() {
        success.value = false
        data.value = null

        repository.getNews(object: ResponseListener<List<News>> {
            override fun onResponse(response: RepositoryResponse<List<News>>) {
                if(null != response && response.success) {
                    success.value = response.success
                    data.value = response.data
                }
            }

            override fun onError(repositoryError: RepositoryError) {
                Toast.makeText(null, "Error getting imageSlider data", Toast.LENGTH_LONG)
            }

        })
    }

}