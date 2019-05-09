package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class Contatos extends AppCompatActivity {

    private LinkedList<TextView> contacts = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private String[] contactNames = {
            "Harry Potter",
            "Lucio Malfoy",
            "Thor"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        TextView contact1 = findViewById(R.id.contact1);
        TextView contact2 = findViewById(R.id.contact2);
        TextView contact3 = findViewById(R.id.contact3);
        Button buttonup = findViewById(R.id.buttonup);
        Button buttonok = findViewById(R.id.buttonok);
        Button buttondown = findViewById(R.id.buttondown);
        Button buttonnext = findViewById(R.id.buttonnext);
        Button buttonback = findViewById(R.id.buttonback);


        contact1.setText(this.contactNames[0]);
        contacts.add(contact1);
        index.add(0);

        contact2.setText(this.contactNames[1]);
        contacts.add(contact2);
        index.add(1);

        contact3.setText(this.contactNames[2]);
        contacts.add(contact3);
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
                if (getSelectedContacts() == "Harry Potter") {
                    String number1 = "5541988146111";

                } else if (getSelectedContacts() == "Lucio Malfoy") {
                    String number2 = "5511986527674";

                } else if (getSelectedContacts() == "Estou sentindo dor") {
                    String number3 = "5511959690079";
                }
            }
        });

        buttondown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                down();
            }
        });





        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Contatos.this, PaginaInicial.class);
                startActivity(intent1);
            }
        });
    }


    private String getSelectedContacts() {
        return this.contactNames[this.index.get(1)];

    }

    private void down() {

        for (int i = 0; i <= this.contacts.size() - 1; i++) {

            TextView text = this.contacts.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex - 1 >= 0) {
                text.setText(this.contactNames[paginaIndex - 1]);
                this.index.set(i, paginaIndex - 1);
            } else {
                text.setText(this.contactNames[this.contactNames.length - 1]);
                this.index.set(i, this.contactNames.length - 1);
            }
        }
    }

    private void up() {
        for (int i = 0; i <= this.contacts.size() - 1; i++) {

            TextView text = this.contacts.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex + 1 <= this.contactNames.length - 1) {
                text.setText(this.contactNames[paginaIndex + 1]);
                this.index.set(i, paginaIndex + 1);
            } else {
                text.setText(this.contactNames[0]);
                this.index.set(i, 0);
            }
        }
    }
}

