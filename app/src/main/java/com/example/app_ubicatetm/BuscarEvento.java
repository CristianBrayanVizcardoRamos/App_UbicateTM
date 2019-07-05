package com.example.app_ubicatetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import OpenHelper.SQLite_OpenHelper;

public class BuscarEvento extends AppCompatActivity {

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD2", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_evento);
    }

    //Metodo para el boton Cerrar
    public void Cerrar(View view){
        Intent i = new Intent(this, Eventos.class);
        startActivity(i);
    }
}
