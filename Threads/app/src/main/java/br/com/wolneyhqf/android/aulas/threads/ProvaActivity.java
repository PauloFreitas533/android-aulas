package br.com.wolneyhqf.android.aulas.threads;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.wolneyhqf.android.aulas.threads.util.HttpUtil;

import static android.R.attr.bitmap;
import static android.R.attr.button;

public class ProvaActivity extends AppCompatActivity {

    private ImageView imageView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);

        imageView = (ImageView) findViewById(R.id.imageview);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    public void run(){
                        // Faz Download de uma imagem
                        final Bitmap bitmap = HttpUtil.downloadImageBitmap();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                // Atualiza ImageView com a imagem
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                }.start();
            }
        });
    }
}



