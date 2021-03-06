package com.example.mysecondapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }

    public void login(View view) {
        EditText email = findViewById(R.id.EMAIL);
        EditText senha = findViewById(R.id.SENHA);
        String strEmail = email.getText().toString();
        String strSenha = senha.getText().toString();
        boolean erro = false;

        if(strEmail.length() > 0 && strSenha.length() > 0){
            BancoController crud = new BancoController(getBaseContext());
            Cursor cursor = crud.fazerLogin(strEmail,strSenha);
            if(cursor == null || cursor.getCount() == 0){
                erro = true;
            }else {
                String resEmail = cursor.getString(cursor.getColumnIndex("email"));
                String resSenha = cursor.getString(cursor.getColumnIndex("senha"));

                if (strEmail.equals(resEmail) && strSenha.equals(resSenha)) {
                    Toast.makeText(getApplicationContext(), "Seja bem-vindo.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MapsActivity2.class);
                    startActivity(intent);
                } else {
                    erro = true;
                }
            }
        }else{
            erro = true;
        }

        if(erro)
            Toast.makeText(getApplicationContext(), "Credenciais incorretas.", Toast.LENGTH_LONG).show();
    }

    public void proximaTela(View view){

        startActivity(new Intent(login.this, cadastro.class));
    }
}