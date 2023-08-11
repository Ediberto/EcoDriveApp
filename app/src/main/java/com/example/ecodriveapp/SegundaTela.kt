package com.example.ecodriveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val edtprecoAlcool = findViewById<EditText>(R.id.etPrecoAlcool)
        val edtprecoGasolina = findViewById<EditText>(R.id.etPrecoGasolina)
        val edtprecoOutros = findViewById<EditText>(R.id.etPrecoOutros)
        val edtDistancia = findViewById<EditText>(R.id.edittextdistancia)
        val edtLitros = findViewById<EditText>(R.id.edttextlitros)
        val txtResultado = findViewById<TextView>(R.id.tvResultado)
        val msgkml = findViewById<TextView>(R.id.txtMsg)

        val txtConsumo = findViewById<TextView>(R.id.txtMsg)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val flexBox = findViewById<CheckBox>(R.id.idFlexCheckBox)
        val flexBoxGasolina = findViewById<CheckBox>(R.id.idGasolinacheckBox)
        val flexBoxOutros = findViewById<CheckBox>(R.id.idOutroscheckBox)
        val txtprecoAlcool = findViewById<TextView>(R.id.textprecoAlcool)
        val txtprecoGasolina = findViewById<TextView>(R.id.textprecoGasolina)
        val txtprecoOutros = findViewById<TextView>(R.id.textprecoOutros)

        /*
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == android.R.id.home) {
                onBackPressed()
                true
            } else {
                false
            }
        }  */


        //Definição do OUVINTE PARA O CheckBox
        flexBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoAlcool.visibility = View.VISIBLE
                edtprecoAlcool.visibility = View.VISIBLE
                txtprecoGasolina.visibility = View.VISIBLE
                edtprecoGasolina.visibility = View.VISIBLE
                edtDistancia.visibility = View.VISIBLE
                edtLitros.visibility = View.VISIBLE
                flexBoxOutros.visibility = View.INVISIBLE
                flexBoxGasolina.visibility = View.INVISIBLE
                edtprecoAlcool.setText("")
                edtprecoGasolina.setText("")
                edtprecoOutros.setText("")
                edtDistancia.setText("")
                edtLitros.setText("")
                txtResultado.text=""
                txtConsumo.text=""
                msgkml.text=""
            } else {
                flexBoxOutros.visibility = View.VISIBLE
                flexBoxGasolina.visibility = View.VISIBLE
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
                edtDistancia.visibility = View.INVISIBLE
                edtLitros.visibility = View.INVISIBLE
                msgkml.visibility = View.INVISIBLE
            }
        }
        flexBoxGasolina.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoGasolina.visibility = View.VISIBLE
                edtprecoGasolina.visibility = View.VISIBLE
                edtDistancia.visibility = View.VISIBLE
                edtLitros.visibility = View.VISIBLE
                flexBoxOutros.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
                flexBox.visibility = View.INVISIBLE
                txtResultado.text = "Seu veículo só usa Gasolina"
                edtprecoGasolina.setText("")
                edtprecoOutros.setText("")
                edtDistancia.setText("")
                edtLitros.setText("")
                txtConsumo.text=""
                msgkml.text=""
            } else {
                flexBoxOutros.visibility = View.VISIBLE
                flexBox.visibility = View.VISIBLE
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
                edtDistancia.visibility = View.INVISIBLE
                edtLitros.visibility = View.INVISIBLE
                txtResultado.text = ""
            }
        }
        flexBoxOutros.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoOutros.visibility = View.VISIBLE
                edtprecoOutros.visibility = View.VISIBLE
                edtDistancia.visibility = View.VISIBLE
                edtLitros.visibility = View.VISIBLE
                flexBox.visibility = View.INVISIBLE
                flexBoxGasolina.visibility = View.INVISIBLE
                txtResultado.text = "Seu veículo utiliza outro tipo de Combustível"
                edtprecoOutros.setText("")
                edtDistancia.setText("")
                edtLitros.setText("")
                txtConsumo.text=""
                msgkml.text=""
            } else {
                flexBox.visibility = View.VISIBLE
                flexBoxGasolina.visibility = View.VISIBLE
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
                txtprecoOutros.visibility = View.INVISIBLE
                edtprecoOutros.visibility = View.INVISIBLE
                edtDistancia.visibility = View.INVISIBLE
                edtLitros.visibility = View.INVISIBLE
                txtResultado.text = ""
            }
        }

        //AÇÃO DO BOTAO
        btnCalcular.setOnClickListener {
           if(flexBox.isChecked) {
                val valorAlcool: Float = edtprecoAlcool.text.toString().toFloat()
                val valorGasolina: Float = edtprecoGasolina.text.toString().toFloat()
                val resultadoFinal: Float = valorAlcool / valorGasolina
                txtResultado.text = "Resultado: $resultadoFinal"
                if (resultadoFinal <= 0.7) {
                    txtResultado.setText("É melhor você usar o Alcool")
                } else {
                    txtResultado.setText("É melhor você usar a Gasolina")
                }
                val distancia: Float = edtDistancia.text.toString().toFloat()
                val litros: Float = edtLitros.text.toString().toFloat()
                val result: Float = (distancia / litros)
                txtConsumo.text = result.toString()
                msgkml.visibility = View.VISIBLE
           }
           if(flexBoxGasolina.isChecked) {
              val distancia: Float = edtDistancia.text.toString().toFloat()
                val litros: Float = edtLitros.text.toString().toFloat()
                val result: Float = (distancia / litros)
                txtConsumo.text = result.toString()
                msgkml.visibility = View.VISIBLE
           }
            if(flexBoxOutros.isChecked) {
                val distancia: Float = edtDistancia.text.toString().toFloat()
                val litros: Float = edtLitros.text.toString().toFloat()
                val result: Float = (distancia / litros)
                txtConsumo.text = result.toString()
                msgkml.visibility = View.VISIBLE
            }
        }

    }

}
