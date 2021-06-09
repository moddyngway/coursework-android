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
        val name: TextView by lazy { itemView.findViewById(R.id.name) }
        val author: TextView = itemView.findViewById(R.id.author)
        val pages: TextView =  itemView.findViewById(R.id.pages)
        val year: TextView =  itemView.findViewById(R.id.year)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val image: ImageView = itemView.findViewById(R.id.image)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        val vh = MyViewHolder(v)
        context = parent.context

        return vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myList1 = myList[position]
        holder.name.text = myList1?.volumeInfo?.title
        holder.author.text = myList1?.volumeInfo?.authors?.get(0)?.toString()
        holder.pages.text = myList1?.volumeInfo?.pageCount?.toString()
        holder.year.text = myList1?.volumeInfo?.publishedDate

        /*
        в рейтинге место 0 будет показан N/A
         */
        if(myList1?.volumeInfo?.averageRating?.toInt() == 0) holder.rating.text = "N/A"
        else holder.rating.text = myList1?.volumeInfo?.averageRating.toString()


        Glide.with(context)
                .load(myList1?.volumeInfo?.imageLinks?.thumbnail)
                .placeholder(R.drawable.load)
                .into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(myList1?.volumeInfo?.previewLink))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}