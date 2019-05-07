package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MensagensProntas extends AppCompatActivity {
    private LinkedList<TextView> messages = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private String[] dfltMsg = {
            "Estou com sede",
            "Estou com fome",
            "Estou sentindo dor",
            "Por favor, venha para cá",
            "Preciso ir ao banheiro"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens_prontas);

        TextView writtenMessages = findViewById(R.id.written_messages);
        TextView writtenMessage1 = findViewById(R.id.written_message1);
        TextView writtenMessage2 = findViewById(R.id.written_message2);
        TextView writtenMessage3 = findViewById(R.id.written_message3);
        TextView writtenMessage4 = findViewById(R.id.written_message4);
        TextView writtenMessage5 = findViewById(R.id.written_message5);
        TextView chosenMessage = findViewById(R.id.chosen_message);
        Button buttonup = findViewById(R.id.buttonup);
        Button buttonok = findViewById(R.id.buttonok);
        Button buttondown = findViewById(R.id.buttondown);
        Button buttonnext = findViewById(R.id.buttonnext);
        Button buttonback = findViewById(R.id.buttonback);


        writtenMessage1.setText(this.dfltMsg[0]);
        messages.add(writtenMessage1);
        index.add(0);

        writtenMessage2.setText(this.dfltMsg[1]);
        messages.add(writtenMessage2);
        index.add(1);

        writtenMessage3.setText(this.dfltMsg[2]);
        messages.add(writtenMessage3);
        index.add(2);

        writtenMessage4.setText(this.dfltMsg[3]);
        messages.add(writtenMessage4);
        index.add(3);

        writtenMessage5.setText(this.dfltMsg[4]);
        messages.add(writtenMessage5);
        index.add(4);


        buttonup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up();
            }
        });

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSelectedMsg() == "Estou com sede") {
                    String msg1 = writtenMessage1.getText().toString();
                    chosenMessage.setText(msg1);

                } else if (getSelectedMsg() == "Estou com fome") {
                    String msg2 = writtenMessage2.getText().toString();
                    chosenMessage.setText(msg2);

                } else if (getSelectedMsg() == "Estou sentindo dor") {
                    String msg3 = writtenMessage3.getText().toString();
                    chosenMessage.setText(msg3);

                } else if (getSelectedMsg() == "Por favor, venha para cá") {
                    String msg4 = writtenMessage4.getText().toString();
                    chosenMessage.setText(msg4);

                } else if (getSelectedMsg() == "Preciso ir ao banheiro") {
                    String msg5 = writtenMessage5.getText().toString();
                    chosenMessage.setText(msg5);
                }
            }
        });

        buttondown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                down();
            }
        });


        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MensagensProntas.this, Contatos.class);
                startActivity(intent1);
            }

        });


         buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent1 = new Intent(MensagensProntas.this, PaginaInicial.class);
             startActivity(intent1);
        }
    });
}


    private String getSelectedMsg() {
        return this.dfltMsg[this.index.get(2)];

    }

    private void down() {

        for (int i = 0; i <= this.messages.size() - 1; i++) {

            TextView text = this.messages.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex - 1 >= 0) {
                text.setText(this.dfltMsg[paginaIndex - 1]);
                this.index.set(i, paginaIndex - 1);
            } else {
                text.setText(this.dfltMsg[this.dfltMsg.length - 1]);
                this.index.set(i, this.dfltMsg.length - 1);
            }
        }
    }

    private void up() {
        for (int i = 0; i <= this.messages.size() - 1; i++) {

            TextView text = this.messages.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex + 1 <= this.dfltMsg.length - 1) {
                text.setText(this.dfltMsg[paginaIndex + 1]);
                this.index.set(i, paginaIndex + 1);
            } else {
                text.setText(this.dfltMsg[0]);
                this.index.set(i, 0);
            }
        }
    }

}



