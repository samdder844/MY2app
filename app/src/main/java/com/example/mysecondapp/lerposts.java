package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class lerposts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lerposts);


        ListView list = findViewById(R.id.list);

        ArrayList<Posts> retorno = null;

        try {
            retorno = new HttpRequisition().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (retorno != null) {
            ArrayAdapter<Posts> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, retorno);
            list.setAdapter(adapter);
            Log.i("sucesso", "ok.");
        } else {
            Log.i("erro", "erro.");
        }
    }
}