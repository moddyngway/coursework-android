package com.example.bookapplication

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapplication.ui.BookActivity
import com.example.bookapplication.ui.adapter.MyAdapter
import com.example.bookapplication.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    lateinit var myadapter: MyAdapter
    lateinit var recycler: RecyclerView

    val mainImage: ImageView by lazy { findViewById(R.id.main_photo) }
    val search: EditText by lazy { findViewById(R.id.search) }
    val button: Button by lazy {findViewById(R.id.button)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Загрузка главного фото в начале
         */

        Glide.with(this)
            .load("https://file.liga.net/images/general/2020/09/08/20200908171549-5386.jpg")
            .placeholder(R.drawable.load)
            .into(mainImage)
        val internet = isNetworkAvailable()// идет проверка на интернет

        /*
        При нажатии на кнопку если есть интеренет идет вызов интента иначе toast будет показан
         */

        button.setOnClickListener {
            if (!internet){
                val toast = Toast.makeText(this, "Please turn on Internet", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                val intent = Intent(this, BookActivity::class.java)
                intent.putExtra("search", search.text.trim().toString())
                startActivity(intent)
            }

        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}