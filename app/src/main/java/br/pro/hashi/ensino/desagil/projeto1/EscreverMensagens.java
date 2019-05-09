package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.util.LinkedList;

public class EscreverMensagens extends AppCompatActivity {
    Translator translator = new Translator();
    String morseWritten;
    String morseOnGoing;
    LinkedList<String> romanWords = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_mensagens);

        TextView textMessage = findViewById(R.id.text_message);
        EditText editMessage = findViewById(R.id.edit_message);
        Button buttondel = findViewById(R.id.buttondel);
        Button buttoncontact = findViewById(R.id.buttoncontact);
        Button buttonspace = findViewById(R.id.buttonspace);
        Button buttonhome = findViewById(R.id.buttonhome);


        buttoncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EscreverMensagens.this, Contatos.class);
                startActivity(intent1);
            }
        });

        buttonhome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(EscreverMensagens.this, PaginaInicial.class);
                    startActivity(intent2);
                }

        });

        buttonmorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public void onClick(View v) {
                morseOnGoing += "-";
            }

        });

        buttonmorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morseOnGoing += ".";
            }

        });

        buttonspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morseWritten = morseOnGoing;
                morseOnGoing = "";
                romanWords.add(translator.morseToChar(morseWritten));
            }

        });

    }
}
