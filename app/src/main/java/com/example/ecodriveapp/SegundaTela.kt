package com.example.ecodriveapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


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
        var btnResultado = findViewById<Button>(R.id.btnResultado)
        btnResultado.visibility=View.INVISIBLE
        val txtConsumo = findViewById<TextView>(R.id.txtMsg)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val flexBox = findViewById<CheckBox>(R.id.idFlexCheckBox)
        val flexBoxGasolina = findViewById<CheckBox>(R.id.idGasolinacheckBox)
        val flexBoxOutros = findViewById<CheckBox>(R.id.idOutroscheckBox)
        val txtprecoAlcool = findViewById<TextView>(R.id.textprecoAlcool)
        val txtprecoGasolina = findViewById<TextView>(R.id.textprecoGasolina)
        val txtprecoOutros = findViewById<TextView>(R.id.textprecoOutros)
        btnCalcular.visibility = View.INVISIBLE
        //Definição do OUVINTE PARA O CheckBox
        flexBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                btnResultado.visibility = View.INVISIBLE
                btnCalcular.visibility = View.VISIBLE
                txtprecoAlcool.visibility = View.VISIBLE
                edtprecoAlcool.visibility = View.VISIBLE
                edtprecoAlcool.requestFocus()
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
                btnResultado.visibility = View.INVISIBLE
                btnCalcular.visibility = View.VISIBLE
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
                btnResultado.visibility = View.INVISIBLE
                btnCalcular.visibility = View.VISIBLE
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
             if (flexBox.isChecked) {
                   if (edtprecoAlcool.text.toString().isEmpty()) {
                       Toast.makeText(
                           this,
                           "Favor informar o valor do Álcool!!!",
                           Toast.LENGTH_LONG
                       ).show()
                       edtprecoAlcool.requestFocus()
                       btnResultado.visibility = View.INVISIBLE
                       btnCalcular.visibility = View.VISIBLE
                   } else {
                       if (edtprecoGasolina.text.toString().isEmpty()) {
                           Toast.makeText(
                               this,
                               "Favor informar o valor da Gasolina!!!",
                               Toast.LENGTH_LONG
                           ).show()
                           edtprecoGasolina.requestFocus()
                       } else {
                           val valorAlcool: Float = edtprecoAlcool.text.toString().toFloat()
                           val valorGasolina: Float = edtprecoGasolina.text.toString().toFloat()
                           val resultadoFinal: Float = valorAlcool / valorGasolina
                           txtResultado.text = "Resultado: $resultadoFinal"
                           if (resultadoFinal <= 0.7) {
                               txtResultado.setText("É melhor você usar o Alcool")
                           } else {
                               txtResultado.setText("É melhor você usar a Gasolina")
                           }
                           if (edtDistancia.text.toString().isEmpty()) {
                               Toast.makeText(
                                   this,
                                   "Favor informar a distância percorrida!!!",
                                   Toast.LENGTH_LONG
                               ).show()
                               edtDistancia.requestFocus()
                           } else {
                               val distancia: Float = edtDistancia.text.toString().toFloat()
                               if (edtLitros.text.toString().isEmpty()) {
                                   Toast.makeText(
                                       this,
                                       "Favor informar a qtde de litros utilizados!!!",
                                       Toast.LENGTH_LONG
                                   ).show()
                                   edtLitros.requestFocus()
                               } else {
                                   val litros: Float = edtLitros.text.toString().toFloat()
                                   val result: Float = (distancia / litros)
                                   val formattedResult = String.format("%.3f", result) // Formata o resultado com duas casas decimais
                                   txtConsumo.text = formattedResult
                                   msgkml.visibility = View.VISIBLE
                                   btnResultado.visibility = View.VISIBLE
                                   btnCalcular.visibility = View.INVISIBLE
                               }
                           }
                       }
                   }
            }
            if(flexBoxGasolina.isChecked) {
                if (edtprecoGasolina.text.toString().isEmpty()) {
                    Toast.makeText(
                        this,
                        "Favor informar o valor da Gasolina!!!",
                        Toast.LENGTH_LONG
                    ).show()
                    edtprecoGasolina.requestFocus()
                    btnResultado.visibility = View.INVISIBLE
                    btnCalcular.visibility = View.VISIBLE
                } else {
                    if (edtDistancia.text.toString().isEmpty()) {
                        Toast.makeText(
                            this,
                            "Favor informar a distância percorrida!!!",
                             Toast.LENGTH_LONG
                        ).show()
                        edtDistancia.requestFocus()
                    } else {
                        val distancia: Float = edtDistancia.text.toString().toFloat()
                        if (edtLitros.text.toString().isEmpty()) {
                            Toast.makeText(
                                this,
                                "Favor informar a qtde de litros utilizados!!!",
                                Toast.LENGTH_LONG
                            ).show()
                            edtLitros.requestFocus()
                        } else {
                            val litros: Float = edtLitros.text.toString().toFloat()
                            val result: Float = (distancia / litros)
                            val formattedResult = String.format("%.3f", result) // Formata o resultado com duas casas decimais
                            txtConsumo.text = formattedResult
                            msgkml.visibility = View.VISIBLE
                            btnResultado.visibility = View.VISIBLE
                            btnCalcular.visibility = View.INVISIBLE
                        }
                    }
                }
           }
            if(flexBoxOutros.isChecked) {
                if (edtprecoOutros.text.toString().isEmpty()) {
                    Toast.makeText(
                        this,
                        "Favor informar o valor do Combustível!!!",
                        Toast.LENGTH_LONG
                    ).show()
                    edtprecoOutros.requestFocus()
                    btnResultado.visibility = View.INVISIBLE
                    btnCalcular.visibility = View.VISIBLE
                } else {
                    if (edtDistancia.text.toString().isEmpty()) {
                        Toast.makeText(
                            this,
                            "Favor informar a distância percorrida!!!",
                             Toast.LENGTH_LONG
                        ).show()
                        edtDistancia.requestFocus()
                    } else {
                        val distancia: Float = edtDistancia.text.toString().toFloat()
                        if (edtLitros.text.toString().isEmpty()) {
                            Toast.makeText(
                                this,
                                "Favor informar a qtde de litros utilizados!!!",
                                Toast.LENGTH_LONG
                            ).show()
                            edtLitros.requestFocus()
                        } else {
                            val litros: Float = edtLitros.text.toString().toFloat()
                            val result: Float = (distancia / litros)
                            val formattedResult = String.format("%.3f", result) // Formata o resultado com duas casas decimais
                            txtConsumo.text = formattedResult
                            msgkml.visibility = View.VISIBLE
                            btnResultado.visibility = View.VISIBLE
                            btnCalcular.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        //btnResultado.visibility = View.VISIBLE
        //btnCalcular.visibility = View.INVISIBLE
        }
        val btnresultado = findViewById<Button>(R.id.btnResultado)// as Button
        btnresultado.setOnClickListener {
            if (flexBox.isChecked) {
                var valorcombTelaResult: Float
                val precoAlcool = edtprecoAlcool.text.toString().toFloat()
                val precoGasolina = edtprecoGasolina.text.toString().toFloat()
                if (precoAlcool > precoGasolina) {
                    valorcombTelaResult = precoAlcool
                } else {
                    valorcombTelaResult = precoGasolina
                }
                //INTENT EXPLICITA
                val intent = Intent(this, TelaResultados::class.java)
                //PASSAGEM DOS VALORES DA SEGUNDA TELA PARA A TELARESULTADOS
                val valoredtTextlitros = edtLitros.text.toString()
                val valoredtTextdistancia = edtDistancia.text.toString()
                intent.putExtra("parametro1", valoredtTextlitros )
                intent.putExtra("parametro2", valoredtTextdistancia)
                intent.putExtra("parametro3", valorcombTelaResult)
                startActivity(intent)
            }
            if(flexBoxGasolina.isChecked) {
                var valorcombTelaResult: Float
                val precoGasolina = edtprecoGasolina.text.toString().toFloat()
                valorcombTelaResult = precoGasolina
                //INTENT EXPLICITA
                val intent = Intent(this, TelaResultados::class.java)
                //PASSAGEM DOS VALORES DA SEGUNDA TELA PARA A TELARESULTADOS
                val valoredtTextlitros = edtLitros.text.toString()
                val valoredtTextdistancia = edtDistancia.text.toString()
                intent.putExtra("parametro1", valoredtTextlitros )
                intent.putExtra("parametro2", valoredtTextdistancia)
                intent.putExtra("parametro3", valorcombTelaResult)
                startActivity(intent)
            }
            if(flexBoxOutros.isChecked) {
                var valorcombTelaResult: Float
                val precoOutros = edtprecoOutros.text.toString().toFloat()
                valorcombTelaResult = precoOutros
                //INTENT EXPLICITA
                val intent = Intent(this, TelaResultados::class.java)
                //PASSAGEM DOS VALORES DA SEGUNDA TELA PARA A TELARESULTADOS
                val valoredtTextlitros = edtLitros.text.toString()
                val valoredtTextdistancia = edtDistancia.text.toString()
                intent.putExtra("parametro1", valoredtTextlitros )
                intent.putExtra("parametro2", valoredtTextdistancia)
                intent.putExtra("parametro3", valorcombTelaResult)
                startActivity(intent)
            }
        }
    }
}
