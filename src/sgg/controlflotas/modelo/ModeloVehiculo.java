package sgg.controlflotas.modelo;

public class ModeloVehiculo implements IModeloVehiculo {
	
	private Flota miFlota;
	private static ModeloVehiculo singleton;
	
	private ModeloVehiculo() {
		miFlota = new Flota();
	}
	
	public static ModeloVehiculo getInstance() {
		if (singleton == null)
			singleton = new ModeloVehiculo();
		return singleton;
		
	}

	@Override
	public FichaVehiculo buscarVehiculoMatricula(String matricula) {
		return miFlota.getVehiculoMatricula(matricula);
	}

	@Override
	public int numeroVehiculos() {
		return miFlota.sizeFlota()-1;
	}
	
	@Override
	public FichaVehiculo buscarVehiculoPosicion(int posicion) {
		return miFlota.getVehiculoPosicion(posicion);
		
	}

}