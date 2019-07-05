package com.example.app_ubicatetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TipoMapas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_mapas);
    }

    //Metodo para el boton Hibrido
    public void MapaHibrido(View view){
        Intent i = new Intent(this, MapsActivityHibrido.class);
        startActivity(i);
    }

    //Metodo para el boton Satelite
    public void MapaSatelite(View view){
        Intent i = new Intent(this, MapsActivitySatelite.class);
        startActivity(i);
    }

    //Metodo para el boton Terreno
    public void MapaTerreno(View view){
        Intent i = new Intent(this, MapsActivityTerreno.class);
        startActivity(i);
    }
}
