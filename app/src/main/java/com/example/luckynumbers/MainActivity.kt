package com.example.luckynumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initializing Widgets
        val tvTitle:TextView = findViewById(R.id.textView1)
        val edInput:EditText = findViewById(R.id.edInput)
        val btn:Button = findViewById(R.id.btn)
        btn.setOnClickListener(){
            if(edInput.text.isEmpty())
            {
                edInput.setError("Name cannot be empty!")
            }else{
                var username = edInput.text.toString()
                //Send value to the LuckyActivy
                var i = Intent(this,LuckyActivity::class.java)
                i.putExtra("name",username)
                startActivity(i)
            }

        }
    }
}