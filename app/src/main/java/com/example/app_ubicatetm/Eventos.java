package com.example.app_ubicatetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Eventos extends AppCompatActivity {

    private RadioButton crear, buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        crear = (RadioButton)findViewById(R.id.rb_crear);
        buscar = (RadioButton)findViewById(R.id.rb_buscar);
    }

    //Metodo para el boton Seleccionar
    public void Seleccionar(View view){

        if(crear.isChecked() == true){
            Intent i = new Intent(this,CrearEvento.class);
            startActivity(i);
        }
        else if (buscar.isChecked() == true){
            Intent i = new Intent(this,BuscarEvento.class);
            startActivity(i);
        }
    }

    //Metodo para el boton cerrar
    public void Cerrar(View view){
        Intent i = new Intent(this, MenuPrincipal.class);
        startActivity(i);
    }
}
