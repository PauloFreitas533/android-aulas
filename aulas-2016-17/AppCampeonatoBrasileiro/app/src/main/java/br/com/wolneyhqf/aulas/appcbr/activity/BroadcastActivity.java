package br.com.wolneyhqf.aulas.appcbr.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.broadcast.AppBroadcastReceiverDinamico;

public class BroadcastActivity extends AppCompatActivity {

    private final String TAG = "appcbr";
    private AppBroadcastReceiverDinamico appBroadcastReceiverDinamico = new AppBroadcastReceiverDinamico();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        registerReceiver(appBroadcastReceiverDinamico, new IntentFilter("receiver_appcbr_dinamico"));
    }

    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(appBroadcastReceiverDinamico);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("receiver_appcbr");
        sendBroadcast(intent);
    }


    public void sendBroadcastDinamico(View view) {
        Intent intent = new Intent("receiver_appcbr_dinamico");
        sendBroadcast(intent);
    }

    public void openActicityNotificacao(View view) {
        Intent intent = new Intent(getBaseContext(), NotificationsActivity.class);
        startActivity(intent);
    }

    public void openActicityAlarm(View view) {
        Intent intent = new Intent(getBaseContext(), AlarmActivity.class);
        startActivity(intent);
    }

    public void openActicityService(View view) {
        Intent intent = new Intent(getBaseContext(), ServiceActivity.class);
        startActivity(intent);
    }
}
