package sgg.controlflotas.vista;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Ajustes extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.ajustes);
	}
		
}
