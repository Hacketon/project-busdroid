package com.busdroid;

import com.busdroid.R;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.os.Bundle;
import android.view.KeyEvent;

public class ExemploSatelite extends MapaSimplesXML {
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		MapView mapView = (MapView) findViewById(R.id.mapa);
		MapController controlador = mapView.getController();
		controlador.setZoom(4);
	}
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event){
		MapView mapView = (MapView) findViewById(R.id.mapa);
		
		if(keyCode == KeyEvent.KEYCODE_S){
			//Satélite
			mapView.setSatellite(true);
			mapView.setStreetView(false);
			mapView.setTraffic(false);
			return true;
		}else if(keyCode == KeyEvent.KEYCODE_R){
			//Rua
			mapView.setStreetView(true);
			mapView.setSatellite(false);		
			mapView.setTraffic(false);
			return true;
		}else if(keyCode == KeyEvent.KEYCODE_T){
			//Trânsito
			mapView.setTraffic(true);
			mapView.setStreetView(false);
			mapView.setSatellite(false);		
			return true;
		}
		return super.onKeyDown(keyCode, event);		
		
	}

}
