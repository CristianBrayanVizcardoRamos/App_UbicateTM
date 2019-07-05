package com.example.app_ubicatetm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class CrearEvento extends AppCompatActivity {

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD2", null, 1);

    private EditText nombreEvento, informacion, lugar, fecha, hora;
    private Button modifiar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);

        nombreEvento = (EditText)findViewById(R.id.txt_nombreEvento);
        informacion = (EditText)findViewById(R.id.txt_informacion);
        lugar = (EditText)findViewById(R.id.txt_lugar);
        fecha = (EditText)findViewById(R.id.txt_fecha);
        hora = (EditText)findViewById(R.id.txt_hora);

        modifiar = (Button)findViewById(R.id.btn_modificar);
        eliminar = (Button)findViewById(R.id.btn_eliminar);

        modifiar.setVisibility(View.INVISIBLE);
        eliminar.setVisibility(View.INVISIBLE);
    }

    public void Guardar(View view){
        String NombreEvento = nombreEvento.getText().toString();
        String Informacion = informacion.getText().toString();
        String Lugar = lugar.getText().toString();
        String Fecha = fecha.getText().toString();
        String Hora = hora.getText().toString();

        if (NombreEvento.length() == 0) {
            Toast.makeText(getApplicationContext(), "Debes ingresar un nombre de evento", Toast.LENGTH_SHORT).show();
        }
        if (Informacion.length() == 0) {
            Toast.makeText(getApplicationContext(), "Debes ingresar una informacion del evento", Toast.LENGTH_SHORT).show();
        }
        if (Lugar.length() == 0) {
            Toast.makeText(getApplicationContext(), "Debes ingresar lugar del evento", Toast.LENGTH_SHORT).show();
        }
        if (Fecha.length() == 0) {
            Toast.makeText(getApplicationContext(), "Debes ingresar una fecha del evento", Toast.LENGTH_SHORT).show();
        }
        if (Hora.length() == 0) {
            Toast.makeText(getApplicationContext(), "Debes ingresar la hora del evento", Toast.LENGTH_SHORT).show();
        }

        if (NombreEvento.length() != 0 && Informacion.length() != 0 && Lugar.length() != 0 && Fecha.length() != 0 && Hora.length() != 0){

            helper.abrir();
            helper.InsertarEventos(
                    String.valueOf(nombreEvento.getText()),
                    String.valueOf(informacion.getText()),
                    String.valueOf(lugar.getText()),
                    String.valueOf(fecha.getText()),
                    String.valueOf(hora.getText()));
            helper.cerrar();

            Toast.makeText(getApplicationContext(), "Evento registrado exitosamente", Toast.LENGTH_LONG).show();

            modifiar.setVisibility(View.VISIBLE);
            eliminar.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(getApplicationContext(), "Evento no Registrado", Toast.LENGTH_LONG).show();
        }
    }

    public void Cerrar(View view){
        Intent i = new Intent(this, Eventos.class);
        startActivity(i);
    }

    public void Limipiar(View view){
        nombreEvento.setText("");
        informacion.setText("");
        lugar.setText("");
        fecha.setText("");
        hora.setText("");
    }
}
