package com.example.test_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var dice1:ImageView
        lateinit var dice2:ImageView
        lateinit var roll:Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(R.mipmap.dice_1, R.mipmap.rice_2, R.mipmap.dice_3, R.mipmap.dice_4, R.mipmap.dice_5, R.mipmap.dice_6)

        dice1 = findViewById(R.id.dice_1)
        dice2 = findViewById(R.id.dice_2)
        roll = findViewById(R.id.roll)

        roll.setOnClickListener {
            dice1.setImageResource(images.random())
            dice2.setImageResource(images.random())
        }
    }
}