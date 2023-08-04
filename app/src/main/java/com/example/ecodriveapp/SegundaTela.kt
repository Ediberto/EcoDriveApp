package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)
        val voltatelaLogin = findViewById<Button>(R.id.btnVoltarTelaLogin)

        val edtprecoAlcool = findViewById<EditText>(R.id.etPrecoAlcool)
        val edtprecoGasolina = findViewById<EditText>(R.id.etPrecoGasolina)
        val txtResultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        //AÇÃO DO BOTAO
        btnCalcular.setOnClickListener{
            val valorAlcool:Float = edtprecoAlcool.text.toString().toFloat()
            val valorGasolina:Float = edtprecoGasolina.text.toString().toFloat()
            val resultadoFinal:Float = valorAlcool/valorGasolina
            txtResultado.text = "Resultado: $resultadoFinal"
        }
        voltatelaLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}