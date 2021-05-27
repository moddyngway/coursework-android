package com.example.bookapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.model.BookModel
import com.example.bookapplication.reprository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(val repository: Repository) : ViewModel(){
    val mutableLiveData = MutableLiveData<List<BookModel>>()
    fun getRequest(){
        repository.getClient()?.enqueue(object : Callback<List<BookModel>>{
            override fun onResponse(
                call: Call<List<BookModel>>,
                response: Response<List<BookModel>>
            ) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<BookModel>>, t: Throwable) {
                Log.i("MyTag", "$t")
            }

        })
    }
}