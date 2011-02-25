package com.busdroid;

import android.os.Bundle;
import com.busdroid.R;

import com.google.android.maps.MapActivity;

/**
 * Exemplo que busca no Gooogle uma determinada rota e desenha no mapa
 * 
 * @author Lucas
 *
 */
public class ExemploRotaBuscaGoogle extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.mapviewxml);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}
}