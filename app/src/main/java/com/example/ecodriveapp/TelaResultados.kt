package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultados)
        val btnvoltarResultados = findViewById<Button>(R.id.btnVoltarResultados)// as Button
        //val n = findViewById<View>(R.id.txtNome) as EditText
        btnvoltarResultados.setOnClickListener {
            //INTENT EXPLICITA
            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
        }
    }
}