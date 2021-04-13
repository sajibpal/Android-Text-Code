package com.example.sajibpal.googlemap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MapActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener {

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Toast.makeText(this, "On map ready", Toast.LENGTH_SHORT).show();
        Log.d(tag, "onMapReady :on map Ready");
        gmap = googleMap;
        if (mlocationpermisssion) {

            getdeviceLocation();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            gmap.setMyLocationEnabled(true);
            gmap.getUiSettings().setMyLocationButtonEnabled(false);
            init();
        }
    }
    private static final String tag = "MainActivity";
    private static final String fine_location = android.Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String coarse_location = Manifest.permission.ACCESS_COARSE_LOCATION;
    private boolean mlocationpermisssion=false;
    private  static  final int location_request_code=1234;
    private FusedLocationProviderClient fusedLocation;
    private  static  final float Zoom_default=15f;
    private  GoogleMap gmap;
    private ImageView mgps;
    AutoCompleteTextView search;
    GoogleApiClient mgoogleApiClient;
    private PlaceAutocompleteAdapter mplaceAutocompleteAdapter;
    private static final LatLngBounds LAT_LNG_BOUNDS=new LatLngBounds(
         new LatLng(-40,-168),new LatLng(71,136));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        search= (AutoCompleteTextView) findViewById(R.id.editsearch);
        mgps= (ImageView) findViewById(R.id.map);
        getlocationpremission();
    }

    private  void init(){

        Log.d(tag,"init : initlization");

        mgoogleApiClient=new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this,this)
                .build();


        mplaceAutocompleteAdapter=new PlaceAutocompleteAdapter(this,mgoogleApiClient,LAT_LNG_BOUNDS,null);
        search.setAdapter(mplaceAutocompleteAdapter);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId ==EditorInfo.IME_ACTION_DONE
                        || event.getAction()==KeyEvent.ACTION_DOWN
                        || event.getAction()==KeyEvent.KEYCODE_ENTER){

                    geolocate();
                }
                return false;
            }
        });

        mgps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.d(tag,"onClick:click gps icon");
                getdeviceLocation();
            }
        });

        hidesoftkey();
    }

   private  void    geolocate(){

       Log.d(tag,"geolocate : gelocate");
       String searchstring=search.getText().toString();
       Geocoder geocoder=new Geocoder(MapActivity.this);
       List<Address> list=new ArrayList<>();

         try{
             list =geocoder.getFromLocationName(searchstring,1);

         }catch (IOException e){

             Log.e(tag,"geolocate :" +e.getMessage());
         }
       if(list.size()>0){

         Address address=list.get(0);
           Log.d(tag,"geolocate :found location"+address.toString());

           moveCamera(new LatLng(address.getLatitude(),address.getLongitude()),Zoom_default,address.getAddressLine(0));

       }
   }
    private void getdeviceLocation(){

        Log.d(tag,"getdeviceLocation :get the crruent device location");
        fusedLocation= LocationServices.getFusedLocationProviderClient(this);

        try{

            if(mlocationpermisssion){


                Task location=fusedLocation.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {

                        if(task.isSuccessful()){
                            Log.d(tag,"onComplete :found location");
                            Location currentlovation= (Location) task.getResult();
                            moveCamera(new LatLng(currentlovation.getLatitude(),currentlovation.getLongitude()),Zoom_default,"My location");
                        }
                        else{
                            Log.d(tag," onComplete :Current location is null");
                            Toast.makeText(MapActivity.this, "Unable the Current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }catch (SecurityException e){

           Log.d(tag,"getdeviceLocation : SecurityException"+e.getMessage()) ;
        }
    }

    private  void moveCamera(LatLng latling,float zoom,String title) {

        Log.d(tag, "moveCamera : moving the camera to lat :" + latling.latitude + ",lng :" + latling.longitude);
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(latling,zoom));

        if(title.equals("My location")){

            MarkerOptions options=new MarkerOptions()
                    .position(latling)
                    .title(title);

            gmap.addMarker(options);
        }
        hidesoftkey();
    }
    private  void intmap(){

        Log.d(tag,"intmap: initialization map");
        SupportMapFragment fragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapframe);
        fragment.getMapAsync(MapActivity.this);
    }

    private void getlocationpremission() {

        Log.d(tag,"getlocationpremission : get location permission");
        String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                fine_location) == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    coarse_location) == PackageManager.PERMISSION_GRANTED) {

                  mlocationpermisssion=true;
                  intmap();
            }else{

                ActivityCompat.requestPermissions(this,permission,location_request_code);
            }
        }
        else{

            ActivityCompat.requestPermissions(this,permission,location_request_code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        Log.d(tag,"onRequestPermissionsResult :called");
        mlocationpermisssion=false;

        switch(requestCode){

            case location_request_code :{

                if(grantResults.length>0){

                    for(int i=0;i<grantResults.length;i++){

                       if(grantResults[i]!=PackageManager.PERMISSION_GRANTED) {
                           mlocationpermisssion = false;
                           Log.d(tag,"onRequestPermissionsResult :permission fialled");
                           return;
                       }
                    }
                    Log.d(tag,"onRequestPermissionsResult :permission granted");
                    mlocationpermisssion=true;
                    intmap();
                }
            }
        }
    }

private  void hidesoftkey(){

    this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
 }


}