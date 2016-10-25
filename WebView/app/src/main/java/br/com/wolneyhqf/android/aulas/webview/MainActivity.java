package br.com.wolneyhqf.android.aulas.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWebViewActivity = (Button) findViewById(R.id.button_webview_activity);
        buttonWebViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });


        Button buttonWebViewSwipeActivity = (Button) findViewById(R.id.button_webview_swipe_activity);
        buttonWebViewSwipeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewSwipeActivity.class);
                startActivity(intent);
            }
        });

        Button buttonWebViewJavascriptActivity = (Button) findViewById(R.id.button_webview_javascript_activity);
        buttonWebViewJavascriptActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewJavascriptActivity.class);
                startActivity(intent);
            }
        });
    }
}
