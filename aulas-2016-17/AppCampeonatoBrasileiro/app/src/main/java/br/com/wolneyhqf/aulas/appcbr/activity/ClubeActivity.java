package br.com.wolneyhqf.aulas.appcbr.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.model.Clube;
import br.com.wolneyhqf.aulas.appcbr.util.PermissionUtil;

public class ClubeActivity extends BaseActivity {

    private Clube clube;
    private ImageView imageViewEscudo;
    private TextView textViewNome;
    private TextView textViewMascote;
    private TextView textViewFundacao;
    private TextView textViewEstadio;
    private TextView textViewCapacidade;
    private TextView textViewLocalizacao;
    private ImageButton imageButtonLocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clube);

        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageViewEscudo = (ImageView) findViewById(R.id.imageview_escudo);
        textViewNome = (TextView) findViewById(R.id.textview_nome);
        textViewMascote = (TextView) findViewById(R.id.textview_mascote);
        textViewFundacao = (TextView) findViewById(R.id.textview_fundacao);
        textViewEstadio = (TextView) findViewById(R.id.textview_estadio);
        textViewCapacidade = (TextView) findViewById(R.id.textview_capacidade);
        textViewLocalizacao = (TextView) findViewById(R.id.textview_localizacao);
        imageButtonLocalizacao = (ImageButton) findViewById(R.id.imagebutton_localizacao);
        imageButtonLocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION};
                if(PermissionUtil.validate(ClubeActivity.this, 0, permissions)){
                    Intent intent = new Intent(ClubeActivity.this, MapaActivity.class);
                    intent.putExtra("clube", clube);
                    startActivity(intent);
                }
            }
        });

        clube = getIntent().getParcelableExtra("clube");
        getSupportActionBar().setTitle(clube.getNomeAbreviado());

        Picasso.with(getBaseContext()).load(clube.getUrlEscudo())
                .placeholder(R.drawable.escudo)
                .error(R.drawable.escudo)
                .into(imageViewEscudo);
        textViewNome.setText(clube.getNome());
        textViewMascote.setText(clube.getMascote());
        textViewFundacao.setText(clube.getFundacao());
        textViewEstadio.setText(clube.getEstadio());
        textViewCapacidade.setText(String.valueOf(clube.getCapacidadeEstadio()));
        textViewLocalizacao.setText(clube.getCidade() + " - " + clube.getEstado());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        boolean ok = true;
        for(int result : grantResults){
            if(result == PackageManager.PERMISSION_DENIED){
                ok = false;
            }
        }
        if(!ok){
            Toast.makeText(this, "Você precisa conceder as permissões para o aplicativo abrir o mapa", Toast.LENGTH_LONG).show();
        }
    }
}
