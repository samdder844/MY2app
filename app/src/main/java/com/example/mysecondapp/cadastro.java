package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button botao = (Button) findViewById(R.id.botaocad);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText email = (EditText) findViewById((R.id.EMAIL));
                EditText senha = (EditText) findViewById(R.id.SENHA);
                EditText senhaConf = (EditText) findViewById(R.id.senhaconfere);

                String nomeString = nome.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String senhaConfString = senhaConf.getText().toString();

                if (nomeString.isEmpty() || emailString.isEmpty() || senhaString.isEmpty() || senhaConfString.isEmpty()) {

                    String resultado = "preencha todos os campos";

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                } else {
                    if (senhaString.equals(senhaConfString)) {
                        //String resultado = "cadastrou";
                        String resultado = crud.insereDado(nomeString, emailString, senhaString);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                resultado, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    } else {
                        String resultado = "as senhas não conferem";

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
