package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private String [] paises = new String[]{"Alemanha", "Argentina", "Brasil", "China", "Espanha", "França", "Itália", "Portugal", "Russia", "Reino Unido"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listViewPaises = (ListView) findViewById(R.id.listview_paises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        listViewPaises.setAdapter(adapter);
        listViewPaises.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String pais = (String) adapterView.getAdapter().getItem(i);
        Toast.makeText(this, "País selecionado: " + pais, Toast.LENGTH_SHORT).show();
    }
}
