package br.com.wolneyhqf.android.aulas.broadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by wolney on 25/10/16.
 */

public class ReceiverEstatico extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "Mensagem recebida: " + msg, Toast.LENGTH_SHORT).show();
    }
}
