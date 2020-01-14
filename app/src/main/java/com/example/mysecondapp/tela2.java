package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela2 extends AppCompatActivity {

    public class MainActivity2 extends AppCompatActivity {

        private Button botao1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tela2activity);

            botao1 = (Button) findViewById(R.id.botao1);

            botao1.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              botao1Activity();

                                          }

                                      }
            );
        }

        private void botao1Activity() {

            startActivity(new Intent(com.example.mysecondapp.tela2.this, tela3.class));

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tela3activity);
        }
    }
}
