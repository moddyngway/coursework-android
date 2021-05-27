package com.example.bookapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookapplication.databinding.ActivityMainBinding
import com.example.bookapplication.reprository.Repository
import com.example.bookapplication.ui.adapter.MyAdapter
import com.example.bookapplication.viewmodel.MainActivityViewModel
import com.example.bookapplication.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainActivityViewModel by lazy { ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java) }
    private val viewModelFactory : ViewModelFactory by lazy { ViewModelFactory(Repository()) }
    lateinit var myadapter: MyAdapter
    lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myadapter = MyAdapter()
        mainViewModel.getRequest()
        setUpRecycler()
        mainViewModel.mutableLiveData.observe(this, {t->
            myadapter.setList(t)
        })
    }
    private fun setUpRecycler(){
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = MyAdapter()
    }
}