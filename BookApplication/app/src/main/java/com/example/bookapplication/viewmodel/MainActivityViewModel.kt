package com.example.bookapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.model2.BlogModel
import com.example.bookapplication.model2.Item
import com.example.bookapplication.reprository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel() : ViewModel(){
    val mutableLiveData = MutableLiveData<List<Item>>()
    val repository = Repository()
    /*
    Обычный View Model
     */
    fun getRequest(){
        repository.getClient()?.enqueue(object : Callback<List<Item>>{
            override fun onResponse(
                call: Call<List<Item>>,
                response: Response<List<Item>>

            ) {
                mutableLiveData.postValue(response.body())
                Log.d("TAG" , response.body().toString())
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.i("MyTag", "$t")
            }

        })
    }
}