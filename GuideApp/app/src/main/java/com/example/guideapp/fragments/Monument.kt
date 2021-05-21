 package com.example.guideapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guideapp.R
import com.example.guideapp.fragments.adapter.MonumentAdapter


class Monument : Fragment() {

    lateinit var recyclerView:RecyclerView
    var layoutManager: RecyclerView.LayoutManager? = null

    @SuppressLint("ResourceType")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_monument, container, false)
        recyclerView = view.findViewById(R.id.monument_recycler_view)

        /*
        Здесь я беру данные из values.xml
         */

        val monumentNames = resources.getStringArray(R.array.monument_names)
        val links = resources.getStringArray(R.array.hyperlinks_monuments)
        val images = arrayOf("https://media-cdn.tripadvisor.com/media/photo-s/0d/16/79/9c/caption.jpg", "http://photos.wikimapia.org/p/00/04/59/59/93_full.jpg", "https://media-cdn.tripadvisor.com/media/photo-s/14/aa/2e/eb/lenin-monument.jpg")
        val description = resources.getStringArray(R.array.desc)


        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter:MonumentAdapter by lazy { MonumentAdapter() }
            /*
        Здесь я использовал метод адаптера чтоб передать данные, так как один из менторов сказал что через конструктор передавать это плохой тон
        */
        adapter.initialize(images, description, links , monumentNames)
        recyclerView.adapter = adapter

        return view

    }

}