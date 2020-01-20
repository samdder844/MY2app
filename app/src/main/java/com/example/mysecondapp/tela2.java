package com.example.mysecondapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela2 extends AppCompatActivity {

    private Button entrar;
    private  Button entrarR;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2activity);

        entrar = (Button) findViewById(R.id.entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botao2Activity();
            }

        });

        entrarR = (Button) findViewById(R.id.botao2);

        entrarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximaTela();

            }
        });
    }

    private void botao2Activity() {

        startActivity(new Intent(tela2.this, tela3.class));
    }

    private void proximaTela(){

        startActivity(new Intent(tela2.this, cadastro.class));
    }
}