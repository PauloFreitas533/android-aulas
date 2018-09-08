package com.wolneyhqf.aulas.wsretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wolneyhqf.aulas.wsretrofit.adapter.SeriadosAdapter;
import com.wolneyhqf.aulas.wsretrofit.model.Seriado;
import com.wolneyhqf.aulas.wsretrofit.service.SeriadoService;
import com.wolneyhqf.aulas.wsretrofit.util.HttpHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewMessage;
    private RecyclerView recyclerView;
    private SeriadosAdapter seriadosAdapter;
    private List<Seriado> seriados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textViewMessage = (TextView) findViewById(R.id.msg);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_seriados);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        seriadosAdapter = new SeriadosAdapter(this, seriados, onClickSeriado());
        recyclerView.setAdapter(seriadosAdapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(HttpHelper.hasConnection(getBaseContext())){
            listarSeriados();
        }else {
            textViewMessage.setText("Sem conexão com a internet.");
            textViewMessage.setVisibility(View.VISIBLE);
        }
    }

    private SeriadosAdapter.SeriadoOnClickListener onClickSeriado(){
        return new SeriadosAdapter.SeriadoOnClickListener() {
            @Override
            public void onClickSeriado(View view, int index) {
                Toast.makeText(getBaseContext(), seriados.get(index).getNome(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void listarSeriados() {
        textViewMessage.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://191.252.92.123:8080/Seriados/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeriadoService seriadoService = retrofit.create(SeriadoService.class);
        Call<List<Seriado>> call = seriadoService.listar();
        call.enqueue(new Callback<List<Seriado>>() {
            @Override
            public void onResponse(Call<List<Seriado>> call, Response<List<Seriado>> response) {
                for(Seriado seriado : response.body()){
                    seriados.add(seriado);
                }
                progressBar.setVisibility(View.INVISIBLE);
                seriadosAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Seriado>> call, Throwable t) {
                t.printStackTrace();
                progressBar.setVisibility(View.INVISIBLE);
                textViewMessage.setText("Ocorreu um erro.");
                textViewMessage.setVisibility(View.VISIBLE);
            }
        });
    }
}
