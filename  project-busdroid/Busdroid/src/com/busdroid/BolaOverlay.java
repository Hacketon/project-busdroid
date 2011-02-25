package com.busdroid;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class BolaOverlay extends Overlay {
	//Constante android.graphics.Color.?
	private int cor;
	private Paint paint = new Paint();
	private GeoPoint geoPoint;
	public BolaOverlay (GeoPoint geoPoint, int cor){
		this.geoPoint = geoPoint;
		this.cor = cor;
	}
	@Override
	public void draw(Canvas canvas,MapView mapView,boolean shadow){
		super.draw(canvas, mapView, shadow);
		if(geoPoint != null){
			paint.setColor(cor);
			//Converte as coordenadas para pixel
			Point ponto = mapView.getProjection().toPixels(geoPoint, null);
			canvas.drawCircle(ponto.x, ponto.y, 5, paint);
		}
	}
	public void setGeoPoint(GeoPoint geoPoint){
		this.geoPoint = geoPoint;
	}
	
	
}
