package com.example.unitconverter

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val etInput = findViewById<EditText>(R.id.etInput)
        val spinnerFrom = findViewById<Spinner>(R.id.spinnerFrom)
        val spinnerTo = findViewById<Spinner>(R.id.spinnerTo)
        val btnConvert = findViewById<Button>(R.id.btnConvert)

        val units = arrayOf("Байт", "Килобайт", "Мегабайт", "Гигабайт")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, units)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        btnConvert.setOnClickListener {
            val input = etInput.text.toString().toDoubleOrNull()
            if (input == null) {
                Toast.makeText(this, "Введите число", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val fromIndex = spinnerFrom.selectedItemPosition
            val toIndex = spinnerTo.selectedItemPosition

            val conversionRates = doubleArrayOf(1.0, 1024.0, 1024.0 * 1024, 1024.0 * 1024 * 1024)
            val result = input * conversionRates[fromIndex] / conversionRates[toIndex]

            // Переход на ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", result.toString())
            startActivity(intent)
        }
    }
}
