package br.com.wolneyhqf.android.aulas.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CheckBoxToggleButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_toggle_button);

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getBaseContext(), "Você marcou o checkbox", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(), "Você desmarcou o checkbox", Toast.LENGTH_LONG).show();
                }
            }
        });

        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.togglebutton);

        Button botaoOk = (Button) findViewById(R.id.botao_ok);
        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked()){
                    Toast.makeText(CheckBoxToggleButtonActivity.this, "Checkbox1 selecionado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CheckBoxToggleButtonActivity.this, "Checkbox1 não selecionado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
