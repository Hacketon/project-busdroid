package com.busdroid;


import android.os.Bundle;
import com.busdroid.R;

import com.google.android.maps.MapActivity;

/**
 * Exemplo que desenha a rota entre dois GeoPoint
 * 
 * @author ricardo
 *
 */
public class ExemploRotaSimples extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.mapviewxml);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}