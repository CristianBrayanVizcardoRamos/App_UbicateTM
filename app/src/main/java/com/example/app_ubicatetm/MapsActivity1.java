package com.example.app_ubicatetm;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Arequipa and move the camera http://www.coordenadas-gps.com/ https://iconos8.es - Latitud - Longitud

        //Cercado
        LatLng PlazaDeArmas = new LatLng(-16.3988667, -71.5369607);
        mMap.addMarker(new MarkerOptions().position(PlazaDeArmas).title("Plaza de Armas de Arequipa").snippet("Eventos No Disponibles"));

        LatLng MonasterioSantaC = new LatLng(-16.395149, -71.53656);
        mMap.addMarker(new MarkerOptions().position(MonasterioSantaC).title("Monasterio de Santa Catalina").snippet("Eventos No Disponibles"));

        //Yanahuara
        LatLng MiradorYanahuara = new LatLng(-16.387475, -71.541749);
        mMap.addMarker(new MarkerOptions().position(MiradorYanahuara).title("Mirador de Yanahuara").snippet("Eventos No Disponibles"));

        //Sabandia
        LatLng MolinoSandia = new LatLng(-16.456739, -71.499855);
        mMap.addMarker(new MarkerOptions().position(MolinoSandia).title("Molino de Sabandia").snippet("Eventos No Disponibles"));

        //Camara
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PlazaDeArmas,12));
    }
}

