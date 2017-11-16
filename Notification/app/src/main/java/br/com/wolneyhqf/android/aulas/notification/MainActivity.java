package br.com.wolneyhqf.android.aulas.notification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dispararNotificacaoSimples(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Mensagem recebida";
        String contentText = "Você possui novas mensagens";
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("mensagem", "Hello World!");
        NotificationUtil.create(getBaseContext(), intent, contentTitle, contentText, id);
    }

    public void dispararNotificacaoHeadsup(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Mensagem recebida";
        String contentText = "Você possui novas mensagens";
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("mensagem", "Hello World!");
        NotificationUtil.createHeadsUpNotification(getBaseContext(), intent, contentTitle, contentText, id);
    }

    public void dispararNotificacaoGrande(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Mensagem recebida";
        String contentText = "Você possui novas mensagens";
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("mensagem", "Hello World!");

        List<String> lines = new ArrayList<>();
        lines.add("Mensagem 1");
        lines.add("Mensagem 2");
        lines.add("Mensagem 3");

        NotificationUtil.createBig(getBaseContext(), intent, contentTitle, contentText, lines, idNoficicacao);
    }

    public void dispararNotificacaoAcao(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Mensagem recebida";
        String contentText = "Você possui novas mensagens";
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("mensagem", "Hello World!");
        NotificationUtil.createWithAction(getBaseContext(), intent, contentTitle, contentText, id);
    }

    public void dispararNotificacaoImagem(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Mensagem recebida";
        String contentText = "Você possui novas mensagens";
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.putExtra("mensagem", "Hello World!");
        Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.unifavip);
        NotificationUtil.createBigImage(getBaseContext(), intent, contentTitle, contentText, bitmap, id);
    }

}
