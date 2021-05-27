package com.example.bookapplication.data

import com.example.bookapplication.model.BookModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyRequest {
@GET("volumes?")
fun getBooks(@Query("q") q:String?): Call<List<BookModel>>
}