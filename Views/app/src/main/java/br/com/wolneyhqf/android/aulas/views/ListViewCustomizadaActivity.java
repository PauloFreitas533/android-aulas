package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.android.aulas.views.adapter.PaisAdapter;
import br.com.wolneyhqf.android.aulas.views.model.Pais;

public class ListViewCustomizadaActivity extends AppCompatActivity implements ListView.OnItemClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_customizada);
        ListView listViewPaisesCustomizada = (ListView) findViewById(R.id.list_view_customizada);
        PaisAdapter adaptador = new PaisAdapter(this, getListPaises());
        listViewPaisesCustomizada.setAdapter(adaptador);
        listViewPaisesCustomizada.setOnItemClickListener(this);
    }

    public List<Pais> getListPaises(){
        List<Pais> paises = new ArrayList<>();
        paises.add(new Pais(1, "Alemanha", R.drawable.alemanha));
        paises.add(new Pais(2, "Argentina", R.drawable.argentina));
        paises.add(new Pais(3, "Brasil", R.drawable.brasil));
        paises.add(new Pais(4, "Estados Unidos", R.drawable.usa));
        paises.add(new Pais(5, "França", R.drawable.franca));
        paises.add(new Pais(6, "Holanda", R.drawable.holanda));
        paises.add(new Pais(7, "Itália", R.drawable.italia));

        return paises;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Pais pais = (Pais) adapterView.getAdapter().getItem(i);

        ImageView imageViewBandeira = new ImageView(ListViewCustomizadaActivity.this);
        imageViewBandeira.setImageResource(pais.getBandeira());

        Toast toastBandeira = new Toast(ListViewCustomizadaActivity.this);
        toastBandeira.setView(imageViewBandeira);
        toastBandeira.setDuration(Toast.LENGTH_SHORT);
        toastBandeira.show();
    }
}
