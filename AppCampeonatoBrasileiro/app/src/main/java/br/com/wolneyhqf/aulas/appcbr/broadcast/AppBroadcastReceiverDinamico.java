package br.com.wolneyhqf.aulas.appcbr.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wolney on 07/03/17.
 */

public class AppBroadcastReceiverDinamico extends BroadcastReceiver {

    private final String TAG = "appcompeonatobrasileiro";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "AppBroadcastReceiverDinamico.onReceive()");
    }

}
