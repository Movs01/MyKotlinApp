package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent.getStringExtra("EXTRA_NAME")

        val welcomeTextView: TextView = findViewById(R.id.Welcome)
        welcomeTextView.text = "Добро пожаловать, $name"
    }
    fun goExit(v:View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}