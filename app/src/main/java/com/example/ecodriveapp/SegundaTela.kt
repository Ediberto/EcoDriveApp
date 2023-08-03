package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)
        val voltatelaLogin = findViewById<Button>(R.id.btnVoltarTelaLogin)
        voltatelaLogin.setOnClickListener {
            //val intent = Intent(applicationContext, MainActivity::class.java)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}