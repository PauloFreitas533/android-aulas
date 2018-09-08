package br.com.wolneyhqf.aulas.appcbr.service;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import br.com.wolneyhqf.aulas.appcbr.activity.MainActivity;
import br.com.wolneyhqf.aulas.appcbr.util.NotificationUtil;

public class AppCbrFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Map<String, String> data = remoteMessage.getData();

        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        String title = data.get("partida");
        String body = data.get("estadio") + " - " + data.get("hora");

        NotificationUtil.create(getBaseContext(), intent, title, body, 1);
    }

}
