package br.com.wolneyhqf.android.aulas.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);

        final WebView webView = (WebView) findViewById(R.id.webview);
        final View progress = findViewById(R.id.progress);
        progress.setVisibility(View.INVISIBLE);


        // Injetar Javascript
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("javascript:alert('Hello World!');");

        // Injetar HTML
        //webView.loadDataWithBaseURL("", "<font color='blue'>HTML aqui</font>", "text/html", "UTF-8", "");

        // Abrir página na Web
        webView.loadUrl("https://developer.android.com/index.html");
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                progress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url){
                progress.setVisibility(View.INVISIBLE);
            }


        });
    }
}
