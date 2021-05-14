package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val result = intent.getStringExtra("result")
        val first = intent.getStringExtra("firstnumber")
        val second = intent.getStringExtra("secondnumber")
        val symbol = intent.getStringExtra("symbol")
        txt = findViewById(R.id.textView)
        txt.text = "RESULT: $first $symbol $second = $result"

    }
}