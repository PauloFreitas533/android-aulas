package br.com.wolneyhqf.aulas.appcbr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.fragment.MapaFragment;
import br.com.wolneyhqf.aulas.appcbr.model.Clube;

public class MapaActivity extends BaseActivity {

    private Clube clube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clube = getIntent().getParcelableExtra("clube");
        getSupportActionBar().setTitle(clube.getNomeAbreviado());

        if(savedInstanceState==null){
            MapaFragment mapaFragment = new MapaFragment();
            mapaFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, mapaFragment).commit();
        }
    }

}
