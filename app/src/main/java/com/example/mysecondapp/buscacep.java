package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buscacep extends AppCompatActivity {



    Button btnMain_buscarCep = findViewById(R.id.cep);

        btnMain_buscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });



    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscacep);
    }

}
