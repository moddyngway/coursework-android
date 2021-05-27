package com.example.bookapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookapplication.reprository.Repository
import java.lang.IllegalStateException

class ViewModelFactory(val repository:Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(repository) as T
        }
        throw IllegalStateException("WrongClass")
    }

}