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
    val data = MutableLiveData<ArrayList<News>>(null)

    fun getNews() {
        success.value = false
        data.value = null

        repository.getNews(object: ResponseListener<ArrayList<News>> {
            override fun onResponse(response: RepositoryResponse<ArrayList<News>>) {
                if(null != response && response.success) {
                    data.value = response.data
                    success.value = response.success
                }
            }

            override fun onError(repositoryError: RepositoryError) {
                Toast.makeText(null, "Error getting imageSlider data", Toast.LENGTH_LONG)
            }

        })
    }

}