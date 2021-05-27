package com.example.bookapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.model.BookModel

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var myList = listOf<BookModel>()

    fun setList(myList : List<BookModel>){
        this.myList = myList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name: TextView by lazy { itemView.findViewById(R.id.name) }
        val author: TextView by lazy { itemView.findViewById(R.id.author) }
        val pages: TextView by lazy { itemView.findViewById(R.id.pages) }
        val year: TextView by lazy { itemView.findViewById(R.id.year) }
        val rating: TextView by lazy { itemView.findViewById(R.id.rating) }
        val image: ImageView by lazy { itemView.findViewById(R.id.image) }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater.inflate(R.layout.book_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.author.text = myList[position].items.volumeInfo.publisher
        holder.name.text = myList[position].items.volumeInfo.title
        holder.pages.text = myList[position].items.volumeInfo.date
    }

    override fun getItemCount(): Int {
        return 5
    }
}