package br.pro.hashi.ensino.desagil.projeto1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.ArcShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class PaginaInicial extends AppCompatActivity {

    private LinkedList<TextView> pagina = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private String[] pageName  = {
            "Escrever mensagem",
            "Mensagens Prontas",
            "Dicionario"
    };

    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") ArcShape arc = new ArcShape((float) 0.5,1);
        @SuppressLint("DrawAllocation") Paint paint  = new Paint();
        paint.setColor(Color.WHITE);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);

        TextView writeMsg = (TextView) findViewById(R.id.writeMsg);
        TextView defaultMsg = (TextView) findViewById(R.id.defaultMsg);
        TextView dictionaire = (TextView) findViewById(R.id.dictionaire);
        Button buttonup = (Button) findViewById(R.id.buttonup);
        Button buttonok = (Button) findViewById(R.id.buttonok);
        Button buttondown = (Button) findViewById(R.id.buttondown);


        writeMsg.setText(this.pageName[0]);
        pagina.add(writeMsg);
        index.add(0);

        defaultMsg.setText(this.pageName[1]);
        pagina.add(defaultMsg);
        index.add(1);

        dictionaire.setText(this.pageName[2]);
        pagina.add(dictionaire);
        index.add(2);


        buttonup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up();
            }
        });

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( getSelectedMsg() == "Escrever mensagem") {

                    Intent intent1 = new Intent(PaginaInicial.this, EscreverMensagens.class);
                    startActivity(intent1);
                }
                else if (getSelectedMsg() == "Mensagens Prontas"){
                    Intent intent1 = new Intent(PaginaInicial.this, MensagensProntas.class);
                    startActivity(intent1);
                }
                else if (getSelectedMsg() == "Dicionario"){
                    Intent intent1 = new Intent(PaginaInicial.this, Tradutor.class);
                    startActivity(intent1);
                }

            }
        });

        buttondown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                down();

            }
        });

    }

        private String getSelectedMsg() {
            return this.pageName[this.index.get(1)];
        }

        private void down() {
            // Essa função sobe a lista de mensagens.

            // Loop que passa por cada caixa de texto e o index da mensagem que está mostrando.
            for (int i = 0; i <= this.pagina.size() - 1; i++) {
                // Pegando o index e a caixa de texto.
                TextView textBox = this.pagina.get(i);
                int paginaIndex = this.index.get(i);


                // Lógica que se encarrega de subir a lista.
                if (paginaIndex - 1 >= 0) {
                    textBox.setText(this.pageName[paginaIndex - 1]);
                    this.index.set(i, paginaIndex - 1);
                } else {
                    textBox.setText(this.pageName[this.pageName.length - 1]);
                    this.index.set(i, this.pageName.length - 1);
                }
            }
        }

        private void up(){
            // Essa função sobe a lista de mensagens.

            // Loop que passa por cada caixa de texto e o index da mensagem que está mostrando.
            for (int i = 0; i <= this.pagina.size() - 1; i++) {
                // Pegando o index e a caixa de texto.
                TextView textBox = this.pagina.get(i);
                int paginaIndex = this.index.get(i);

                // Lógica que se encarrega de subir a lista.
                if (paginaIndex + 1 <= this.pageName.length - 1) {
                    textBox.setText(this.pageName[paginaIndex + 1]);
                    this.index.set(i, paginaIndex + 1);
                } else {
                    textBox.setText(this.pageName[0]);
                    this.index.set(i, 0);
                }
            }
        }

}