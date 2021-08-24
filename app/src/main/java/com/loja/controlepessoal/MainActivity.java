package com.loja.controlepessoal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        setButtonBackVisible(false); //Oculta botão navigation do slider
        setButtonNextVisible(false);

        addSlide(new SimpleSlide.Builder()
            .title("Titulo")
                .description("Descricão")
                .image(R.drawable.um)
                .background(android.R.color.holo_green_light)
                .build()
        );
        addSlide(new SimpleSlide.Builder()
                .title("Titulo 2")
                .description("Descricão 2")
                .image(R.drawable.dois)
                .background(android.R.color.holo_green_light)
                .build()
        );
        addSlide(new SimpleSlide.Builder()
                .title("Titulo 3")
                .description("Descricão 3")
                .image(R.drawable.tres)
                .background(android.R.color.holo_green_light)
                .build()
        );
    }
}