package br.com.wolneyhqf.android.aulas.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.wolneyhqf.android.aulas.fragments.adapter.PaisesAdapter;

public class PaisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        ListView listViewPaises = (ListView) findViewById(R.id.list_view_paises);
        listViewPaises.setAdapter(new PaisesAdapter(this));
        listViewPaises.setOnItemClickListener(onItemClickPais());
    }

    public AdapterView.OnItemClickListener onItemClickPais(){

        return new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parente, View view, int position, long id){
                PaisesAdapter adapter = (PaisesAdapter) parente.getAdapter();
                String pais = (String) adapter.getItem(position);
                Intent intent = new Intent(PaisesActivity.this, PaisActivity.class);
                intent.putExtra("pais", pais);
                startActivity(intent);
            }
        };

    }
}
