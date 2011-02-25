package com.busdroid;

import org.apache.http.conn.routing.RouteTracker;

import android.graphics.Color;
import android.graphics.Path.Direction;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout.Directions;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ZoomControls;

import com.busdroid.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


public class ExemploAndandoRuaFake extends MapActivity implements Runnable{
	private static  final int TEMPO = 2000;
	private static final String CATEGORIA = "livro";
	private MapController controlador;
	//Prxóximo índice da matriz coordenadas
	private int indice = 0;
	private MapView mapa;
	Handler handler = new Handler();
	private ImagemOverlay icone;
	
	//Matriz de coordenadas Latitude e Longitude de um ônibus para exibição
	
	private double[][] coordenadas = new double[][]{
			{-25.443195,-49.280977},{-25.443156,-49.280859},
			{-25.443099,-49.280698},{-25.443050,-49.280548},
			{-25.442953,-49.280344},{-25.442904,-49.280129},
			{-25.442827,-49.279979},{-25.442770,-49.279830},
			{-25.442692,-49.279626},{-25.442595,-49.279444},
			{-25.442546,-49.279272},{-25.442498,-49.279132},
			{-25.442440,-49.278971},{-25.442352,-49.278768},
			{-25.442285,-49.278574},{-25.442207,-49.278403},
			{-25.442130,-49.278220}	
	};
	
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.mapviewxml);
		mapa = (MapView) findViewById(R.id.mapa);
		controlador = mapa.getController();
		controlador.setZoom(19);
	
		GeoPoint geoPoint = getProximoPonto();
		controlador.setCenter(geoPoint);
		//bola = new BolaOverlay(geoPoint,Color.BLUE);
		//mapa.getOverlays().add(bola);
		icone = new ImagemOverlay(geoPoint,R.drawable.icon_green_a);
		mapa.getOverlays().add(icone);
		
		
		//Envia a mensagem depois de 2 segundos para atualizar a coodernada da bolinha
		handler.postDelayed(this,TEMPO);
		ZoomControls zoom = (ZoomControls) mapa.getZoomControls();
	    zoom.setLayoutParams(new ViewGroup.LayoutParams(
	    		LayoutParams.FILL_PARENT,
	    		LayoutParams.FILL_PARENT));
	    zoom.setGravity(Gravity.BOTTOM + Gravity.CENTER_HORIZONTAL);
	    mapa.addView(zoom);
	    mapa.displayZoomControls(true);
	}
	//Implementa o metoto run da interface Runnable
	public void run() {
		// Recupera o proximo ponto para mover a bolinha
		GeoPoint p = getProximoPonto();
		Log.i(CATEGORIA,"Mapa > " + p.getLatitudeE6() + " , " + p.getLongitudeE6());
		Log.i(CATEGORIA,"GeoPoint > " + p);
		
		//Atualiza a coordenada do icone
		icone.setGeoPoint(p);
		//Centraliza o Map no ponto
		controlador.animateTo(p);
		//invalida o mapa para desenhar tudo novamente
		mapa.invalidate();
		//Envia a mensagem após 2 segundos para atualizar a coordenada da bolinha
		handler.postDelayed(this,TEMPO);
	}
	
	//Retorna o próximo ponto para mover o mapa
	private GeoPoint getProximoPonto() {
		Log.i(CATEGORIA, "getPoint: " + indice);
		double latitude = (coordenadas[indice][0]);
		double longitude = (coordenadas[indice][1]);
		GeoPoint p = new Ponto(latitude,longitude);
		indice++;
		if(indice == coordenadas.length){
			indice=0;
		}
		return p;
	}
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
