 package com.example.guideapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guideapp.R
import com.example.guideapp.fragments.adapter.MonumentAdapter
import com.example.guideapp.fragments.adapter.RstAdapter


class Restaurant : Fragment() {

    lateinit var recyclerView: RecyclerView
    var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resturant, container, false)
        recyclerView = view.findViewById(R.id.rst_recycler_view)

        /*
        Здесь я беру данные из values.xml
         */
        val name = resources.getStringArray(R.array.name_rst)
        val location = resources.getStringArray(R.array.location_rst)
        val description = resources.getStringArray(R.array.description_rst)
        val photo = resources.getStringArray(R.array.image_rst)
        val phone = resources.getStringArray(R.array.phone)


        recyclerView.layoutManager = LinearLayoutManager(activity)
        /*
        Здесь я использовал метод адаптера чтоб передать данные, так как один из менторов сказал что через конструктор передавать это плохой тон
        */
        val adapter:RstAdapter by lazy { RstAdapter() }
        adapter.initialize(name, description, photo, location, phone)
        recyclerView.adapter = adapter
        return view
    }



}