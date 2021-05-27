package com.example.bookapplication.reprository

import com.example.bookapplication.data.MyClient

class Repository {
    fun getClient() = MyClient.getInstanceOfMyRequest()?.getBooks("java")
}