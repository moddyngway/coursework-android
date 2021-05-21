package com.example.guideapp.fragments.adapter

import android.content.Context
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.guideapp.R
import com.example.guideapp.fragments.Restaurant

class RstAdapter:RecyclerView.Adapter<RstAdapter.ViewHolder>(){

    fun initialize(name:Array<String>, cusine:Array<String>, photo:Array<String>, location:Array <String>, phone:Array<String>, ){
        this.nameRst = name
        this.cusine = cusine
        this.photo = photo
        this.location = location
        this.phone = phone
    }

    private lateinit var nameRst:Array<String>
    private lateinit var cusine:Array<String>
    private lateinit var photo:Array<String>
    private lateinit var location:Array <String>
    private lateinit var phone:Array<String>
    private lateinit var context: Context

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        val photo:ImageView by lazy {view.findViewById(R.id.rst_main_photo)}
        val name:TextView by lazy {view.findViewById(R.id.rst_name)}
        val cuisine:TextView by lazy { view.findViewById(R.id.desc_r_1) }
        val location: TextView by lazy { view.findViewById(R.id.r_location) }
        val phone:TextView by lazy { view.findViewById(R.id.r_phone) }
        val locationImage:ImageView by lazy { view.findViewById(R.id.location_image) }
        val infoImage:ImageView by lazy { view.findViewById(R.id.info_r) }
        val phoneImage:ImageView by lazy { view.findViewById(R.id.image_phone) }

        // Ленивая иницализация для оптимизации
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item,parent,false)
        val vh = ViewHolder(v)
        context = parent.context

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            if (holder.cuisine.visibility == View.GONE) {

                holder.location.visibility = View.VISIBLE
                holder.phone.visibility = View.VISIBLE
                holder.cuisine.visibility = View.VISIBLE
                holder.locationImage.visibility = View.VISIBLE
                holder.infoImage.visibility = View.VISIBLE
                holder.phoneImage.visibility = View.VISIBLE
                holder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
            } else {
                holder.location.visibility = View.GONE
                holder.phone.visibility = View.GONE
                holder.cuisine.visibility = View.GONE
                holder.locationImage.visibility = View.GONE
                holder.infoImage.visibility = View.GONE
                holder.phoneImage.visibility = View.GONE
                holder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            }
        }
        holder.name.text = nameRst[position]
        holder.cuisine.text = cusine[position]
        holder.location.movementMethod = LinkMovementMethod.getInstance()
        holder.location.text = Html.fromHtml(location[position]) // установка сслыки для TextView
        holder.phone.text = phone[position]
        Glide.with(context)
                .load(photo[position])
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.photo)
        }

    override fun getItemCount(): Int {
        return 3
    }


}