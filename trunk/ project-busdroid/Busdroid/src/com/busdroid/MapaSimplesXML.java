package com.busdroid;

import android.os.Bundle;

import com.busdroid.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapaSimplesXML extends MapActivity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapviewxml);
		MapView mapView = (MapView) findViewById(R.id.mapa);
		//Graus
		double latitude = -25.442580;
		double longitude = -49.279840;
		//Converte para microdegrees (graus * 1E6)
		int latitudeE6 = (int)(latitude*1E6);
		int longitudeE6 = (int)(longitude*1E6);
		//Centraliza o mapa no ponto
		GeoPoint point = new GeoPoint(latitudeE6,longitudeE6);
		mapView.getController().setCenter(point);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
