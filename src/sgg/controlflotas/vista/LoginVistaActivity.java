package sgg.controlflotas.vista;

import sgg.controlflotas.AppMediador;
import sgg.controlflotas.presentador.IPresentadorLoginActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginVistaActivity extends Activity implements ILoginVista, OnClickListener{
	
	private IPresentadorLoginActivity presentador;
	private EditText user, password;
	private Button botonEntrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_vista);		
		presentador = AppMediador.getInstance().getPresentadorLoginActivity();		
		AppMediador.getInstance().setVistaLogin(this);		
		user = (EditText) this.findViewById(R.id.user);
		password = (EditText) this.findViewById(R.id.password);
		botonEntrar = (Button) this.findViewById(R.id.botonEntrar);
		botonEntrar.setOnClickListener(this);				
	}

	@Override
	public void crearAlerta(String mensaje) {
		if (mensaje.endsWith("ErrorSesion")){
			AlertDialog.Builder alerta = new AlertDialog.Builder(this);
			alerta.setTitle(getString(R.string.alarmaLoginTitulo));
			alerta.setMessage(getString(R.string.alarmaLoginContenido));
			alerta.setPositiveButton(getString(R.string.confirmarError), null);
			alerta.show();			
		}		
	}

	@Override
	public void onClick(View v) {
		presentador.solicitarEntrada(user.getText().toString(), password.getText().toString());
		
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
		
		case R.id.menu_salir:
			int id = android.os.Process.myPid();
			android.os.Process.killProcess(id);			
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_vista, menu);
		return true;
	}
	
	//Métodos añadidos para la gestión del cambio de Idioma
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		getMenuInflater().inflate(R.menu.login_vista, menu);
		return super.onPrepareOptionsMenu(menu);
	} 
	
	@Override
	protected void onStart() {
		super.onStart();
		presentador.actualizarIdioma();
		setContentView(R.layout.activity_login_vista);
		user = (EditText) this.findViewById(R.id.user);
		password = (EditText) this.findViewById(R.id.password);
		botonEntrar = (Button) this.findViewById(R.id.botonEntrar);
		botonEntrar.setOnClickListener(this);				
	} 

}
