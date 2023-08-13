package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        exibelitrosporkm.text = (valorCombustivelRecebido.toFloat() / valordistanciaPercorrida.toFloat()).toString()
        exibekmporlitro.text = (valordistanciaPercorrida.toFloat() / valorCombustivelRecebido.toFloat()).toString()

        val valorcustocombustivel = findViewById<TextView>(R.id.exibeCustocombustivel)
        val consumo = valorCombustivelRecebido.toFloat()// * valorCombustivel.toFloat().toString
        valorcustocombustivel.text = (consumo * valorprecoCombustivel).toString()

        //val consumo = valorCombustivelRecebido.toFloat() * valordistanciaPercorrida.toFloat()
        //valorcustocombustivel.text = (consumo * valorprecoCombustivel).toString()

        btnvoltarResultados.setOnClickListener {
            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
        }
    }
}


/*class TelaResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultados)

        val btnvoltarResultados = findViewById<Button>(R.id.btnVoltarResultados)
        val combustivelConsumido = findViewById<TextView>(R.id.exibeCombustivelConsumido)
        val distanciaPercorrida = findViewById<TextView>(R.id.exibeDistanciaPercorrida)
        val valorCombustivel = findViewById<TextView>(R.id.exibeValorCombustivel)

       // val valorCombustivelRecebido = intent.getStringExtra("parametro1")
        val valorCombustivelRecebido = intent.getStringExtra("parametro1").toString()
       // val valordistanciaPercorrida = intent.getStringExtra("parametro2")
        val valordistanciaPercorrida = intent.getStringExtra("parametro2").toString()
        val valorprecoCombustivel = intent.getFloatExtra("parametro3", 0.00f).toString()

        combustivelConsumido.text = valorCombustivelRecebido
        distanciaPercorrida.text = valordistanciaPercorrida.toString()
        valorCombustivel.text = valorprecoCombustivel

        val exibelitrosporkm = findViewById<TextView>(R.id.exibeLitrosporkm)
        val exibekmporlitro = findViewById<TextView>(R.id.exibeKmporlitro)
        val exibecombustivelconsumido = findViewById<TextView>(R.id.exibeCombustivelConsumido)
        val exibecustocombustivel = findViewById<TextView>(R.id.exibeValorCombustivel)

        //CONVERTENDO OS VALORES PARA NUMERICOS, DEPOIS PARA STRING E ATRIBUINDO AOS TEXTVIEWS
        //CALCULANDO LITROS POR KM
        exibelitrosporkm.text = (valorCombustivelRecebido.toFloat() / valordistanciaPercorrida.toFloat()).toString()
        //CALCULANDO KM POR LITROS
        exibekmporlitro.text = (valordistanciaPercorrida.toFloat() / valorCombustivelRecebido.toFloat()).toString()

        val valorcustocombustivel = findViewById<TextView>(R.id.exibeCustocombustivel)
        //CALCULANDO CUSTO DO COMBUSTÍVEL
        valorcustocombustivel.text = (combustivelConsumido.toFloat() * valorCombustivel.toFloat().toString())

       // val consumo = exibecombustivelconsumido.text.toString().toFloat()
       // exibecustocombustivel.text = (consumo / valorprecoCombustivel.toFloat()).toString()

        btnvoltarResultados.setOnClickListener {
            //INTENT EXPLICITA
            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
        }
    }
}
*/
