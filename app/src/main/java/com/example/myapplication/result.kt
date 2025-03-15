package com.example.unitconverter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResultValue = findViewById<TextView>(R.id.tvResultValue)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Получаем результат из SecondActivity
        val result = intent.getStringExtra("result")
        tvResultValue.text = result ?: "Ошибка"

        btnBack.setOnClickListener {
            // Закрываем ResultActivity и возвращаемся в SecondActivity
            finish()
        }
    }
}