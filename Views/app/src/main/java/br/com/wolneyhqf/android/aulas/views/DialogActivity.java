package br.com.wolneyhqf.android.aulas.views;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        progressBar = (ProgressBar) findViewById(R.id.barra_progresso);

        Button buttonProgressDialog = (Button) findViewById(R.id.button_progress_dialog);
        buttonProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog dialog = new ProgressDialog(DialogActivity.this);
                dialog.setTitle("Exemplo ProgressDialog");
                dialog.setMessage("Aguarde um momento...");
                dialog.setIndeterminate(true);
                dialog.setCancelable(true);
                dialog.show();
            }
        });


        Button buttonAlertDialog = (Button) findViewById(R.id.button_alert_dialog);
        buttonAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setIcon(R.drawable.smile1);
                builder.setTitle("Exemplo AlertDialog");
                builder.setMessage("Você confirma a ação?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Clicou Sim", Toast.LENGTH_SHORT).show();
                        return;
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, "Clicou Não", Toast.LENGTH_SHORT).show();
                        return;
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button buttonProgressBar = (Button) findViewById(R.id.button_barra_progresso);
        buttonProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(i=0;i<=100; i++){
                            final int progresso = 3;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("AppViews", "Progresso: " + i);
                                    progressBar.setProgress(i);
                                    progressBar.refreshDrawableState();
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Log.e("AppViews", "Erro na execução");
                            }
                        }
                        Log.d("AppViews", "Fim da Simulação");
                    }
                }).start();
            }
        });
    }
}
