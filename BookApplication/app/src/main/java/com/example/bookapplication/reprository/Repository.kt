package com.example.bookapplication.reprository

import com.example.bookapplication.data.MyClient

class Repository {
    /*
    указываю сколько элементов получить и API key
     */
    fun getClient(q: String) = MyClient.getInstanceOfMyRequest()?.getBooks(q, 5, "AIzaSyDNpo36bF-hhoGzBDEyLMqIllgfuLmg00I")
}