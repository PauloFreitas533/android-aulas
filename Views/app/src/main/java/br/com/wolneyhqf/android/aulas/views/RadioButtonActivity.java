package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group_opcoes);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.radio_opcaoA:
                        Toast.makeText(RadioButtonActivity.this, "Opção A selecionada", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_opcaoB:
                        Toast.makeText(RadioButtonActivity.this, "Opção B selecionada", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_opcaoC:
                        Toast.makeText(RadioButtonActivity.this, "Opção C selecionada", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_opcaoD:
                        Toast.makeText(RadioButtonActivity.this, "Opção D selecionada", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_opcaoE:
                        Toast.makeText(RadioButtonActivity.this, "Opção E selecionada", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
