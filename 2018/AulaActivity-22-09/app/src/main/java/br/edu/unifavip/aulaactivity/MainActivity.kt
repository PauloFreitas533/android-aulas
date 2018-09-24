package br.edu.unifavip.aulaactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_multiplicacao)

        Log.d("msg", "MainActivity.onCreate()")

        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        buttonCalcular.setOnClickListener{
            val editTextNumero1 = findViewById<EditText>(R.id.editTextNumero1)
            val editTextNumero2 = findViewById<EditText>(R.id.editTextNumero2)

            var numero1 = 0.0
            if(editTextNumero1.text.toString() != ""){
                numero1 = editTextNumero1.text.toString().toDouble()
            }

            var numero2 = 0.0
            if(editTextNumero2.text.toString() != ""){
                numero2 = editTextNumero2.text.toString().toDouble()
            }

            var resultado = numero1 * numero2
            Toast.makeText(context, "Resultado: $resultado", Toast.LENGTH_SHORT).show()

            val minhaIntent = Intent(context, SegundaActivity::class.java)

            minhaIntent.putExtra("resultado", resultado)

            startActivity(minhaIntent)
        }

    }

    override fun onStart(){
        super.onStart()
        Log.d("msg", "MainActivity.onStart()")
    }

    override fun onResume(){
        super.onResume()
        Log.d("msg", "MainActivity.onResume()")
    }

    override fun onPause(){
        super.onPause()
        Log.d("msg", "MainActivity.onPause()")
    }

    override fun onStop(){
        super.onStop()
        Log.d("msg", "MainActivity.onStop()")
    }

    override fun onRestart(){
        super.onRestart()
        Log.d("msg", "MainActivity.onRestart()")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("msg", "MainActivity.onDestroy()")
    }

}
