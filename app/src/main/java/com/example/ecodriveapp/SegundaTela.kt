package com.example.ecodriveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val edtprecoAlcool = findViewById<EditText>(R.id.etPrecoAlcool)
        val edtprecoGasolina = findViewById<EditText>(R.id.etPrecoGasolina)
        val edtprecoOutros = findViewById<EditText>(R.id.etPrecoOutros)
        val txtResultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val flexBox = findViewById<CheckBox>(R.id.idFlexCheckBox)
        val flexBoxGasolina = findViewById<CheckBox>(R.id.idGasolinacheckBox)
        val flexBoxOutros = findViewById<CheckBox>(R.id.idOutroscheckBox)
        val txtprecoAlcool = findViewById<TextView>(R.id.textprecoAlcool)
        val txtprecoGasolina = findViewById<TextView>(R.id.textprecoGasolina)
        val txtprecoOutros = findViewById<TextView>(R.id.textprecoOutros)

        //Definição do OUVINTE PARA O CheckBox
        flexBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoAlcool.visibility = View.VISIBLE
                edtprecoAlcool.visibility = View.VISIBLE
                txtprecoGasolina.visibility = View.VISIBLE
                edtprecoGasolina.visibility = View.VISIBLE
                flexBoxOutros.visibility = View.INVISIBLE
                flexBoxGasolina.visibility = View.INVISIBLE
            } else {
                flexBoxOutros.visibility = View.VISIBLE
                flexBoxGasolina.visibility = View.VISIBLE
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
            }
        }
        flexBoxOutros.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoOutros.visibility = View.VISIBLE
                edtprecoOutros.visibility = View.VISIBLE
                flexBox.visibility = View.INVISIBLE
                flexBoxGasolina.visibility = View.INVISIBLE
                txtResultado.text = "Seu veículo utiliza outro tipo de Combustível"
            } else {
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
                flexBox.visibility = View.VISIBLE
                flexBoxGasolina.visibility = View.VISIBLE
                txtResultado.text = ""
            }
        }
        flexBoxGasolina.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoGasolina.visibility = View.VISIBLE
                edtprecoGasolina.visibility = View.VISIBLE
                flexBoxOutros.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
                flexBox.visibility = View.INVISIBLE
                txtResultado.text = "Seu veículo só usa Gasolina"
            } else {
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
                flexBoxOutros.visibility = View.VISIBLE
                flexBox.visibility = View.VISIBLE
                txtResultado.text = ""
            }
        }
        //AÇÃO DO BOTAO
        btnCalcular.setOnClickListener{
            val valorAlcool:Float = edtprecoAlcool.text.toString().toFloat()
            val valorGasolina:Float = edtprecoGasolina.text.toString().toFloat()
            val resultadoFinal:Float = valorAlcool/valorGasolina
            txtResultado.text = "Resultado: $resultadoFinal"
            if(resultadoFinal <= 0.7) {
                txtResultado.setText("É melhor você usar o Alcool")
            } else {
                txtResultado.setText("É melhor você usar a Gasolina")
            }
        }
        val btnConsumo: Button = findViewById(R.id.btnCalcular_consumo)
        val edtLitros: EditText = findViewById(R.id.edttextlitros)
        val edtDistancia: EditText = findViewById(R.id.edittextdistancia)
        val tvResultado: TextView = findViewById(R.id.txtMsg)

        btnConsumo.setOnClickListener {

            val distanciaStr = edtDistancia.text.toString()
            val litrosStr = edtLitros.text.toString()

            if (distanciaStr.isNotEmpty() && litrosStr.isNotEmpty()) {
                val distancia: Float = distanciaStr.toFloat()
                val litros: Float = litrosStr.toFloat()
                val result: Float = (distancia / litros)

                tvResultado.text = result.toString()

            }}}
}
