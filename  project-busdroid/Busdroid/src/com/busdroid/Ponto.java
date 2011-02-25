package com.busdroid;

import android.location.Location;

import com.google.android.maps.GeoPoint;

public class Ponto  extends GeoPoint{
	//Valores em graus * 1E6 (microdegrees)
	public Ponto(int latitudeE6, int longitudeE6) {
		super(latitudeE6, longitudeE6);
		// TODO Auto-generated constructor stub
	}
	//Converte para "graus * 1E6"
	public Ponto(double latitude, double longitude) {
		this((int)(latitude*1E6),(int)(longitude*1E6));
		// TODO Auto-generated constructor stub
	}
	//Cria baseado no objeto 'Location' diretamente recebido do GPS
	public Ponto(Location location){
		this(location.getLatitude(),location.getLongitude());
	}
}
