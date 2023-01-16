package com.samiun.mynews.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.ViewModel
import com.samiun.mynews.network.NewApi
import kotlinx.coroutines.launch

class OverviewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    init {

        getNewsArticles()
    }

    private fun getNewsArticles(){
        viewModelScope.launch {
            try {
                val listResul = NewApi.retrofitService.getArticales()
                _status.value = "Success: ${listResul.size} news retrived"
            }
            catch (e: java.lang.Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}