package com.example.bookapplication.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapplication.R

import com.example.bookapplication.model2.Item

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var myList = listOf<Item?>()

    fun setList(myList : List<Item?>){
        this.myList = myList
        notifyDataSetChanged()
    }

    lateinit var context:Context

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title_textview: TextView by lazy { itemView.findViewById(R.id.title) }
        val category_textview: TextView = itemView.findViewById(R.id.category)
        val text_textview: TextView = itemView.findViewById(R.id.text)
        val image: ImageView = itemView.findViewById(R.id.image)
//
//        fun myFun(item: Item){
//            title_textview.text = item.title
//            .text = item.category_str
//        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        val vh = MyViewHolder(v)
        context = parent.context

        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myList1 = myList[position]
        holder.title_textview.text = myList1?.title
        holder.text_textview.text = myList1?.text
        holder.category_textview.text = myList1?.category_str

//        Glide.get(holder.image.context)
        Glide.with(holder.image)
            .load(myList1?.image)
            .into(holder.image)

        /*
        в рейтинге место 0 будет показан N/A
         */
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}