package br.com.wolneyhqf.aulas.appcbr.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Wolney on 14/03/2017.
 */

public class AppIntentService extends IntentService {

    private final String TAG = "appcbr";
    private int count = 0;
    private boolean running = true;
    private final int MAX = 10;

    public AppIntentService() {
        super("AppIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int idThread = intent.getIntExtra("idThread", 0);
        while(count<MAX && running){
            try {
                Thread.sleep(1000);
                Log.d(TAG, "Thread " + idThread + " executando..." + count);
                count++;
            }catch (InterruptedException e){
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        running = false;
        Log.d(TAG, "AppIntentService.onDestroy()");
    }
}
