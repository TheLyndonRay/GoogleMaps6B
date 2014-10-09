package com.solaris.lyndon.googlemaps6b;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private GoogleMap mapObject;
    private ArrayList<Marker> markers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapObject = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        markers = new ArrayList<Marker>();

        mapObject.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mapObject.setMyLocationEnabled(true);

        ArrayList<LatLng> latLngs = new ArrayList<LatLng>();
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<String> snippets = new ArrayList<String>();
        ArrayList<Integer> iconReference = new ArrayList<Integer>();

        latLngs.add(new LatLng(Double.parseDouble(getString(R.string.lat0)), Double.parseDouble(getString(R.string.lng0))));
        latLngs.add(new LatLng(Double.parseDouble(getString(R.string.lat1)), Double.parseDouble(getString(R.string.lng1))));
        latLngs.add(new LatLng(Double.parseDouble(getString(R.string.lat2)), Double.parseDouble(getString(R.string.lng2))));

        titles.add("Black Bottle");
        titles.add("Red Robin");
        titles.add("King's Head Pub");

        snippets.add("The steak was delicious but expensive");
        snippets.add("I ate a chicken burger here");
        snippets.add("Saltiest poutines, but I love it");

        iconReference.add(R.drawable.cutman);
        iconReference.add(R.drawable.elecman);
        iconReference.add(R.drawable.bombman);

        for (int i=0; i < latLngs.size(); i++){

            markers.add(mapObject.addMarker(new MarkerOptions()
                    .position(latLngs.get(i))
                    .title(titles.get(i))
                    .snippet(snippets.get(i))
                    .icon(BitmapDescriptorFactory.fromResource(iconReference.get(i)))));

        }

        mapObject.moveCamera(CameraUpdateFactory.newLatLngZoom(markers.get(0).getPosition(), 18));
        markers.get(0).showInfoWindow();

        /*Marker marker0 = mapObject.addMarker(new MarkerOptions()
                .position(new LatLng(47.615535, -122.349656))
                .title("Black Bottle")
                .snippet("I drank 4 beers here! - Unite2014")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cutman)));

        Marker marker1 = mapObject.addMarker(new MarkerOptions()
                .position(new LatLng(49.284472, -123.125278))
                .title("Red Robin")
                .snippet("I ate a chicken burger here")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.elecman)));

        Marker marker2 = mapObject.addMarker(new MarkerOptions()
                .position(new LatLng(49.898307, -97.141016))
                .title("King's Head")
                .snippet("Saltiest poutines")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bombman))); */

        //marker0.showInfoWindow();
        //marker1.showInfoWindow();
        //marker2.showInfoWindow();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        switch (id) {
            case R.id.action_hybrid :

                mapObject.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.action_normal :
                mapObject.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.action_satellite :
                mapObject.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.action_terrain :
                mapObject.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
