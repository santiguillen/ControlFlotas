package sgg.controlflotas.vista;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HelpVistaActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_vista);
		
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help_vista, menu);
		return true;
	}
	
}
