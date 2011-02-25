package com.busdroid;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ZoomControls;

public class MapaSimples extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        MapView mapView = new MapView(this,"0gEcnAsf2ugPX-AnW8z4hbBA9-RkmStBvf_GwpA");
        setContentView(mapView);
        
 
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}