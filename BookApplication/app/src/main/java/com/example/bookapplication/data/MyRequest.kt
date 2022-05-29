package com.example.bookapplication.data

import com.example.bookapplication.model2.BlogModel
import com.example.bookapplication.model2.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyRequest {
@GET("blogs/")
fun getBooks(): Call<List<Item>>
}
