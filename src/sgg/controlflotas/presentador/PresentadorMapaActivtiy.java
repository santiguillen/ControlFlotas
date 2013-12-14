package sgg.controlflotas.presentador;

import java.util.Locale;

import sgg.controlflotas.AppMediador;
import sgg.controlflotas.modelo.ModeloVehiculo;
import sgg.controlflotas.vista.DetalleVehiculoActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.util.Log;

public class PresentadorMapaActivtiy implements IPresentadorMapaActivity {
	
	private String tipoMapa, idioma;
	private boolean botonesZoom;

	@Override
	public void tratarPreferenciasMapa() {
		SharedPreferences ajustes = PreferenceManager.getDefaultSharedPreferences(
				AppMediador.getInstance().getApplicationContext());
		idioma = ajustes.getString("idioma", "NULL");
		tipoMapa = ajustes.getString("tipoMapa", "NULL");
		botonesZoom = ajustes.getBoolean("botonesZoom", true);
		actualizarIdioma();
		actualizarAjustesMapa();;		
	}

	@SuppressWarnings("static-access")
	@Override
	public void actualizarIdioma() {
		Locale locale;
		if (idioma.equals("ES"))
			locale = new Locale("es_ES");
		else
			locale = new Locale("en_EN");
		locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		AppMediador.getInstance().getApplicationContext().getResources().updateConfiguration(config, null);			
	}

	@Override
	public void actualizarAjustesMapa() {
		AppMediador.getInstance().getVistaMapa().cambiarAjustesMapa(tipoMapa, botonesZoom);		
	}

	@Override
	public void lanzarDetalles(String idVehiculo) {
		Intent intent = new Intent(AppMediador.getInstance().getApplicationContext(), DetalleVehiculoActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("idVehiculo", idVehiculo);
		AppMediador.getInstance().startActivity(intent);		
	}

	@Override
	public int numeroVehiculos() {
		return ModeloVehiculo.getInstance().numeroVehiculos();
	}

	@Override
	public void obtenerVehiculos(int vehiculosRestantes) {
		Log.v("Presentador Mapa, vehiculosRestantes UP  : ", Integer.toString(vehiculosRestantes));
		
		if (vehiculosRestantes >= 0) {			
			String matricula = ModeloVehiculo.getInstance().buscarVehiculoPosicion(vehiculosRestantes).getMatricula();
			Double latitud = ModeloVehiculo.getInstance().buscarVehiculoPosicion(vehiculosRestantes).getLatitud();
			Double longitud = ModeloVehiculo.getInstance().buscarVehiculoPosicion(vehiculosRestantes).getLongitud();
			Log.v("Presentador Mapa, vehiculosRestantes : ", Integer.toString(vehiculosRestantes));
			AppMediador.getInstance().getVistaMapa().mostarMarcas(vehiculosRestantes, matricula, latitud, longitud);			
		}
	}

}