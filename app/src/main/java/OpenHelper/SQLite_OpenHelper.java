package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table usuarios(_ID integer primary key autoincrement, Nombre text, Pais text, Correo text, Password text);";
        db.execSQL(query);

        String query1 = "create table eventos(_ID integer primary key autoincrement, NombreEvento text, Informacion text, Lugar text, Fecha text, Hora text);";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Metodo que permite abrir la BD
    public void abrir(){
        this.getWritableDatabase();
    }

    //Metodo que permita cerrar la BD
    public void cerrar(){
        this.close();
    }

    //Metodo que permite insertar Registros en la tabla Usuarios
    public void InsertarRegistro(String nom, String pai, String cor, String pas){
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nom);
        valores.put("Pais", pai);
        valores.put("Correo", cor);
        valores.put("Password", pas);

        this.getWritableDatabase().insert("usuarios", null, valores);
    }

    //Metodo que permite validar si el usuario existe
    public Cursor ConsultarUsuarios(String usu, String pas) throws SQLException{
        Cursor mcursor=null;
        mcursor = this.getReadableDatabase().query("usuarios", new String[]{
                "_ID", "Nombre", "Pais", "Correo", "Password"},
                "Correo like '"+usu+"' and Password like '"+pas+"'", null, null, null, null);
        return mcursor;
    }

    //Metodo que permite insertar Registro en la tabla Eventos
    public void InsertarEventos(String nom, String inf, String lug, String fec, String hor){
        ContentValues valores = new ContentValues();
        valores.put("NombreEvento", nom);
        valores.put("Informacion", inf);
        valores.put("Lugar", lug);
        valores.put("Fecha", fec);
        valores.put("Hora", hor);

        this.getWritableDatabase().insert("eventos", null, valores);
    }
}
