package sgg.controlflotas.vista;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import sgg.controlflotas.AppMediador;
import sgg.controlflotas.presentador.IPresentadorMapaActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MapaVistaActivity extends FragmentActivity implements IMapa, OnMarkerClickListener{
	
	private IPresentadorMapaActivity presentador;	
	private GoogleMap mapa;
	private SupportMapFragment mMapFragment;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa_vista);		
		presentador = AppMediador.getInstance().getPresentadorMapaActivity();
		AppMediador.getInstance().setVistaMapa(this);		
		mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);		
		mapa = mMapFragment.getMap();
		
		//Obtiene vehículos del modelo para presentarlo como marcadores en el mapa
		presentador.obtenerVehiculos(presentador.numeroVehiculos());
		
		//Centra el mapa en Las Palmas de GC
		LatLng coordenadas = new LatLng(28.1167551,-15.4399604);
	    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(coordenadas, 8);	   
	  	mapa.moveCamera(cameraUpdate);
	  	
	  	//Listener a las marcas del mapa			
		mapa.setOnMarkerClickListener(this);
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapa_vista, menu);
		return true;
	} 
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		getMenuInflater().inflate(R.menu.mapa_vista, menu);
		return super.onPrepareOptionsMenu(menu);
	} 
	
	@Override
	protected void onStart() {
		super.onStart();
		presentador.tratarPreferenciasMapa();
	}
	
	@Override
	public void cambiarAjustesMapa(String tipoMapa, boolean botonesZoom) {
		
		if (tipoMapa.compareTo("normal") == 0)
			mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		else
			if (tipoMapa.compareTo("satelite") == 0)
				mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			else
				if (tipoMapa.compareTo("hibrido") == 0)
					mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);	
		
		mapa.getUiSettings().setZoomControlsEnabled(botonesZoom);
		
	}

	@Override
	public boolean onMarkerClick(Marker marca) {
		presentador.lanzarDetalles(marca.getTitle());		
		return false;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_ajustes:
			Intent i = new Intent(AppMediador.getInstance().getApplicationContext(),Ajustes.class);
			startActivityForResult(i, 1);			
			break;

		case R.id.menu_ayuda:
			Intent intent = new Intent(AppMediador.getInstance().getApplicationContext(), AyudaVistaActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			AppMediador.getInstance().getApplicationContext().startActivity(intent);			
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void mostarMarcas(int vehiculosRestantes, String matricula, Double latitud, Double longitud) {
		Log.v("Vista Mapa mostarMarcas ", "UP");
		Log.v("MATRICULA", matricula);
		Log.v("LATITUD", Double.toString(latitud));
		Log.v("LONGITUD", Double.toString(longitud));
	
		if (vehiculosRestantes >= 0){
			Log.v("Vista Mapa mostarMarcas ", "IN vehiculosRe:"+Integer.toString(vehiculosRestantes));
			mapa.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud)).title(matricula));	
			presentador.obtenerVehiculos(vehiculosRestantes-1);			
		}
		Log.v("Vista Mapa mostarMarcas ", "DOWN");
		return;
		
	}

}
