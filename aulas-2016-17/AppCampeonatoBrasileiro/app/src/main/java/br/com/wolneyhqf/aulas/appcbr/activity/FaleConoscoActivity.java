package br.com.wolneyhqf.aulas.appcbr.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.model.FaleConosco;
import br.com.wolneyhqf.aulas.appcbr.util.HttpHelper;
import br.com.wolneyhqf.aulas.appcbr.util.LogUtil;

public class FaleConoscoActivity extends BaseActivity {

    private final String TAG = "appcbr";

    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextMensagem;
    private ProgressDialog progressDialog;
    private HttpHelper httpHelper = new HttpHelper("http://104.131.32.72/appcbr");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fale_conosco);

        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextNome = (EditText) findViewById(R.id.edittext_nome);
        editTextEmail = (EditText) findViewById(R.id.edittext_email);
        editTextMensagem = (EditText) findViewById(R.id.edittext_mensagem);

        progressDialog = new ProgressDialog(FaleConoscoActivity.this);
        progressDialog.setTitle("Enviando Mensagem");
        progressDialog.setMessage("Aguarde um momento...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void enviarFaleConosco(View view) {

        if(editTextNome.getText().toString().equals("")){
            Toast.makeText(getBaseContext(), "Informe seu nome", Toast.LENGTH_SHORT).show();
            editTextNome.requestFocus();
        }else if(editTextEmail.getText().toString().equals("")){
            Toast.makeText(getBaseContext(), "Informe seu e-mail", Toast.LENGTH_SHORT).show();
            editTextEmail.requestFocus();
        }else if(editTextMensagem.getText().toString().equals("")){
            Toast.makeText(getBaseContext(), "Informe sua mensagem", Toast.LENGTH_SHORT).show();
            editTextMensagem.requestFocus();
        }else{
            FaleConosco faleConosco = new FaleConosco();
            faleConosco.setNome(editTextNome.getText().toString());
            faleConosco.setEmail(editTextEmail.getText().toString());
            faleConosco.setMensagem(editTextMensagem.getText().toString());

            new FaleConoscoAsyncTask().execute(faleConosco);
        }
    }


    class FaleConoscoAsyncTask extends AsyncTask<FaleConosco, Void, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected String doInBackground(FaleConosco... faleConoscoArray){
            FaleConosco faleConosco = faleConoscoArray[0];
            Gson gson = new Gson();
            String body = gson.toJson(faleConosco);
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            String response = httpHelper.doPOST("fale-conosco.php",  headers, body);
            LogUtil.writeLog(FaleConoscoActivity.this, "FaleConoscoActivity.enviarFaleConosco()");
            return response;
        }

        @Override
        protected void onPostExecute(String response){
            super.onPostExecute(response);
            progressDialog.dismiss();
            if(response!=null){
                editTextNome.setText("");
                editTextEmail.setText("");
                editTextMensagem.setText("");
                Toast.makeText(FaleConoscoActivity.this, "Mensagem enviada com sucesso.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(FaleConoscoActivity.this, "Erro ao enviar a mensagem", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
