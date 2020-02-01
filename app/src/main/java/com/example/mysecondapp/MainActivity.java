package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botao1;
    private Button botao3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao1 = (Button) findViewById(R.id.botao1);

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                botao1Activity();

            }

        }
        );

        botao3 = (Button) findViewById(R.id.button3);

        botao3.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          botaocep();

                                      }

                                  }
        );

    }

    private void botao1Activity() {

        startActivity(new Intent(MainActivity.this, login.class));

    }

    private void botaocep() {

        startActivity(new Intent(MainActivity.this,buscacep.class));

    }
}
