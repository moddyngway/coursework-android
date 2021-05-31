package com.example.bookapplication.data

import com.example.bookapplication.model2.BookModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyRequest {
@GET("volumes")
fun getBooks(@Query("q") q:String, @Query("maxResults") maxResults:Int, @Query("key") key:String): Call<BookModel>
}
