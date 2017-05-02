package br.com.wolneyhqf.aulas.appcbr.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.util.NotificationUtil;

import static android.R.attr.id;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }

    public void dispararNotificacaoSimples(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Nova Mensagem";
        String contentText = "Você possui novas notícias do seu time";
        Intent intent = new Intent(getBaseContext(), MensagemActivity.class);
        intent.putExtra("mensagem", "Seu time acaba de contratar um grande atacante");
        NotificationUtil.create(getBaseContext(), intent, contentTitle, contentText, id);
    }

    public void dispararNotificacaoHeadsup(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Nova Mensagem";
        String contentText = "Você possui novas notícias do seu time";
        Intent intent = new Intent(getBaseContext(), MensagemActivity.class);
        intent.putExtra("mensagem", "Seu time acaba de contratar um grande atacante");
        NotificationUtil.createHeadsUpNotification(getBaseContext(), intent, contentTitle, contentText, id);
    }

    public void dispararNotificacaoGrande(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Nova Mensagem";
        String contentText = "Você possui novas notícias do seu time";
        Intent intent = new Intent(getBaseContext(), MensagemActivity.class);
        intent.putExtra("mensagem", "Seu time acaba de contratar um grande atacante");

        List<String> lines = new ArrayList<>();
        lines.add("Mensagem 1");
        lines.add("Mensagem 2");
        lines.add("Mensagem 3");

        NotificationUtil.createBig(getBaseContext(), intent, contentTitle, contentText, lines, idNoficicacao);
    }

    public void dispararNotificacaoAcao(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Nova Mensagem";
        String contentText = "Você possui novas notícias do seu time";
        Intent intent = new Intent(getBaseContext(), MensagemActivity.class);
        intent.putExtra("mensagem", "Seu time acaba de contratar um grande atacante");
        NotificationUtil.createWithAction(getBaseContext(), intent, contentTitle, contentText, id);
    }

    public void dispararNotificacaoImagem(View view) {
        int idNoficicacao = 1;
        String contentTitle = "Nova Mensagem";
        String contentText = "Você possui novas notícias do seu time";
        Intent intent = new Intent(getBaseContext(), MensagemActivity.class);
        intent.putExtra("mensagem", "Seu time acaba de contratar um grande atacante");
        Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.sport);
        NotificationUtil.createBigImage(getBaseContext(), intent, contentTitle, contentText, bitmap, id);
    }
}
