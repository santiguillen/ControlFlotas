package sgg.controlflotas.vista;

import sgg.controlflotas.AppMediador;
import sgg.controlflotas.presentador.IPresentadorDetalleVehiculo;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleVehiculoActivity extends Activity implements IVista, OnClickListener {
	
	private IPresentadorDetalleVehiculo presentador;
		
	private String matricula;
	private TextView matriculaTextView, conductorTextView;
	private Button botonLlamada, botonSMS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_vehiculo);
		
		presentador = AppMediador.getInstance().getPresentadorDetalleVehiculo();
		AppMediador.getInstance().setVistaDetalleVehiculo(this);
				
		Intent intent = getIntent();
		matricula = intent.getStringExtra("idVehiculo");	
		
		((TextView) findViewById(R.id.idVehiculo)).setTypeface(null, Typeface.BOLD);
		((TextView) findViewById(R.id.idConductor)).setTypeface(null, Typeface.BOLD);
		
		matriculaTextView = (TextView) findViewById(R.id.idMatricula);
		matriculaTextView.setText(matricula);
		
		conductorTextView = (TextView) findViewById(R.id.idNombreConductor);
		conductorTextView.setText(presentador.getNombreConductor(matricula));
		
		botonLlamada = (Button) findViewById(R.id.botonLLamada);
		botonSMS = (Button) findViewById(R.id.botonSMS);
		
		botonLlamada.setOnClickListener(this);
		botonSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.botonLLamada:			
			AlertDialog.Builder alerta = new AlertDialog.Builder(this);
			alerta.setTitle("LLamada telefonica");
			alerta.setMessage("¿Seguro que quiere realizar la llamada?");
			alerta.setIcon(android.R.drawable.ic_menu_call);
			alerta.setPositiveButton("OK", new  DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) { 
					presentador.realizarLlamada(matricula);
				} 
				});
			alerta.setNegativeButton("CANCEL", null);
			alerta.show();
			break;

		case R.id.botonSMS:		
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setTitle(R.string.tituloSMS);
			alert.setMessage(R.string.cuerpoSMS);
			alert.setIcon(android.R.drawable.ic_dialog_email);
			final EditText input = new EditText(this); //se crea un EditText
			int maxLength = 160; //tamaño máximo de un SMS
			InputFilter[] FilterArray = new InputFilter[1];
			FilterArray[0] = new InputFilter.LengthFilter(maxLength);
			input.setFilters(FilterArray); 
			alert.setView(input); //añado el EditText a la alerta
			alert.setPositiveButton("OK", new  DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) { 
					presentador.mandarSMS(matricula, input.getText().toString());								
				} 
				});
			alert.setNegativeButton("CANCEL", null);
			alert.show();			
			break;		
		}
		
		
	}
	
	
}
