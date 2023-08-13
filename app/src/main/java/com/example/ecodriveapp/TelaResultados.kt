package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class TelaResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultados)

        val btnvoltarResultados = findViewById<Button>(R.id.btnVoltarResultados)
        val combustivelConsumido = findViewById<TextView>(R.id.exibeCombustivelConsumido)
        val distanciaPercorrida = findViewById<TextView>(R.id.exibeDistanciaPercorrida)
        val valorCombustivel = findViewById<TextView>(R.id.exibeValorCombustivel)

        val valorCombustivelRecebido = intent.getStringExtra("parametro1").toString()
        val valordistanciaPercorrida = intent.getStringExtra("parametro2").toString()
        val valorprecoCombustivel = intent.getFloatExtra("parametro3", 0.0f)

        combustivelConsumido.text = valorCombustivelRecebido
        distanciaPercorrida.text = valordistanciaPercorrida
        valorCombustivel.text = valorprecoCombustivel.toString()

        val exibelitrosporkm = findViewById<TextView>(R.id.exibeLitrosporkm)
        val exibekmporlitro = findViewById<TextView>(R.id.exibeKmporlitro)

        //SAÍDA DOS VALORES FORMATADOS PARA 3 CASAS DECIMAIS
        exibelitrosporkm.text = String.format("%.3f", valorCombustivelRecebido.toFloat() / valordistanciaPercorrida.toFloat())
        //exibekmporlitro.text = (valordistanciaPercorrida.toFloat() / valorCombustivelRecebido.toFloat()).toString()
        exibekmporlitro.text = String.format("%.3f", valordistanciaPercorrida.toFloat() / valorCombustivelRecebido.toFloat())


        val valorcustocombustivel = findViewById<TextView>(R.id.exibeCustocombustivel)
        val consumo = valorCombustivelRecebido.toFloat()// * valorCombustivel.toFloat().toString
        valorcustocombustivel.text = (consumo * valorprecoCombustivel).toString()

        btnvoltarResultados.setOnClickListener {
            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
        }
    }
}