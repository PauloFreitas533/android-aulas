package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class SpinnerActivity extends AppCompatActivity {

    private String[] paises = new String[]{"Argentina", "Brasil", "Estados Unidos", "Holanda"};
    private int[] bandeiras = new int[]{R.drawable.argentina, R.drawable.brasil, R.drawable.usa, R.drawable.holanda};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final Spinner spinnerPaises = (Spinner) findViewById(R.id.spinner_paises);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, paises);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaises.setAdapter(adaptador);

        Button botaoPais = (Button) findViewById(R.id.botao_pais);
        botaoPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinnerPaises.getSelectedItemPosition();

                ImageView imageViewBandeira = new ImageView(SpinnerActivity.this);
                imageViewBandeira.setImageResource(bandeiras[position]);
                Toast toastBandeira = new Toast(SpinnerActivity.this);
                toastBandeira.setView(imageViewBandeira);
                toastBandeira.setDuration(Toast.LENGTH_SHORT);
                toastBandeira.show();
            }
        });
    }
}
