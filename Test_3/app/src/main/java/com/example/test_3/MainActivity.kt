    package com.example.test_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var number: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number = findViewById(R.id.main_number)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            var num:Int = number.text.toString().toInt()+1
            if (num == 10000){ // обновляет счетчик когда она доходит 9999<
                num = 0
            }

            number.text = String.format("%04d", num)
        }
    }
}