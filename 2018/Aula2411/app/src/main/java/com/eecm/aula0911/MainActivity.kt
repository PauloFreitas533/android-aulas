package com.eecm.aula0911

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Formulário"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var imageViewDowloand = findViewById<ImageView>(R.id.imageview_download)
        Picasso.with(this)
            .load("https://upload.wikimedia.org/wikipedia/pt/7/73/Trollface.png")
            .fit()
            .into(imageViewDowloand)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_formulario, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item?.itemId
        if(id == android.R.id.home){
            finish()
        }else if(id == R.id.action_clear){

        }else if(id == R.id.action_close){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
