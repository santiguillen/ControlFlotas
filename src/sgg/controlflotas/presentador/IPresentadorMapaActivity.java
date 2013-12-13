package sgg.controlflotas.presentador;

public interface IPresentadorMapaActivity {
	
	public void tratarPreferenciasMapa ();
	
	public void actualizarIdioma();
	
	public void actualizarAjustesMapa();
	
	public void lanzarDetalles(String idVehiculo);
	
	public int numeroVehiculos();
	
	public void obtenerVehiculos(int vehiculosRestantes);

}
