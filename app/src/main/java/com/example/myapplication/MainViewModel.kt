package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.DomainResult
import com.example.myapplication.domain.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val networkRepository: NetworkRepository) :
    ViewModel() {

    private var _data = MutableStateFlow<List<String>>(listOf())
    val data = _data.asStateFlow()

    fun getData() {
        var resultData = ArrayList<String>()
        viewModelScope.launch {
            when (val result = networkRepository.getData().first()) {
                is DomainResult.Success -> {
                    result.data.forEach { resultData.add(it.title) }
                }
                is DomainResult.Error -> {
                    Log.d("response", result.error.toString())
                }
            }
            _data.value = resultData.toList()
        }
    }


}