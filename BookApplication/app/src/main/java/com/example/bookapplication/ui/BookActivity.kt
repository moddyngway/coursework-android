package com.example.bookapplication.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.ui.adapter.MyAdapter
import com.example.bookapplication.viewmodel.MainActivityViewModel

class BookActivity : AppCompatActivity() {
    private val mainViewModel: MainActivityViewModel by lazy { ViewModelProvider(this).get(MainActivityViewModel::class.java) }

    lateinit var myadapter: MyAdapter
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        recycler = findViewById(R.id.recycler)
        myadapter = MyAdapter()
        mainViewModel.getRequest()// передаю запрос в параметры будет вводится q это search item
        setUpRecycler() //настройка recycler view
        mainViewModel.mutableLiveData.observe(this) { t ->
            myadapter.setList(t)
        }

        if (!isNetworkAvailable()){
            val toast = Toast.makeText(this, "Please turn on Internet", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
    fun setUpRecycler(){
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = myadapter
        recycler.setHasFixedSize(true)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}