package com.example.app_ubicatetm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {

    private EditText et_email, et_password;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = (EditText)findViewById(R.id.txt_correo);
        et_password = (EditText)findViewById(R.id.txt_password);
    }

    //Metodo para el boton Ingresar
    public void Ingresar(View view){

        String usuario = et_email.getText().toString();
        String password = et_password.getText().toString();

        if(usuario.length() == 0){
            Toast.makeText(this, "Debes ingresar un email", Toast.LENGTH_LONG).show();
        }
        if(password.length() == 0){
            Toast.makeText(this, "Debes ingresar una password", Toast.LENGTH_LONG).show();
        }
        if(usuario.length() != 0 && password.length() != 0){

            Cursor cursor = helper.ConsultarUsuarios(et_email.getText().toString(), et_password.getText().toString());
            if (cursor.getCount()>0){
                Intent i = new Intent(this, MenuPrincipal.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "email o password incorrecto", Toast.LENGTH_LONG).show();
            }

            et_email.setText("");
            et_password.setText("");

            /*
            if(usuario.equals("admin@gmail.com") && password.equals("admin")){
                et_email.setText("");
                et_password.setText("");

                Intent i = new Intent(this, MenuPrincipal.class);
                startActivity(i);
            }
            else{
                et_email.setText("");
                et_password.setText("");

                Toast.makeText(this, "email o password incorrecto", Toast.LENGTH_LONG).show();
            }
            */
        }
    }

    //Metodo para el boton Registrar
    public void Registrar(View view){
        Intent i = new Intent(this, RegistrarUsuario.class);
        startActivity(i);
    }

    //Metodo del boton Llamada
    public void Llamar(View view){
        Intent i = new Intent(Intent.ACTION_CALL);

        i.setData(Uri.parse("tel:999371348"));

        if(ActivityCompat.checkSelfPermission(this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(i);
    }

    //Metodo del boton Contactarnos
    public void Contactarnos(View view){
        Intent i = new Intent(this, Contacto.class);
        startActivity(i);
    }
}