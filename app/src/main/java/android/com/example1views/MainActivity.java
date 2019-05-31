package android.com.example1views;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    String TAG = "MainActivity LifeCycle";

    static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private GoogleMap map;

    Button bt_normal;
    Button bt_hybrid;
    Button bt_satellite;
    Button bt_terrian;
    Button bt_hyd;
    Button bt_zoom_options;
    Button bt_circle;
    Button bt_clear;
    Button bt_polylines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Log.v(TAG, TAG + " : onCreate");

        bt_normal = findViewById(R.id.bt_normal);
        bt_hybrid = findViewById(R.id.bt_hybrid);
        bt_satellite = findViewById(R.id.bt_satellite);
        bt_terrian = findViewById(R.id.bt_terrian);
        bt_zoom_options = findViewById(R.id.bt_zoom_options);
        bt_hyd = findViewById(R.id.bt_hyd);
        bt_circle = findViewById(R.id.bt_circle);
        bt_clear = findViewById(R.id.bt_clear);
        bt_polylines = findViewById(R.id.bt_polylines);
        bt_normal.setOnClickListener(this);
        bt_hybrid.setOnClickListener(this);
        bt_satellite.setOnClickListener(this);
        bt_terrian.setOnClickListener(this);
        bt_zoom_options.setOnClickListener(this);
        bt_hyd.setOnClickListener(this);
        bt_circle.setOnClickListener(this);
        bt_clear.setOnClickListener(this);
        bt_polylines.setOnClickListener(this);

        mapFragment.getMapAsync(this);

    }

    private void addMarker() {
        if (map != null) {
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.center(HAMBURG);
            circleOptions.radius(10);
            map.addCircle(circleOptions);
            Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
                    .title("Hamburg"));
            Marker kiel = map.addMarker(new MarkerOptions()
                    .position(KIEL)
                    .title("Kiel")
                    .snippet("Kiel is cool")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.mipmap.ic_launcher)));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, TAG + " : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, TAG + " : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, TAG + " : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, TAG + ": onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, TAG + " : onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, TAG + " : onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.v(TAG, TAG + " : onBackPressed");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(MainActivity.this, latLng.latitude + " : " + latLng.longitude, Toast.LENGTH_LONG).show();
                map.addMarker(new MarkerOptions().position(latLng).title("Tab Location").snippet("Helloooooooooooooo"));
            }
        });

        addMarker();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_normal:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.bt_hybrid:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.bt_satellite:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.bt_terrian:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.bt_zoom_options:
                map.getUiSettings().setZoomGesturesEnabled(true);
                break;
            case R.id.bt_hyd:
                navigateToHyd();
                break;
            case R.id.bt_circle:
                addCircle();
                break;
            case R.id.bt_clear:
                map.clear();
                break;
            case R.id.bt_polylines:
                addPolyLines();
                break;


        }
    }

    private void addCircle() {
        LatLng hyd = new LatLng(17.3850, 78.4867);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(hyd);
        circleOptions.radius(10);
        map.addCircle(circleOptions);
    }

    private void navigateToHyd() {
        LatLng hyd = new LatLng(17.3850, 78.4867);
        map.addMarker(new
                MarkerOptions().position(hyd).title("Hyderabad"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(hyd, 15));
    }

    private void addPolyLines() {
        LatLng hyd = new LatLng(17.3850, 78.4867);
        LatLng sec = new LatLng(17.4399, 78.4983);
        LatLng hitech_city = new LatLng(17.4435, 78.3772);

        map.addPolyline((new PolylineOptions())
                .add(hyd, sec, hitech_city).width(5).color(Color.BLUE)
                .geodesic(true));
        // move camera to zoom on map
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sec,
                13));

    }

    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }
}
