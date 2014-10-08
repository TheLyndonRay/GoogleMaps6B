package com.solaris.lyndon.googlemaps6b;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private GoogleMap mapObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapObject = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        mapObject.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        ArrayList<LatLng> latLngs = new ArrayList<LatLng>();

        latLngs.add(new LatLng(R.string.lat0, R.string.lng0));
        latLngs.add(new LatLng(R.string.lat1, R.string.lng1));
        latLngs.add(new LatLng(R.string.lat2, R.string.lng2));

        for (int i=0; i < latLngs.size(); i++){



        }

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
        return super.onOptionsItemSelected(item);
    }
}
