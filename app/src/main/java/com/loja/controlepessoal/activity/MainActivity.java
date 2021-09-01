package com.loja.controlepessoal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.loja.controlepessoal.R;
import com.loja.controlepessoal.activity.CadastroActivity;
import com.loja.controlepessoal.activity.LoginActivity;
import com.loja.controlepessoal.config.ConfiguracaoFirebase;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        setButtonBackVisible(false); //Oculta botão navigation do slider
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_1)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_2)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_3)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_4)

                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_green_light)
                .fragment(R.layout.intro_cadastro)
                .canGoForward(false)
                .build()
        );

/*
        addSlide(new SimpleSlide.Builder()
            .title("Cadastre-se")
                .description("Cadastrando você terá acesso a um melhor controle pessoal")
                .image(R.drawable.um)
                .background(android.R.color.holo_green_light)
                .build()
        );
        addSlide(new SimpleSlide.Builder()
                .title("Registre seus gastos")
                .description("")
                .image(R.drawable.dois)
                .background(android.R.color.holo_green_light)
                .build()
        );
        addSlide(new SimpleSlide.Builder()
                .title("Controle Gastos.")
                .description("Tenha um melhor controle sobre seus gastos!")
                .image(R.drawable.tres)
                .background(android.R.color.holo_green_light)
                .build()


        );

 */
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificaUsuarioLogado();
    }

    public void btnEntrar(View view){

        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btnCadastrar(View view){

        startActivity(new Intent(this, CadastroActivity.class));
    }
    public void verificaUsuarioLogado(){
            autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
            if (autenticacao.getCurrentUser() != null){
                abrirtelaPrincipal();
            }
    }

    public void abrirtelaPrincipal(){
        startActivity(new Intent(this, PrincipalActivity.class));
    }
}