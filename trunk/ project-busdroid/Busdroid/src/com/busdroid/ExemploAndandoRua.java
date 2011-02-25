package com.busdroid;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.busdroid.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class ExemploAndandoRua extends MapActivity implements LocationListener {

	private static final String CATEGORIA = "livro";
	private MapController controlador;
	private MapView mapa;
	private BolaOverlay bola;
	
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.mapviewxml);
		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setClickable(true);
		mapa.setStreetView(true);
		controlador = mapa.getController();
		controlador.setZoom(16);
		bola = new BolaOverlay(null,Color.BLUE);
		//mapa.getOverlays().add(bola);
		
		//Centraliza o mapa na ultima localização conhecida
		Location loc = getLocationManager().getLastKnownLocation(LocationManager.GPS_PROVIDER);
	 
		//Se existe ultima localição converte para geopoint
		if(loc != null){
			Ponto ponto = new Ponto(loc);
			Log.i(CATEGORIA, "Ultima localização: " + ponto);
			bola.setGeoPoint(ponto);
			controlador.setCenter(ponto);
		}
		//GPS listener
		getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
	}
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Log.i(CATEGORIA,"latitude :" + location.getLatitude() + " , longitude: "+ location.getLongitude());
		GeoPoint geopoint = new Ponto(location);
		//Atualiza a coordenada da bolinha
		bola.setGeoPoint(geopoint);
		//Anima a o mapa até a nova localização
		controlador.animateTo(geopoint);
		//Invalida para desenhar o mapa novamente
		mapa.invalidate();
		
	}
	
	private LocationManager getLocationManager() {
        return (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }
		
	@Override
	protected void onDestroy(){
		super.onDestroy();
		//Remove o listener para não ficar rodando depois de sair
		getLocationManager().removeUpdates(this);
	}
	
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
