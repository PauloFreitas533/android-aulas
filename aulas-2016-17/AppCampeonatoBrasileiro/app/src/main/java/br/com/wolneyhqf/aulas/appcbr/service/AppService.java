package br.com.wolneyhqf.aulas.appcbr.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wolney on 14/03/2017.
 */

public class AppService extends Service {

    private final String TAG = "appcbr";
    private List<SimulatorThread> threads = new ArrayList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        Log.d(TAG, "AppService.onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG, "AppService.onStartCommand(): " + startId);
        SimulatorThread simulatorThread = new SimulatorThread(startId);
        simulatorThread.start();
        threads.add(simulatorThread);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        for(SimulatorThread thread : threads){
            thread.setRunning(false);
        }
        Log.d(TAG, "AppService.onDestroy()");
    }

    class SimulatorThread extends Thread {

        private int idThread;
        private int count = 0;
        private boolean running = true;
        private final int MAX = 10;

        public SimulatorThread(int idThread){
            this.idThread = idThread;
        }

        public void setRunning(boolean running){
            this.running = running;
        }

        public void run(){
            try{
                while(count<MAX && running){
                    Thread.sleep(1000);
                    Log.d(TAG, "Thread " + idThread + " executando..." + count);
                    count++;
                }
            }catch (InterruptedException e){
                Log.e(TAG, e.getMessage(), e);
            }finally {
                stopSelf(idThread);
            }
        }
    }
}
