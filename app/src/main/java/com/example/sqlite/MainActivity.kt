package com.example.sqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val getBtn = findViewById<Button>(R.id.get_btn)
        val addBtn = findViewById<Button>(R.id.add_btn)
        val year = findViewById<EditText>(R.id.year)
        val make = findViewById<EditText>(R.id.make)
        val model = findViewById<EditText>(R.id.model)
        val output = findViewById<TextView>(R.id.output)

        val database = CarDBHelper(this)


    }
}