package com.example.app_ubicatetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    //Metodo para el boton sitios
    public void sitios(View view){
        Intent i = new Intent(this, Sitios.class);
        startActivity(i);
    }

    //Metodo para el boton tipos de mapas
    public void TiposDeMapas(View view){
        Intent i = new Intent(this, TipoMapas.class);
        startActivity(i);
    }

    //Metodo para el boton cerrar venntana
    public void CerrarVentana(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Eventos(View view){
        Intent i = new Intent(this, Eventos.class);
        startActivity(i);
    }
}
