package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela2 extends AppCompatActivity {

    public class MainActivity2 extends AppCompatActivity {

        private Button angry_btn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tela2activity);

            angry_btn = (Button) findViewById(R.id.angry_btn);

            angry_btn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              angry_btn

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
