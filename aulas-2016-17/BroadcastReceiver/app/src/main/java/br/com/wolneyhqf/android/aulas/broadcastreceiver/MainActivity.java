package br.com.wolneyhqf.android.aulas.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiverDinamico = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView textView = (TextView) findViewById(R.id.textview_receiver);
            String msg = intent.getStringExtra("msg");
            textView.setText(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonReceiverEstatico = (Button) findViewById(R.id.button_receiver_estatico);
        buttonReceiverEstatico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("MEU_RECEIVER");
                intent.putExtra("msg", "Hello Receiver Estático!");
                sendBroadcast(intent);
            }
        });

        Button buttonReceiverDinamico = (Button) findViewById(R.id.button_receiver_dinamico);
        buttonReceiverDinamico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("RECEIVER_DINAMICO");
                intent.putExtra("msg", "Hello Receiver Dinâmico!");
                sendBroadcast(intent);
            }
        });

        registerReceiver(broadcastReceiverDinamico, new IntentFilter("RECEIVER_DINAMICO"));
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(broadcastReceiverDinamico);
    }

}
