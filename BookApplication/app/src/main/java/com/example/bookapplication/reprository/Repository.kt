package com.example.bookapplication.reprository

import com.example.bookapplication.data.MyClient

class Repository {
    /*
    указываю сколько элементов получить и API key
     */
    fun getClient() = MyClient.getInstanceOfMyRequest()?.getBooks()
}