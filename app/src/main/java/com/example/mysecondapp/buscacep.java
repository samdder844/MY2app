package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class buscacep extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_buscacep);

            Button btnBuscarCep = findViewById(R.id.cep);

            final EditText cep = findViewById(R.id.CEP);
           //parei aqui no trabalho///
            final TextView resposta = findViewById(R.id.etMain_resposta);

            btnBuscarCep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        cep retorno = new HttpService(cep.getText().toString()).execute().get();
                        resposta.setText(retorno.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }