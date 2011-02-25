package com.busdroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * Simples Overlay que recebe as coordenadas Latitude e Longitude
 * 
 * Desenha a imagem fornecida na coordenada
 * 
 * @author Lucas
 * 
 */
public class ImagemOverlay extends Overlay {

	protected Paint paint = new Paint();
	protected GeoPoint geoPoint;
	protected final int imagemId;

	public ImagemOverlay(GeoPoint geoPoint, int imagemId) {
		this.geoPoint = geoPoint;
		this.imagemId = imagemId;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);

		// Converte as coordenadas para pixels
		Point ponto = mapView.getProjection().toPixels(geoPoint, null);

		Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), this.imagemId);

		RectF r = new RectF(ponto.x, ponto.y, ponto.x + bitmap.getWidth(), ponto.y + bitmap.getHeight());

		r.centerY();
		r.centerX();
		//canvas.drawBitmap(bitmap, null,r, paint);
		canvas.drawBitmap(bitmap, ponto.x,ponto.y-bitmap.getHeight(),null);
	
	}
	public void setGeoPoint(GeoPoint geoPoint){
		this.geoPoint = geoPoint;
	}
}
