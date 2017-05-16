package br.com.wolneyhqf.android.aulas.threads;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.wolneyhqf.android.aulas.threads.util.MensagemHandler;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);



        Button buttonDispararMensagem = (Button) findViewById(R.id.button_msg);
        buttonDispararMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MensagemHandler handler = new MensagemHandler(HandlerActivity.this);
                Message msg = new Message();

                Bundle bundle = new Bundle();
                bundle.putString("minha_mensagem", "Olá todos!");
                msg.setData(bundle);

                msg.what = 9854;

                handler.sendMessageDelayed(msg, 3000);
                //handler.sendMessage(msg);

            }
        });


        Button buttonDispararMensagemRunnable = (Button) findViewById(R.id.button_msg_runnable);
        buttonDispararMensagemRunnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(HandlerActivity.this, "A Mensagem Chegou! (Executada no Runnable)", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);

            }
        });

    }
}
