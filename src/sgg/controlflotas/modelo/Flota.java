package sgg.controlflotas.modelo;

import java.util.ArrayList;

public class Flota {
	
	private ArrayList<FichaVehiculo> miFlota;

	public Flota() {
		miFlota = new ArrayList<FichaVehiculo>();
		setVehiculo("GC 5678 AA", "coche", "Pedro", "+34123121212", 28.095959, -15.423330);
		setVehiculo("GC 1298 BB", "camion", "Pablo", "+34123121212", 28.075390, -15.612333);
		setVehiculo("TF 1298 CM", "moto", "Wilma", "+34123121212", 28.115390, -15.612333);
		setVehiculo("GC 2293 BP", "moto", "Betty", "+34123121212", 28.511721, -16.318512);
	}
	
	public FichaVehiculo getVehiculoMatricula(String matricula) {
		for (int i = 0; i < miFlota.size(); i++) {
			FichaVehiculo miVehiculo = miFlota.get(i);
			if (miVehiculo.getMatricula().equals(matricula))
				return miVehiculo;
		}
		return null;
	}
	
	public FichaVehiculo getVehiculoPosicion(int posicion) {
		return miFlota.get(posicion);
	}
	
	public void setVehiculo(String matricula, String tipoVehiculo,
			String nombreConductor, String telefono, Double latitud, Double longitud){		
		miFlota.add(new FichaVehiculo(matricula, tipoVehiculo, nombreConductor, telefono, latitud, longitud));		
	}
	
	public int sizeFlota(){
		return miFlota.size();
	}
	
	

}

