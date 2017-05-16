package br.com.wolneyhqf.aulas.appcbr.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.model.Clube;

public class MapaFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleApiClient googleApiClient;
    private GoogleMap googleMap;
    private Clube clube;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        setHasOptionsMenu(true);
        clube = getArguments().getParcelable("clube");

        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        supportMapFragment.getMapAsync(this);

        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    public void onStop(){
        stopLocationUpdates();
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (clube != null) {
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMyLocationEnabled(true);
            LatLng location = new LatLng(clube.getLatitude(), clube.getLongitude());
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(location, 16);
            googleMap.moveCamera(cameraUpdate);
            googleMap.addMarker(new MarkerOptions().title(clube.getEstadio())
                    .snippet(clube.getNome())
                    .position(location));
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }

    private void adicionarPolyline(LatLng latLng1, LatLng latLng2){
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(latLng1);
        polylineOptions.add(latLng2);
        polylineOptions.color(Color.BLUE);
        Polyline polyline = googleMap.addPolyline(polylineOptions);
        polyline.setGeodesic(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_mapa, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                getActivity().finish();
                break;
            case R.id.action_mapa_zoom_in:
                googleMap.animateCamera(CameraUpdateFactory.zoomIn());
                break;
            case R.id.action_mapa_zoom_out:
                googleMap.animateCamera(CameraUpdateFactory.zoomOut());
                break;
            case R.id.action_mapa_localizacao_usuario:
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {}
                Location locationUser = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                setMapLocation(locationUser);
                break;
            case R.id.action_mapa_localizacao_clube:
                LatLng locationClube = new LatLng(clube.getLatitude(), clube.getLongitude());
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locationClube, 16));
                break;
            case R.id.action_mapa_rota_clube:
                Location locationInicio = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                String origem = "" + locationInicio.getLatitude()+", "+locationInicio.getLongitude()+"";
                String destino = "" + clube.getLatitude()+", "+clube.getLongitude()+"";
                String url = "http://maps.google.com/maps?f=d&saddr="+origem+"&daddr="+destino+"&hl=pt";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;
            case R.id.action_mapa_normal:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.action_mapa_satelite:
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.action_mapa_terreno:
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.action_mapa_hibrido:
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void setMapLocation(Location location){
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 16);
        googleMap.animateCamera(cameraUpdate);
        // Desenha bolinha vermelha
        CircleOptions circleOptions = new CircleOptions().center(latLng);
        circleOptions.fillColor(Color.RED);
        circleOptions.radius(5);
        googleMap.clear();
        googleMap.addCircle(circleOptions);
    }

    public void startLocationUpdates(){
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {}
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    public void stopLocationUpdates(){
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i("appcbr", "Conectado ao Google Play Service");
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("appcbr", "Conexão ao Google Play Service interrompida");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("appcbr", "Erro ao Conectar ao Google Play Service: " + connectionResult);
    }

    @Override
    public void onLocationChanged(Location location) {
        //setMapLocation(location);
    }
}
