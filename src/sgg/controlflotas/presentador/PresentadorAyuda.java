package sgg.controlflotas.presentador;

import java.util.Locale;

import sgg.controlflotas.AppMediador;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

public class PresentadorAyuda implements IPresentadorAyuda {
	
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

}
