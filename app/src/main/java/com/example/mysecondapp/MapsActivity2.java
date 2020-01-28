
package com.example.mysecondapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity2 extends AppCompatActivity implements OnMapReadyCallback {
    private DrawerLayout drawer;
    private GoogleMap mMap;

    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private static final int INITIAL_REQUEST=1337;
    private static final int LOCATION_REQUEST=INITIAL_REQUEST+3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Sapucaia = new LatLng(-29.832761, -51.165529);
        LatLng unisinos = new LatLng(-29.794583, -51.155508);

        mMap.addMarker(new MarkerOptions().position(Sapucaia).title("Marker in Sapucaia"));


        mMap.addMarker(new MarkerOptions().position(unisinos).title("Marker in unisinos"));



        mMap.moveCamera(CameraUpdateFactory.newLatLng(unisinos));

        mMap.animateCamera((CameraUpdateFactory.newLatLngZoom(Sapucaia, 12.f)));


        mMap.getUiSettings().setZoomControlsEnabled(true);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);
        } else {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
            }
        }



        mMap.addPolyline(new PolylineOptions()
        .add(Sapucaia, unisinos)
        .width(10)
        .color(Color.GREEN));

        mMap.addCircle(
                new CircleOptions()
                        .center(unisinos)
                        .radius(2980.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))

        );

    }
}
