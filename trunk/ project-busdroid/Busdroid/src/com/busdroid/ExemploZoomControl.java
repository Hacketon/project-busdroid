package com.busdroid;

import com.busdroid.R;
import com.google.android.maps.MapView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ZoomControls;

public class ExemploZoomControl extends ExemploSatelite {
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		
		MapView mapView = (MapView) findViewById(R.id.mapa);
		/** --- zoom -- **/
		ZoomControls zoom = (ZoomControls) mapView.getZoomControls();
	    zoom.setLayoutParams(new ViewGroup.LayoutParams(
	    		LayoutParams.FILL_PARENT,
	    		LayoutParams.FILL_PARENT));
	    zoom.setGravity(Gravity.BOTTOM + Gravity.CENTER_HORIZONTAL);
	    mapView.addView(zoom);
	    mapView.displayZoomControls(true);
	    

	}

	
	
}
