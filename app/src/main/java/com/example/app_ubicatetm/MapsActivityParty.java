package com.example.app_ubicatetm;

import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityParty extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_party);
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

        LatLng rustica = new LatLng(-16.4170574, -71.5268919);
        mMap.addMarker(new MarkerOptions().position(rustica).title("Discoteca Rustica").snippet("Eventos No Disponibles"));

        LatLng forum = new LatLng(-16.395670171292537, -71.53515478548447);
        mMap.addMarker(new MarkerOptions().position(forum).title("Discoteca Forum").snippet("Eventos No Disponibles"));

        LatLng ssiomama = new LatLng(-16.41888627817731, -71.52619879579483);
        mMap.addMarker(new MarkerOptions().position(ssiomama).title("Discoteca Ssiomama").snippet("Eventos No Disponibles"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rustica, 12));
    }
}
