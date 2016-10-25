package br.com.wolneyhqf.android.aulas.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebViewJavascriptActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_javascript);

        webView = (WebView) findViewById(R.id.webview);

        // Ativar Javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Chamar métodos nativos pelo javascript
        webView.loadUrl("http://172.16.2.206:8080/HelloWord/index.html");
        webView.addJavascriptInterface(new ObjetoAndroidInterface(), "ObjetoAndroid");

//        webView.loadUrl("http://172.16.2.206:8080/HelloWorld2/pages/flot.html");


        // Inserir HTML
//        webView.loadData("<html><body>Hello World!</body></html>", "text/html", "UTF-8");
    }

    class ObjetoAndroidInterface{

        @JavascriptInterface
        public void teste(){
            Toast.makeText(getBaseContext(), "Método executado no Javascript", Toast.LENGTH_SHORT).show();
        }

    }
}
