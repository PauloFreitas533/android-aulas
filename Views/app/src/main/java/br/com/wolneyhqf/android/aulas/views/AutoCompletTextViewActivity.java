package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompletTextViewActivity extends AppCompatActivity {

    private static final String[] PAISES = new String[] {"Alemanha", "Argentina", "Australia" , "Brasil",
            "Bélgica", "Bolivia", "Espanha", "Italia",
            "Holanda", "Japão", "Uruguai", "França",
            "Estados Unidos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complet_text_view);

        AutoCompleteTextView autoCompletPaises = (AutoCompleteTextView) findViewById(R.id.autocompletPaises);

        // Criando adaptador para ligar os dados a View
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, PAISES);
        autoCompletPaises.setAdapter(adaptador);


    }
}
