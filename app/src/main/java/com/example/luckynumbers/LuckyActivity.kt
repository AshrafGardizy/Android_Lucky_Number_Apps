package com.example.luckynumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky)
        //Initializing Widgets
        val tvTitle:TextView = findViewById(R.id.textViewTitle)
        val tvResult:TextView = findViewById(R.id.tvResult)
        val bthShare:Button = findViewById(R.id.btnShare)
        var name = receiveName()
        var randomNumber = generateRandomNumbers()
        tvResult.setText(""+randomNumber)
        bthShare.setOnClickListener()
        {
            shareData(name,randomNumber)
        }

    }
    //Receive the name from MainActivity
    fun receiveName():String{
        var bundle:Bundle? = intent.extras
        var userName = bundle?.getString("name").toString()
        return userName
    }
    //Generating random numbers between 1 to 100
    fun generateRandomNumbers():Int{
        var randomNumber = Random.nextInt(100)
        return randomNumber
    }
    //Sharing username and lucky number
    fun shareData(name:String,number:Int)
    {
        var i = Intent(Intent.ACTION_SEND)
        i.putExtra(Intent.EXTRA_SUBJECT,"$name is luky today")
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: $number")
        startActivity(i)
    }
}