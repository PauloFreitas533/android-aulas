package br.com.wolneyhqf.aulas.appcbr.activity;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.util.AlertUtil;
import br.com.wolneyhqf.aulas.appcbr.util.EncryptUtil;

public class LoginActivity extends BaseActivity implements FirebaseAuth.AuthStateListener {

    private FirebaseAuth firebaseAuth;

    private EditText editEmail;
    private EditText editPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        editEmail = (EditText) findViewById(R.id.edittext_email);
        editPassword = (EditText) findViewById(R.id.edittext_password);
        progressDialog = AlertUtil.getProgressDialog(this, "Verificando credenciais",
                "Aguarde um momento");
    }

    @Override
    public void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(this);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        firebaseAuth.removeAuthStateListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_logout:
                firebaseAuth.signOut();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void signIn(View view) {
        if(editEmail.getText().toString().trim().equals("")){
            AlertUtil.toast(getBaseContext(), "Informe o e-mail de usuário");
        }else if(editPassword.getText().toString().trim().equals("")){
            AlertUtil.toast(getBaseContext(), "Informe a senha de usuário");
        }else{
            progressDialog.show();

            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();
            password = EncryptUtil.encryptPassword(password);

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(!task.isSuccessful()){
                        if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                            AlertUtil.toast(getBaseContext(), "E-mail inválido");
                        }else if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            AlertUtil.toast(getBaseContext(), "Já existe um usuário inscrito com o e-mail informado");
                        }else{
                            AlertUtil.toast(getBaseContext(), "Ocorreu um erro. Tente Novamente.");
                        }
                    }
                }
            });
        }
    }

    public void login(View view) {
        if(editEmail.getText().toString().trim().equals("")){
            AlertUtil.toast(getBaseContext(), "Informe o e-mail de usuário");
        }else if(editPassword.getText().toString().trim().equals("")){
            AlertUtil.toast(getBaseContext(), "Informe a senha de usuário");
        }else {
            progressDialog.show();

            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();
            password = EncryptUtil.encryptPassword(password);

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if (!task.isSuccessful()) {
                        if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                            AlertUtil.toast(getBaseContext(), "Não há usuário registrado com o e-mail informado");
                        } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            AlertUtil.toast(getBaseContext(), "E-mail ou senha inválidos");
                        } else {
                            AlertUtil.toast(getBaseContext(), "Ocorreu um erro. Tente Novamente.");
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            String emailUser = user.getEmail();
            String uid = user.getUid();
            String userLog = uid + " - " + emailUser;
            Toast.makeText(this, "Usuário logado: " + userLog, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Usuário não logado", Toast.LENGTH_SHORT).show();
        }
    }
}
