 package br.com.wolneyhqf.android.aulas.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

 public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu){
         getMenuInflater().inflate(R.menu.menu_toolbar, menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item){
         Toast.makeText(this, "Opção Selecionada", Toast.LENGTH_SHORT).show();
         return super.onOptionsItemSelected(item);
     }
}
