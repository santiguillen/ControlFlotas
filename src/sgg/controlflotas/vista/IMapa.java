package sgg.controlflotas.vista;

public interface IMapa {
	
	public void cambiarAjustesMapa(String tipoMapa, boolean botonesZoom);
	
	public void mostarMarcas(int vehiculosRestantes, String matricula, Double latitud, Double longitud);
	
}
