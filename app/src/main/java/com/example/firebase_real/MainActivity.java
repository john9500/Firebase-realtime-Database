package com.example.firebase_real;
//Author : John sathyaseelan
//contact no : 9500933297

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Spinner spin1;
    Button btn;
    DatabaseReference db1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editTextName);

        db1 = FirebaseDatabase.getInstance().getReference("Users");

        spin1 = findViewById(R.id.spinnerGenres);
        btn = findViewById(R.id.buttonAddArtist);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtists();

            }

            private void addArtists() {
                String name = ed1.getText().toString();
                String select = spin1.getSelectedItem().toString();
                if(!TextUtils.isEmpty(name)){
                    String id = db1.push().getKey();
                    //object creation
                    John artist  = new John(name, select, id);
                    //Artistsaving
                    db1.child(id).setValue(artist);
                    //Forvice versa
                    ed1.setText("");
                    Toast.makeText(MainActivity.this,"Successfully added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Enter name",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}