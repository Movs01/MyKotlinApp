package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var password: EditText
    private val PASSWORD_MIN_LENGTH = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        password = findViewById(R.id.password)
    }

    fun goSignInView(v:View){
        try {
            val nameText = name.text.toString().trim()
            val passwordText = password.text.toString().trim()

            when {
                nameText.isEmpty() -> Toast.makeText(this, "Введите имя", Toast.LENGTH_LONG).show()
                passwordText.isEmpty() -> Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show()
                passwordText.length < PASSWORD_MIN_LENGTH -> Toast.makeText(this, "Пароль должен содержать не менее $PASSWORD_MIN_LENGTH символов", Toast.LENGTH_SHORT).show()
                else -> {
                    val intent = Intent(this, MainActivity3::class.java)
                    intent.putExtra("EXTRA_NAME", nameText)
                    startActivity(intent)
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show()
        }
    }

    fun goSignUpView(v:View){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}