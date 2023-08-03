package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<Button>(R.id.btnLogin)
        login.setOnClickListener {
            //val intent = Intent(applicationContext, MainActivity::class.java)

            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
        }
        /* (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val elogin = findViewById<EditText>(R.id.edtUsuario)
                val esenha = findViewById<EditText>(R.id.edtSenha)
                val login = elogin.text.toString()
                val senha = esenha.text.toString()
                if(login == "time07" && senha == "123") {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    showMensage("Usuário e/ou Senha inválido")
                }

        });

    }
    private fun showMensage(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_LONG).show()
    } */
    }
}