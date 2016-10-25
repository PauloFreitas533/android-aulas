package br.com.wolneyhqf.android.aulas.materialdesign;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.android.aulas.materialdesign.adapter.PaisesAdapter;
import br.com.wolneyhqf.android.aulas.materialdesign.model.Pais;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        List<Pais> paises = getListPaises();
        recyclerView.setAdapter(new PaisesAdapter(paises, this, onClickPais()));
    }

    private PaisesAdapter.PaisOnClickListener onClickPais(){
        return new PaisesAdapter.PaisOnClickListener(){
            public void onClickPais(View view, int idx){
                List<Pais> paises = getListPaises();
                Pais pais = paises.get(idx);
                Toast.makeText(getBaseContext(), "País: " + pais.getNome(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private Activity getActivity(){
        return this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_linear_layout){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            return true;
        }else if(id == R.id.action_grid_layout){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<Pais> getListPaises(){
        List<Pais> paises = new ArrayList<>();

        paises.add(new Pais("Alemanha", R.drawable.alemanha));
        paises.add(new Pais("Argentina", R.drawable.argentina));
        paises.add(new Pais("Brasil", R.drawable.brasil));
        paises.add(new Pais("França", R.drawable.franca));
        paises.add(new Pais("Holanda", R.drawable.holanda));
        paises.add(new Pais("Itália", R.drawable.italia));
        paises.add(new Pais("Estados Unidos", R.drawable.usa));
        return paises;
    }

}
