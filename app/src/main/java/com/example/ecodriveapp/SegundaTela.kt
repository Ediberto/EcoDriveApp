package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)
        val voltatelaLogin = findViewById<Button>(R.id.btnVoltarTelaLogin)

        val edtprecoAlcool = findViewById<EditText>(R.id.etPrecoAlcool)
        val edtprecoGasolina = findViewById<EditText>(R.id.etPrecoGasolina)
        val txtResultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val flexBox = findViewById<CheckBox>(R.id.idFlexCheckBox)
        val txtprecoAlcool = findViewById<TextView>(R.id.textprecoAlcool)
        val txtprecoGasolina = findViewById<TextView>(R.id.textprecoGasolina)
        val flexBoxAlcool = findViewById<CheckBox>(R.id.idAlcoolcheckBox)
        val flexBoxGasolina = findViewById<CheckBox>(R.id.idGasolinacheckBox)
        //Definição do OUVINTE PARA O CheckBox
        flexBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoAlcool.visibility = View.VISIBLE
                edtprecoAlcool.visibility = View.VISIBLE
                txtprecoGasolina.visibility = View.VISIBLE
                edtprecoGasolina.visibility = View.VISIBLE
            } else {
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
            }
        }
        flexBoxAlcool.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoAlcool.visibility = View.VISIBLE
                edtprecoAlcool.visibility = View.VISIBLE
            } else {
                txtprecoAlcool.visibility = View.INVISIBLE
                edtprecoAlcool.visibility = View.INVISIBLE
            }
        }
        flexBoxGasolina.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtprecoGasolina.visibility = View.VISIBLE
                edtprecoGasolina.visibility = View.VISIBLE
            } else {
                txtprecoGasolina.visibility = View.INVISIBLE
                edtprecoGasolina.visibility = View.INVISIBLE
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

        voltatelaLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

/*SEM CHECKBOX
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)
        val voltatelaLogin = findViewById<Button>(R.id.btnVoltarTelaLogin)

        val edtprecoAlcool = findViewById<EditText>(R.id.etPrecoAlcool)
        val edtprecoGasolina = findViewById<EditText>(R.id.etPrecoGasolina)
        val txtResultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        /*val flexBox = findViewById<CheckBox>(R.id.idFlex)
        //Definição do OUVINTE PARA O CheckBox
        if (flexBox.isChecked()) {
            Toast.makeText(this, "VEICULO É FLEX", Toast.LENGTH_LONG)
                .show()
        }*/
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
        /*    if (flexBox.isChecked()) {
                txtResultado.setText("FLEX")
                //Toast.makeText(this, "VEICULO É FLEX", Toast.LENGTH_LONG).show()
            } */
        }

        voltatelaLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
 */