package sgg.controlflotas.modelo;

public interface IModeloVehiculo {
	
	public FichaVehiculo buscarVehiculoMatricula(String matricula);
	
	public FichaVehiculo buscarVehiculoPosicion(int posicion);
	
	public int numeroVehiculos();

}
