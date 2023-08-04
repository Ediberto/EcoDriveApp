package com.example.ecodriveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.btnLogin)
        login.setOnClickListener {
            val usuarioa = findViewById<TextView>(R.id.edtUsuario)
            val senhaa = findViewById<EditText>(R.id.edtSenha)
            val usuario = usuarioa.text.toString()
            val senha = senhaa.text.toString()
            if((usuario != "time07" && senha != "123") && usuario.isNotEmpty() && senha.isNotEmpty()){
                Toast.makeText(this, "Nome do usuário e senha estão invalidos!!!", Toast.LENGTH_LONG).show()
            } else {
                if (usuario.isEmpty() && senha.isEmpty()) {
                    Toast.makeText(
                        this,
                        "Favor informar o nome do usuário e a senha",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (usuario.isEmpty()) {
                        Toast.makeText(this, "Favor informar o nome do usuário", Toast.LENGTH_LONG)
                            .show()
                    } else if (senha.isEmpty()) {
                        Toast.makeText(this, "Favor informar a senha do usuário", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        if (usuario != "time07") {
                            Toast.makeText(
                                this,
                                "O nome do usuário está inválido!!!",
                                Toast.LENGTH_LONG
                            ).show()

                        } else {
                            if (senha != "123") {
                                Toast.makeText(
                                    this,
                                    "A senha do usuário está inválida!!!",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                if (usuario != "time07" && senha != "123") {
                                    Toast.makeText(
                                        this,
                                        "Nome do usuário e senha estão invalidos!!!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Login realizado com sucesso!!!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    //INTENT EXPLICITA
                                    val intent = Intent(this, SegundaTela::class.java)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }

            }
         }
    }
  /*

  OU ASSIM
showMensage("Login realizado com sucesso!!!")
  private fun showMensage(string: String) {
       Toast.makeText(this,string, Toast.LENGTH_LONG).show()
    }
}
*/