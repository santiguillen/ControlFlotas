package sgg.controlflotas.presentador;

public interface IPresentadorDetalleVehiculo {
	
	public void actualizarIdioma();
	
	public String getNombreConductor(String matricula);
	
	public String getTipoConductor(String matricula);
	
	public Double getLatitud(String matricula);
	
	public Double getLongitud(String matricula);
	
	public void realizarLlamada (String matricula);
	
	public void mandarSMS (String matricula, String mensaje);

}
