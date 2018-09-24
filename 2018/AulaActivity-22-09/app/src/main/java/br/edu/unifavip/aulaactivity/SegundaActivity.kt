package br.edu.unifavip.aulaactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)


        val resultado:Double = intent.getDoubleExtra("resultado", 0.0)

        var textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        textViewResultado.text = resultado.toString()

    }
}
