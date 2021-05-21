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


class Parks : Fragment() {

    lateinit var recyclerView: RecyclerView
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<MonumentAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_parks, container, false)

        recyclerView = view.findViewById(R.id.park_recycler)

        val parksName = resources.getStringArray(R.array.name_parks)
        val parksImage = resources.getStringArray(R.array.images_parks)
        val parksDescription = resources.getStringArray(R.array.description_parks)
        val parkLocation = resources.getStringArray(R.array.address_parks)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = MonumentAdapter()
        adapter.initialize(parksImage, parksDescription, parkLocation, parksName)
        recyclerView.adapter = adapter

        return view
    }


}