package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar


class TelaResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultados)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
/*
        // Configurar a Toolbar
        val myToolbar = findViewById<Toolbar>(R.id.myToolbar)
        setSupportActionBar(myToolbar)

        // Habilitar a seta de voltar na Toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
*/
        val btnvoltarResultados = findViewById<Button>(R.id.btnVoltarResultados)
        val combustivelConsumido = findViewById<TextView>(R.id.exibeCombustivelConsumido)
        val distanciaPercorrida = findViewById<TextView>(R.id.exibeDistanciaPercorrida)
        val valorCombustivel = findViewById<TextView>(R.id.exibeValorCombustivel)

        val valorCombustivelRecebido = intent.getStringExtra("parametro1").toString()
        val valordistanciaPercorrida = intent.getStringExtra("parametro2").toString()
        val valorprecoCombustivel = intent.getFloatExtra("parametro3", 0.0f)

        combustivelConsumido.text = valorCombustivelRecebido
        distanciaPercorrida.text = valordistanciaPercorrida

        // PEGANDO OS ID´S DO XML
        val exibelitrosporkm = findViewById<TextView>(R.id.exibeLitrosporkm)
        val exibekmporlitro = findViewById<TextView>(R.id.exibeKmporlitro)
        val valorcustocombustivel = findViewById<TextView>(R.id.exibeCustocombustivel)

        // Formatação OS CAMPOS TEXTVIEWS COM DUAS CASAS DECIMAIS
        val consumo = valorCombustivelRecebido.toFloat()
        val litrosPorKm = consumo / valordistanciaPercorrida.toFloat()
        val kmPorLitro = valordistanciaPercorrida.toFloat() / consumo
        val custoCombustivel = consumo * valorprecoCombustivel
        //EXIBINDO VALORES FORMATADOS
        exibelitrosporkm.text = String.format("%.2f", litrosPorKm)
        exibekmporlitro.text = String.format("%.2f", kmPorLitro)
        valorcustocombustivel.text = String.format("%.2f", custoCombustivel)
        valorCombustivel.text = String.format("%.2f", valorprecoCombustivel)

        btnvoltarResultados.setOnClickListener {
            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
        }
    }
}