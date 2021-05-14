package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var firstnumber:EditText
    lateinit var secondnumber:EditText
    lateinit var image:ImageView

    lateinit var plus:ImageButton
    lateinit var minus: ImageButton
    lateinit var devide:ImageButton
    lateinit var multiply:ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstnumber = findViewById(R.id.first_number)
        secondnumber = findViewById(R.id.second_number)
        image = findViewById(R.id.img)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        devide = findViewById(R.id.devide)
        multiply = findViewById(R.id.multi)

    }

    fun calc(view: View){
        var result:Long = 0
        var intent = Intent(this, SecondActivity::class.java)
        var symbol:String = ""

        if(firstnumber.text.toString().trim().isNotEmpty() && secondnumber.text.toString().trim().isNotEmpty()){
            val one = firstnumber.text.toString().trim().toLong()
            val two = secondnumber.text.toString().trim().toLong()

            if (view == plus){
                image.setImageResource(R.drawable.ic_new_plus)
                result = one + two
                symbol = "+"
            }
            else if (view == minus){
                image.setImageResource(R.drawable.ic_minus_new)
                result = one - two
                symbol = "-"
            }
            else if (view == devide){
                image.setImageResource(R.drawable.ic_divide_new2)
                result = one / two
                symbol = "/"
            }
            else if (view == multiply){
                image.setImageResource(R.drawable.ic_multiply)
                result = one*two
                symbol = "*"
            }

            intent.putExtra("result", result.toString())
            intent.putExtra("firstnumber", firstnumber.text.toString())
            intent.putExtra("secondnumber", secondnumber.text.toString())
            intent.putExtra("symbol", symbol)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        }else {
            var toast = Toast.makeText(this, "Print number", Toast.LENGTH_LONG).show()
        }


    }

    fun reset(view:View){
        firstnumber.setText("")
        secondnumber.setText("")
    }



}