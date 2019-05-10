package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.util.LinkedList;
import android.widget.Toast;

public class EscreverMensagens extends AppCompatActivity {
    Translator translator = new Translator();
    String morseWritten;
    char romanWritten;
    String morseOnGoing = "";
    LinkedList<String> romanWords = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_mensagens);

        TextView textMessage = findViewById(R.id.text_message);
        TextView writtenMessage = findViewById(R.id.written_message);
        TextView writtenMorse = findViewById(R.id.written_morse);
        Button buttondel = findViewById(R.id.buttondel);
        Button buttonmorse = findViewById(R.id.buttonmorse);
        Button buttoncontact = findViewById(R.id.buttoncontact);
        Button buttonspace = findViewById(R.id.buttonspace);
        Button buttonhome = findViewById(R.id.buttonhome);


        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(EscreverMensagens.this, PaginaInicial.class);
                startActivity(intent2);
            }

        });

        buttonmorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                morseOnGoing += "-";
                writtenMorse.setText(morseOnGoing);
                return true;
            }

        });

        buttonmorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morseOnGoing += ".";
                writtenMorse.setText(morseOnGoing);
            }

        });

        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (morseOnGoing != null && morseOnGoing.length() > 0) {
                    morseOnGoing = morseOnGoing.substring(0, morseOnGoing.length() - 1);
                    writtenMorse.setText(morseOnGoing);
                } else {
                    String message = writtenMessage.getText().toString();

                    if (!message.isEmpty()) {
                        message = message.substring(0, message.length() - 1);
                        romanWords.clear();
                        romanWords.add(message);
                        writtenMessage.setText(message);
                    }
                }
            }

        });


        buttonspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (morseOnGoing != "") {
                        morseWritten = morseOnGoing;
                        romanWritten = translator.morseToChar(morseWritten);
                        morseOnGoing = "";
                        writtenMorse.setText(morseOnGoing);
                        romanWords.add(String.valueOf(romanWritten));
                        System.out.println(writtenMessage);

                        String content = "";

                        for (String word : romanWords) {
                            content += (word);
                        }

                        writtenMessage.setText(content);


                    } else {
                        romanWords.add(" ");
                    }
                } catch (Exception exception) {
                    Toast.makeText(getApplicationContext(), "Morse não reconhecido, favor tentar novamente.", Toast.LENGTH_LONG).show();
                    morseOnGoing = "";
                    writtenMorse.setText(morseOnGoing);
                }


            }
        });

        buttoncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                romanWritten = translator.morseToChar(morseWritten);
                romanWords.add(String.valueOf(romanWritten));
                String content = "";

                for (String word : romanWords) {
                    content += (word);
                }

                String msg = content;
                Intent intent = new Intent(EscreverMensagens.this, Contatos.class);
                intent.putExtra("KeyMessage", msg);
                startActivity(intent);


            }
        });

    }
}



