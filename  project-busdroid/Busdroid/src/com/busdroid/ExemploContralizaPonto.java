package com.busdroid;

import com.busdroid.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.os.Bundle; 

public class ExemploContralizaPonto extends ExemploSatelite{
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		MapView mapView = (MapView) findViewById(R.id.mapa);
		mapView.setStreetView(true);
		mapView.setClickable(true);
		MapController controlador = mapView.getController();
		GeoPoint p = new PontoSete();
		controlador.animateTo(p);
		controlador.setZoom(16);
	}

}
