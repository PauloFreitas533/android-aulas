package com.eecm.aula0911

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonFechar = findViewById<Button>(R.id.buttonFechar)
        var buttonEnviar = findViewById<Button>(R.id.buttonEnviar)

        buttonFechar.setOnClickListener{
            finish()
        }

        buttonEnviar.setOnClickListener{
            var editTextNome = findViewById<EditText>(R.id.editTextNome)
            var editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            var radioGroup = findViewById<RadioGroup>(R.id.radioGroupSexo)
            var checkBoxReceberEmail = findViewById<CheckBox>(R.id.checkboxEmail)
            var editTextObservacao = findViewById<EditText>(R.id.editTextObs)

            var nome:String? = editTextNome.text.toString()
            var email:String? = editTextEmail.text.toString()


            var idChecked:Int? = radioGroup.checkedRadioButtonId
            var sexo:Char? = null
            if(idChecked == R.id.radioButtonM){
                sexo = 'M'
            }else if(idChecked == R.id.radioButtonF){
                sexo = 'F'
            }

            var receberEmail:Boolean? = checkBoxReceberEmail.isChecked
            var observacao:String? = editTextObservacao.text.toString()

            var cliente = Cliente(nome, email, sexo, receberEmail, observacao)

            var intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("cliente", cliente)

            startActivity(intent)
        }


    }

}
