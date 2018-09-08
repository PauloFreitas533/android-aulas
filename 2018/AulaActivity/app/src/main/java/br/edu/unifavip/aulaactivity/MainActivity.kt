package br.edu.unifavip.aulaactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var campoTexto = findViewById<EditText>(R.id.meu_campo_de_texto)
        var botao = findViewById<Button>(R.id.meu_botao)

        botao.setOnClickListener{
            var texto = campoTexto.text.toString()
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        }

    }
}
