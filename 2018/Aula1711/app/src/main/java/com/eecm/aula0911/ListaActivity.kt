package com.eecm.aula0911

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ListaActivity : AppCompatActivity() {

    private var clientes = listOf<Cliente>()
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        supportActionBar?.title = "Lista"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.setHasFixedSize(true)

        taskClientes()
    }

    fun taskClientes(){
        this.clientes = ClienteService.getClientes()
        recyclerView?.adapter = ClienteAdapter(clientes,
            {
                cliente: Cliente -> Toast.makeText(this, "@Clicou no cliente ${cliente.nome}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId
        if(id == android.R.id.home){
            var it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }else if(id == R.id.action_search){
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}
