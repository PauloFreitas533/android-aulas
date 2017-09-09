package com.wolneyhqf.formapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] cursos = new String[]{"ADS", "Administração", "Direito", "Engenharia Civil"};
    private ImageButton imageButtonCamera;
    private ImageView imageViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner_curso);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cursos);
        spinner.setAdapter(adaptador);

        imageButtonCamera = (ImageButton) findViewById(R.id.imagebutton_camera);
        imageViewProfile = (ImageView) findViewById(R.id.imageview_profile);

        imageButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            Bundle bundle = data.getExtras();
            if(bundle != null){
                Bitmap bitmap = (Bitmap) bundle.get("data");
                imageViewProfile.setImageBitmap(bitmap);
            }
        }
    }
}
