package com.example.dinoapp.ui.dashboard;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import
        android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dinoapp.MainActivity;
import com.example.dinoapp.R;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DashboardFragment extends Fragment implements LocationListener {

    Location location;
    Button getLocation;
    String currentLocation = "";
    TextView textView1, textView2, textView3;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private static final String TAG = "MyLocation";



    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        Button getLocation = view.findViewById(R.id.getLocation);
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("https://google.com/maps?q=" + currentLocation + "&output-embed");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
                startActivity(webIntent);
            }
        });

        textView1 = view.findViewById(R.id.textView1);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);


        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {

            textView3.setText(getAddress(location));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    if (locationManager == null) {
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    }
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
    } else {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500000, 0, locationListener);

        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }
        return view;
    }
    private String getAddress(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(), 1);

                Address address = addresses.get(0);
                currentLocation = address.getAddressLine(0);

        } catch (IOException e) {
            Log.e(TAG, "Error" + e);
        }
        Log.i(TAG, currentLocation);
        return currentLocation;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}




     //   LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

//        public new LocationManager(new OnCompleteListener<Location>() {
//            @Override
//            public void onComplete(@NonNull Task<Location> task) {
//                Location location = task.getResult();
//
//                if (location != null) {
//                    try {
//
//                        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
//
//                        List<Address> addresses = geocoder.getFromLocation(
//                                location.getLatitude(), location.getLatitude(), 1
//                        );
//                        textView1.setText((int) addresses.get(0).getLatitude());
//                        textView2.setText((int) addresses.get(0).getLongitude());
//                        textView3.setText(addresses.get(0).getAddressLine(0));
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
