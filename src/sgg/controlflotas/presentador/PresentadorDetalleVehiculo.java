package sgg.controlflotas.presentador;

import java.util.Locale;

import sgg.controlflotas.AppMediador;
import sgg.controlflotas.modelo.ModeloVehiculo;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;

public class PresentadorDetalleVehiculo implements IPresentadorDetalleVehiculo {
	
	private String idioma;

	@SuppressWarnings("static-access")
	@Override
	public void actualizarIdioma() {
		
		SharedPreferences ajustes = PreferenceManager.getDefaultSharedPreferences(
				AppMediador.getInstance().getApplicationContext());
		idioma = ajustes.getString("idioma", "NULL");
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
	public String getNombreConductor(String matricula) {
		return ModeloVehiculo.getInstance().buscarVehiculoMatricula(matricula).getNombreConductor();
	}

	@Override
	public String getTipoConductor(String matricula) {
		return ModeloVehiculo.getInstance().buscarVehiculoMatricula(matricula).getTipoVehiculo();
	}

	@Override
	public Double getLatitud(String matricula) {
		return ModeloVehiculo.getInstance().buscarVehiculoMatricula(matricula).getLatitud();
	}

	@Override
	public Double getLongitud(String matricula) {
		return ModeloVehiculo.getInstance().buscarVehiculoMatricula(matricula).getLongitud();
	}

	@Override
	public void realizarLlamada(String matricula) {
	/*	String telefono = ModeloVehiculo.getInstance().buscarVehiculoMatricula(matricula).getTelefono();
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono));
		AppMediador.getInstance().startActivity(intent);
	*/			
	}

	@Override
	public void mandarSMS(String matricula, String mensaje) {
		String telefono = ModeloVehiculo.getInstance().buscarVehiculoMatricula(matricula).getTelefono();
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(telefono, null, mensaje, null, null);

	}

}
