package sgg.controlflotas.vista;

import sgg.controlflotas.AppMediador;
import sgg.controlflotas.presentador.IPresentadorAyuda;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;

public class AyudaVistaActivity extends TabActivity implements IVista{
	
	private IPresentadorAyuda presentador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ayuda_vista);		
		presentador = AppMediador.getInstance().getPresentadorAyuda();
		AppMediador.getInstance().setVistaAyuda(this);
		
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		
		Intent helpIntent = new Intent().setClass(this, HelpVistaActivity.class);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(getString(R.string.title_activity_help_vista), 
				getResources().getDrawable(android.R.drawable.ic_menu_help)).setContent(helpIntent)); 	
		
		Intent novedadesIntent = new Intent().setClass(this, NovedadesVistaActivity.class);
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(getString(R.string.title_activity_novedades_vista),
				getResources().getDrawable(android.R.drawable.ic_menu_more)).setContent(novedadesIntent));
		
		Intent acercaDeIntent = new Intent().setClass(this, AcercaDeActivity.class);
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(getString(R.string.title_activity_acerca_de),
				getResources().getDrawable(android.R.drawable.ic_menu_info_details)).setContent(acercaDeIntent));
		
		tabHost.setCurrentTab(0); 
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		presentador.actualizarIdioma();
				
	} 

}
