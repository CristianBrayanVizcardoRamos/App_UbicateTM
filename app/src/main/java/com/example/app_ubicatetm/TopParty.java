package com.example.app_ubicatetm;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TopParty extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int sonido_de_reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_party);

        play = (Button)findViewById(R.id.btnIngresar);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonido_de_reproduccion = sp.load(this, R.raw.sound_short, 1);
    }

    public void Forum(View view){
        Toast.makeText(this, "Discoteca Forum", Toast.LENGTH_SHORT).show();
    }

    public void Ssiomama(View view){
        Toast.makeText(this, "Discoteca Ssiomama", Toast.LENGTH_SHORT).show();
    }

    public void Rustica(View view){
        Toast.makeText(this, "Discoteca Rustica", Toast.LENGTH_SHORT).show();
    }

    public void AudioSoundPool(View view){
        sp.play(sonido_de_reproduccion, 1, 1, 1, 0, 0);
        Intent i = new Intent(this, MapsActivityParty.class);
        startActivity(i);
    }
}
