package com.example.mysecondapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import static com.example.mysecondapp.CriaBanco.EMAIL;
import static com.example.mysecondapp.CriaBanco.SENHA;
import static com.example.mysecondapp.CriaBanco.TABELA;

public class BancoController {

    private SQLiteDatabase db;
    private com.example.mysecondapp.CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String NOME, String EMAIL, String SENHA){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, NOME);
        valores.put(CriaBanco.EMAIL, EMAIL);
        valores.put(CriaBanco.SENHA, SENHA);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor fazerLogin(String email, String senha){
        db = banco.getWritableDatabase();
        String sql = "SELECT * FROM "+TABELA+" WHERE "+EMAIL+" = ? AND "+SENHA+" = ?";
        String[] selectionArgs = new String[]{ email, senha };
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        if(cursor != null) {
            cursor.moveToFirst();
            return cursor;
        }else{
            return null;
        }
    }
}