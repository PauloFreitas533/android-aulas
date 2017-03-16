package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.R;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.util.AlarmUtil;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    public long getTime(){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, 5);
        long time = c.getTimeInMillis();
        return time;
    }

    public void agendarAlarme(View view) {
        Intent intent = new Intent("receiver_appcbr");
        AlarmUtil.scheduleBroadcast(getBaseContext(), intent, getTime());
    }

    public void agendarAlarmeRepeticao(View view) {
        Intent intent = new Intent("receiver_appcbr");
        AlarmUtil.scheduleRepeatBroadcast(getBaseContext(), intent, getTime(), 100);
    }

    public void cancelarAlarme(View view) {
        Intent intent = new Intent("receiver_appcbr");
        AlarmUtil.cancel(getBaseContext(), intent);
    }
}
