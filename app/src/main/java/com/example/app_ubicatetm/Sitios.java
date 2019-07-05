package com.example.app_ubicatetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sitios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
    }

    //Metodo para el boton Turisticos
    public void Turistico(View view) {
        Intent i = new Intent(this, TopTurismo.class);
        startActivity(i);
    }

    //Metodo para el boton Parque
    public void Parques(View view) {
        Intent i = new Intent(this, MapsActivityParques.class);
        startActivity(i);
    }

    //Metodo para el boton Turisticos
    public void Deportivos(View view) {
        Intent i = new Intent(this, MapsActivityDeportivos.class);
        startActivity(i);
    }

    //Metodo para el boton Party
    public void Party(View view){
        Intent i = new Intent(this, TopParty.class);
        startActivity(i);
    }

    //Metodo para el boton Cerrar
    public void Cerrar(View view){
        Intent i = new Intent(this, MenuPrincipal.class);
        startActivity(i);
    }
}
