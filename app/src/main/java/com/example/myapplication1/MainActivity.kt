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
        var srt = LatLng(54.70615456969216, 20.504339695031547)
        mMap.addMarker(MarkerOptions().position(srt).title("СРТ-129").snippet("Крутая достопримечательность, просто вау"))//?.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap))
        mMap.isBuildingsEnabled = true
        //mMap.isIndoorEnabled = false
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID

        googleMap.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                this, R.raw.style_json));

        mMap.setMinZoomPreference(1f)

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(srt, 20f))


    }
}
