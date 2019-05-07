package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class EscreverMensagens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_mensagens);

        TextView textMessage = findViewById(R.id.text_message);
        EditText editMessage = findViewById(R.id.edit_message);
        Button showMessage = findViewById(R.id.show_message);
        TextView displayMessage = findViewById(R.id.message_displayer);
        Button buttonnext = findViewById(R.id.buttonnext);

        showMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editMessage.getText().toString();
                editMessage.setText("Escreva aqui...");
                displayMessage.setText(content);
            }
        });

        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EscreverMensagens.this, Enviar.class);
                startActivity(intent1);
            }


        });
    }
}
