package com.loja.controlepessoal.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.loja.controlepessoal.R;
import com.loja.controlepessoal.config.ConfiguracaoFirebase;
import com.loja.controlepessoal.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Button botaoEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.btn_entrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {

            String textoEmail = campoEmail.getText().toString();
            String textoSenha = campoSenha.getText().toString();
            @Override
            public void onClick(View v) {
                if(!textoEmail.isEmpty()){
                    if(!textoSenha.isEmpty()){
                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();

                    }else{
                        Toast.makeText(LoginActivity.this, "Campo Email não preenchido, Verifique!", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this, "Campo Senha não preenchido, Verifique!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void validarLogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirtelaPrincipal();
                }else{
                    String excecao = "";
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthInvalidUserException e){

                        excecao = "Usuário não está cadastrado!";

                    }catch (FirebaseAuthInvalidCredentialsException e){

                        excecao = "Usuário e senha não correspondem!!";

                    }catch (Exception e){
                        excecao = "Erro ao cadastar usuário: " + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, excecao, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void abrirtelaPrincipal(){
        startActivity(new Intent(this, PrincipalActivity.class));
        finish();
    }
}