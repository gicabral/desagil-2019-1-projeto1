package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.LinkedList;

public class MensagensProntas extends AppCompatActivity {
    private LinkedList<TextView> messages = new LinkedList<>();
    private LinkedList<Integer> index = new LinkedList<>();
    private LinkedList<String> dfltMsg = new LinkedList<>();
    private static HashMap<String, String> map = new HashMap<>();

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens_prontas);

        TextView chosenMessage = findViewById(R.id.chosen_message);

        TextView writtenMessage1 = findViewById(R.id.written_message1);
        TextView writtenMessage2 = findViewById(R.id.written_message2);
        TextView writtenMessage3 = findViewById(R.id.written_message3);
        TextView writtenMessage4 = findViewById(R.id.written_message4);
        TextView writtenMessage5 = findViewById(R.id.written_message5);
        TextView writtenMessage6 = findViewById(R.id.written_message6);


        Button buttonup = findViewById(R.id.buttonup);
        Button buttonok = findViewById(R.id.buttonok);
        Button buttondown = findViewById(R.id.buttondown);
        Button buttonnext = findViewById(R.id.buttoncontact);
        Button buttonback = findViewById(R.id.buttonhome);
        Button buttonadd = findViewById(R.id.buttonadd);

        FirebaseApp.initializeApp(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference refMessages = database.getReference("mensagens");


        refMessages.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    montarlista(dataSnapshot);

                } catch (DatabaseException exception) {
                    showToast("Failed to parse value");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        messages.add(writtenMessage1);
        index.add(0);

        messages.add(writtenMessage2);
        index.add(1);

        messages.add(writtenMessage3);
        index.add(2);

        messages.add(writtenMessage4);
        index.add(3);

        messages.add(writtenMessage5);
        index.add(4);

        messages.add(writtenMessage6);
        index.add(5);




        buttonup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up();

            }
        });

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenMessage.setText(getMsg());

            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MensagensProntas.this, EscreverMensagens.class);
                startActivity(intent);

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
                String msg = getMsg();
                Intent intent = new Intent(MensagensProntas.this,Contatos.class);
                intent.putExtra("KeyMessage",msg);
                startActivity(intent);
            }

        });


        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MensagensProntas.this, PaginaInicial.class);
                startActivity(intent);
            }
        });
    }


    private String getMsg() {
        return this.dfltMsg.get(this.index.get(3));
    }


    public void montarlista(DataSnapshot dataSnapshot) {
        for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
            String msg = dataSnap.getValue(String.class);
            this.dfltMsg.add(msg);
        }

        this.messages.get(0).setText(this.dfltMsg.get(0));
        this.messages.get(1).setText(this.dfltMsg.get(1));
        this.messages.get(2).setText(this.dfltMsg.get(2));
        this.messages.get(3).setText(this.dfltMsg.get(3));
        this.messages.get(4).setText(this.dfltMsg.get(4));
        this.messages.get(5).setText(this.dfltMsg.get(5));
    }

    private void up() {

        for (int i = 0; i <= this.messages.size() - 1; i++) {

            TextView text = this.messages.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex - 1 >= 0) {
                text.setText(this.dfltMsg.get(paginaIndex - 1));
                this.index.set(i, paginaIndex - 1);
            } else {
                text.setText(this.dfltMsg.get(this.dfltMsg.size() - 1));
                this.index.set(i, this.dfltMsg.size() - 1);
            }
        }
    }

    private void down() {
        for (int i = 0; i <= this.messages.size() - 1; i++) {

            TextView text = this.messages.get(i);
            int paginaIndex = this.index.get(i);

            if (paginaIndex + 1 <= this.dfltMsg.size() - 1) {
                text.setText(this.dfltMsg.get(paginaIndex + 1));
                this.index.set(i, paginaIndex + 1);
            } else {
                text.setText(this.dfltMsg.get(0));
                this.index.set(i, 0);
            }
        }
    }
}