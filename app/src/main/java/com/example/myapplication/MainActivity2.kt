package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var password2: EditText
    private val PASSWORD_MIN_LENGTH = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        name = findViewById(R.id.Username)
        email = findViewById(R.id.Email)
        password = findViewById(R.id.Password)
        password2 = findViewById(R.id.RepeatPassword)
    }

    fun goCreate(v:View){
        try {
            val nameText = name.text.toString().trim()
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()
            val repeatPasswordText = password2.text.toString().trim()

            val emailPattern = Patterns.EMAIL_ADDRESS

            when {
                nameText.isEmpty() -> Toast.makeText(this, "Введите имя", Toast.LENGTH_SHORT).show()
                !emailPattern.matcher(emailText).matches() -> Toast.makeText(this, "Введите корректный email", Toast.LENGTH_SHORT).show()
                passwordText.isEmpty() -> Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show()
                passwordText.length < PASSWORD_MIN_LENGTH -> Toast.makeText(this, "Пароль должен содержать не менее $PASSWORD_MIN_LENGTH символов", Toast.LENGTH_SHORT).show()
                repeatPasswordText.isEmpty() -> Toast.makeText(this, "Повторите пароль", Toast.LENGTH_SHORT).show()
                passwordText != repeatPasswordText -> Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                else -> {
                    val intent = Intent(this, MainActivity3::class.java)
                    Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()
                    intent.putExtra("EXTRA_NAME", nameText)
                    startActivity(intent)
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show()
        }
    }

    fun goBack(v: View){
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(this, "Вы вернулись в окно авторизации", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}