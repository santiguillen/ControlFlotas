package sgg.controlflotas.presentador;

import java.util.Locale;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import sgg.controlflotas.AppMediador;
import sgg.controlflotas.vista.MapaVistaActivity;

public class PresentadorLoginActivity implements IPresentadorLoginActivity {
	
	private String idioma;

	@Override
	public void solicitarEntrada(String usuario, String password) {
		if (usuario.equals("PEM") && password.equals("admin")){
			Intent intent = new Intent(AppMediador.getInstance().getApplicationContext(),MapaVistaActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			AppMediador.getInstance().getApplicationContext().startActivity(intent);	
		} else {
			AppMediador.getInstance().getVistaLogin().crearAlerta("ErrorSesion");		
		}
	}

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
	
	

}
