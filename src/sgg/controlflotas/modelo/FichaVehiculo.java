package sgg.controlflotas.modelo;

public class FichaVehiculo {
	
	private String matricula, tipoVehiculo, nombreConductor, telefono;
	private Double latitud, longitud; //última posición
	
	public FichaVehiculo(String matricula, String tipoVehiculo,
			String nombreConductor, String telefono, Double latitud, Double longitud) {
		super();
		this.matricula = matricula;
		this.tipoVehiculo = tipoVehiculo;
		this.nombreConductor = nombreConductor;
		this.setTelefono(telefono);
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getNombreConductor() {
		return nombreConductor;
	}

	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
