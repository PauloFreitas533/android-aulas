package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.activity.MensagemActivity;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.util.NotificationUtil;

import static android.R.attr.id;

public class AppBrodcastReceiver extends BroadcastReceiver {

    private final String TAG = "appcbr";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "AppBrodcastReceiver.onReceive()");
        int idNoficicacao = 1;
        String contentTitle = "Nova Mensagem";
        String contentText = "Você possui novas notícias do seu time";
        Intent intentMsg = new Intent(context, MensagemActivity.class);
        intent.putExtra("mensagem", "Seu time acaba de contratar um grande atacante");
        NotificationUtil.create(context, intentMsg, contentTitle, contentText, id);
    }

}
