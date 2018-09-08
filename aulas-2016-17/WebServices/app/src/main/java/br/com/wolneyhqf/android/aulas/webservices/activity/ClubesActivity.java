package br.com.wolneyhqf.android.aulas.webservices.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.android.aulas.webservices.R;
import br.com.wolneyhqf.android.aulas.webservices.adapter.ClubesAdapter;
import br.com.wolneyhqf.android.aulas.webservices.model.Clube;
import br.com.wolneyhqf.android.aulas.webservices.util.FileUtil;
import br.com.wolneyhqf.android.aulas.webservices.util.HttpUtil;

public class ClubesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubes);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_clubes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        carregarClubes();
    }

    public void carregarClubes(){
        if(HttpUtil.hasConnection(this)){
            new ClubesAsyncTask().execute();
        }else{
            Toast.makeText(this, "Verifique a conexão com a internet", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Clube> downloadClubes(){
        List<Clube> clubes = new ArrayList<Clube>();
        try {
            HttpURLConnection connection = HttpUtil.openConnection("http://104.131.32.72/aulas/android/webservices/listar-clubes.php", "GET", true, false);
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                JSONArray jsonArray = new JSONArray(FileUtil.bytesToString(inputStream));
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Clube clube = new Clube();
                    clube.setNome(jsonObject.getString("nome"));
                    clube.setEstado(jsonObject.getString("estado"));
                    clube.setEstadio(jsonObject.getString("estadio"));
                    clubes.add(clube);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clubes;
    }

    private ClubesAdapter.ClubeOnClickListener onClickClube(){
        return new ClubesAdapter.ClubeOnClickListener() {
            @Override
            public void onClickClube(View view, int index) {
                Toast.makeText(ClubesActivity.this, String.valueOf(index), Toast.LENGTH_SHORT).show();
            }
        };
    }

    class ClubesAsyncTask extends AsyncTask<Void, Void, List<Clube>>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected List<Clube> doInBackground(Void... strings){
            List<Clube> clubes = downloadClubes();
            return clubes;
        }

        @Override
        protected void onPostExecute(List<Clube> clubes){
            super.onPostExecute(clubes);
            recyclerView.setAdapter(new ClubesAdapter(ClubesActivity.this, clubes, onClickClube()));
        }

    }
}
