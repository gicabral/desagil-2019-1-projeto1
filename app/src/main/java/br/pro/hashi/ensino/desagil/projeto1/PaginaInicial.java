package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaginaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);

        Button button1Example = (Button) findViewById(R.id.button1_example);
        Button button2Example = (Button) findViewById(R.id.button2_example);
        Button button3Example = (Button) findViewById(R.id.button3_example);


        button1Example.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInicial.this, EscreverMensagens.class);
                startActivity(intent);
            }
        });

        button2Example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PaginaInicial.this, MensagensProntas.class);
                startActivity(intent1);
            }
        });

        button3Example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(PaginaInicial.this, Tradutor.class);
                startActivity(intent2);
            }

        });

    }
}