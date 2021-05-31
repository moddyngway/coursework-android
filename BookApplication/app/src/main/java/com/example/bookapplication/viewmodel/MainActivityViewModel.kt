package com.example.bookapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.model2.BookModel
import com.example.bookapplication.model2.Item
import com.example.bookapplication.model2.VolumeInfo
import com.example.bookapplication.reprository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel() : ViewModel(){
    val mutableLiveData = MutableLiveData<BookModel>()
    val repository = Repository()
    /*
    Обычный View Model
     */
    fun getRequest(q: String){
        repository.getClient(q)?.enqueue(object : Callback<BookModel>{
            override fun onResponse(
                call: Call<BookModel>,
                response: Response<BookModel>
            ) {
                mutableLiveData.value = response.body()
                Log.d("TAG" , response.body().toString())
            }

            override fun onFailure(call: Call<BookModel>, t: Throwable) {
                Log.i("MyTag", "$t")
            }

        })
    }
}