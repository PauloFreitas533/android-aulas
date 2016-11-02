package br.com.wolneyhqf.android.aulas.threads;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AsyncTaskActivity extends AppCompatActivity {

    private String urlDownload = "http://vignette2.wikia.nocookie.net/wikikariam/images/c/c8/Holanda.png/revision/latest?cb=20120113001353&path-prefix=pt-br";

    private ProgressDialog progressDialog;
    private ImageView imageViewDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        progressDialog = new ProgressDialog(this);
        imageViewDownload = (ImageView) findViewById(R.id.imageview_download);

        Button buttonDownload = (Button) findViewById(R.id.button_download_imagem);
        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadAsyncTask downloadAsyncTask = new DownloadAsyncTask();
                downloadAsyncTask.execute(urlDownload);
            }
        });
    }

    private class DownloadAsyncTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog.setTitle("Download da Imagem");
            progressDialog.setMessage("Aguarde um momento...");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmap = null;
            try {
                bitmap = downloadBitmap(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap){
            if(bitmap!=null){
                imageViewDownload.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }
    }

    public Bitmap downloadBitmap(String url) throws IOException{
        Bitmap bitmap = null;
        InputStream in = new URL(url).openStream();
        bitmap = BitmapFactory.decodeStream(in);
        in.close();
        return bitmap;
    }
}
