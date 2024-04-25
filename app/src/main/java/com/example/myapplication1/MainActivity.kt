package com.example.myapplication1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var mMap:GoogleMap
    lateinit var bitmap: Bitmap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_cases)
        //bitmap = BitmapFactory.decodeResource(getResources(), ContextCompat.getDrawable(R.drawable.ic_launcher_foreground));
        var point = LatLng(54.70411329729895, 20.569521063966448)
        mMap.addMarker(MarkerOptions().position(point).title("Home").snippet("Крутая достопримечательность"))//?.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap))
        mMap.isBuildingsEnabled = true
        //mMap.isIndoorEnabled = false
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID

        googleMap.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                this, R.raw.style_json));

        mMap.setMinZoomPreference(1f)

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(point, 20f))


    }
}