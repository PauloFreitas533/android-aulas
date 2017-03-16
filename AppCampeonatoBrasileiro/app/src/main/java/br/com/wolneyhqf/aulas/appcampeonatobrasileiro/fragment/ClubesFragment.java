package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.R;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.adapter.ClubesAdapter;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.model.Clube;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.util.FileUtil;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.util.HttpUtil;

/**
 * Created by wolney on 21/02/17.
 */

public class ClubesFragment extends Fragment {

    public static final String TAG = ".fragment.ClubesFragment";

    private RecyclerView recyclerView;
    private ClubesAdapter clubesAdapter;
    private List<Clube> clubes = new ArrayList<>();
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clubes, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Carregando Dados");
        progressDialog.setMessage("Aguarde um momento...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_clubes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        clubesAdapter = new ClubesAdapter(getContext(), clubes, onClickClube());
        recyclerView.setAdapter(clubesAdapter);

        carregar();

        return view;
    }

    public void carregar(){
        if(HttpUtil.hasConnection(getContext())){
            new ClubesAsyncTask().execute();
        }else{
            Toast.makeText(getContext(), "Verifique a conexão com a internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void carregarClubes(){
        try {
            HttpURLConnection connection = HttpUtil.openConnection("http://192.168.25.5:8080/WebServiceClubesFutebol/rest/clubes", "GET", true, false);
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                JSONArray jsonArray = new JSONArray(FileUtil.bytesToString(inputStream));
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Clube clube = new Clube();
                    clube.setNome(jsonObject.getString("nome"));
                    clube.setEstado(jsonObject.getString("estado"));
                    clube.setEstadio(jsonObject.getString("estadio"));
                    clube.setCidade(jsonObject.getString("cidade"));
                    clubes.add(clube);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private ClubesAdapter.ClubeOnClickListener onClickClube(){
        return new ClubesAdapter.ClubeOnClickListener() {
            @Override
            public void onClickClube(View view, int index) {
                Toast.makeText(getContext(), String.valueOf(index), Toast.LENGTH_SHORT).show();
            }
        };
    }

    class ClubesAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... strings){
            carregarClubes();
            return null;
        }

        @Override
        protected void onPostExecute(Void v){
            super.onPostExecute(v);
            clubesAdapter.notifyDataSetChanged();
            progressDialog.dismiss();
        }

    }

}
