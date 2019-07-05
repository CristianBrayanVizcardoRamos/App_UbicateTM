package com.example.app_ubicatetm;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class RegistrarUsuario extends AppCompatActivity {

    Button grabar;
    EditText nombre, pais, correo, password;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        nombre = (EditText)findViewById(R.id.txt_nombre);
        pais = (EditText)findViewById(R.id.txt_pais);
        correo = (EditText)findViewById(R.id.txt_correo);
        password = (EditText)findViewById(R.id.txt_password);
        grabar = (Button) findViewById(R.id.btn_registrar);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Nombre = nombre.getText().toString();
                String Pais = pais.getText().toString();
                String Correo = correo.getText().toString();
                String Password = password.getText().toString();

                if (Nombre.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Debes ingresar un nombre", Toast.LENGTH_SHORT).show();
                }
                if (Pais.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Debes ingresar una pais", Toast.LENGTH_SHORT).show();
                }
                if (Correo.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Debes ingresar un correo", Toast.LENGTH_SHORT).show();
                }
                if (Password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Debes ingresar un password", Toast.LENGTH_SHORT).show();
                }

                if (Nombre.length() != 0 && Pais.length() != 0 && Correo.length() != 0 && Password.length() != 0) {

                    helper.abrir();
                    helper.InsertarRegistro(
                            String.valueOf(nombre.getText()),
                            String.valueOf(pais.getText()),
                            String.valueOf(correo.getText()),
                            String.valueOf(password.getText()));
                    helper.cerrar();

                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "No Registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Metodo para cerrar la ventana
    public void CerrarVentana(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
