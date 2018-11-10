package com.eecm.aula0911

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        var cliente:Cliente? = intent.getSerializableExtra("cliente") as Cliente?

        Toast.makeText(this, cliente?.nome, Toast.LENGTH_SHORT).show()
    }
}
