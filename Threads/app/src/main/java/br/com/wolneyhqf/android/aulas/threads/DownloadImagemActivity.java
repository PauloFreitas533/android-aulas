package br.com.wolneyhqf.android.aulas.threads;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadImagemActivity extends AppCompatActivity {

    private String urlDownload = "https://s-media-cache-ak0.pinimg.com/originals/7f/f8/3a/7ff83a6ae33ae81484fca2cf3461665c.jpg";

    private ProgressDialog progressDialog;
    private ImageView imageViewDownload;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_imagem);

        progressDialog = new ProgressDialog(this);
        imageViewDownload = (ImageView) findViewById(R.id.imageview_download);
        handler = new Handler();

        Button buttonDownload = (Button) findViewById(R.id.button_download_imagem);
        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setTitle("Download da Imagem");
                progressDialog.setMessage("Aguarde um momento...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();

                downloadImagem(urlDownload);
            }
        });
    }

    public void downloadImagem(final String urlImg){

        new Thread(){

            @Override
            public void run(){

                try {
                    Bitmap bitmap = downloadBitmap(urlImg);
                    atualizaImagem(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }.start();


    }

    public void atualizaImagem(final Bitmap bitmap){
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                imageViewDownload.setImageBitmap(bitmap);
            }
        });
    }

    public Bitmap downloadBitmap(String url) throws IOException{
        Bitmap bitmap = null;
        InputStream in = new URL(url).openStream();
        bitmap = BitmapFactory.decodeStream(in);
        in.close();
        return bitmap;
    }

}
