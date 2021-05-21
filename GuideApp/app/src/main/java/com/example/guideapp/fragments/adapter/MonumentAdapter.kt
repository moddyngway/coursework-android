package com.example.guideapp.fragments.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.guideapp.R
import com.example.guideapp.fragments.Monument

class MonumentAdapter():
        RecyclerView.Adapter<MonumentAdapter.ViewHolder>() {

    fun initialize(images:Array<String>, description:Array<String>, location:Array<String>, mainName:Array<String>){
        this.images = images
        this.monumentDesc = description
        this.locationMonument = location
        this.mainName = mainName
    }

     lateinit var images:Array<String>
    private lateinit var monumentDesc:Array<String>
    private lateinit var locationMonument:Array<String>
    private lateinit var mainName:Array<String>
    private lateinit var context: Context

            @SuppressLint("CutPasteId")
            inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
                val photo:ImageView by lazy {view.findViewById(R.id.monument_main_photo)}
                val desc:TextView by lazy {view.findViewById(R.id.desc_monument)}
                val name:TextView by lazy {view.findViewById(R.id.monument_name)}
                val location:TextView by lazy {view.findViewById(R.id.monument_location)}
                val locationImage:ImageView by lazy {view.findViewById(R.id.location_image)}
                val infoImage:ImageView by lazy { view.findViewById(R.id.info) }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.monuments_item, parent, false)
        val vh = ViewHolder(v)

        context = parent.context

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {

            if (holder.location.visibility == View.GONE){
                holder.location.visibility = View.VISIBLE
                holder.desc.visibility = View.VISIBLE
                holder.locationImage.visibility = View.VISIBLE
                holder.infoImage.visibility = View.VISIBLE
                holder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 23F)
             } else {
                holder.location.visibility = View.GONE
                holder.desc.visibility = View.GONE
                holder.locationImage.visibility = View.GONE
                holder.infoImage.visibility = View.GONE
                holder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
            }
        }


        holder.desc.text = monumentDesc[position]
        holder.name.text = mainName[position]
        holder.location.movementMethod = LinkMovementMethod.getInstance()
        holder.location.text = Html.fromHtml(locationMonument[position])

        Glide.with(context)
                .load(images[position])
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.photo)

    }

    override fun getItemCount(): Int {
        return 3
    }



}