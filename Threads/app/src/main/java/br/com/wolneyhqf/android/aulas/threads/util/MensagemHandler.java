package br.com.wolneyhqf.android.aulas.threads.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by wolney on 03/10/16.
 */

public class MensagemHandler extends Handler {

    private Context context;

    public static final int MSG_01 = 1;

    public MensagemHandler(Context context){
        this.context = context;
    }


    public void handleMessage(Message msg){
        switch(msg.what){
            case MSG_01:
                Toast.makeText(context, "A Mensagem Chegou!", Toast.LENGTH_SHORT).show();
                break;
            case 9854:
                Bundle bundle = msg.getData();
                String mensagem = bundle.getString("minha_mensagem");
                Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
        }
    }


}
