package sgg.controlflotas;

import sgg.controlflotas.presentador.IPresentadorDetalleVehiculo;
import sgg.controlflotas.presentador.IPresentadorLoginActivity;
import sgg.controlflotas.presentador.IPresentadorMapaActivity;
import sgg.controlflotas.presentador.IPresentadorAyuda;
import sgg.controlflotas.presentador.PresentadorDetalleVehiculo;
import sgg.controlflotas.presentador.PresentadorLoginActivity;
import sgg.controlflotas.presentador.PresentadorMapaActivtiy;
import sgg.controlflotas.presentador.PresentadorAyuda;
import sgg.controlflotas.vista.ILoginVista;
import sgg.controlflotas.vista.IMapa;
import sgg.controlflotas.vista.IVista;
import android.app.Application;

@SuppressWarnings("rawtypes")
public class AppMediador extends Application {	

	private static AppMediador singleton;
	private IPresentadorLoginActivity presentadorLoginActivity;
	private ILoginVista vistaLogin;
	private IPresentadorMapaActivity presentadorMapaActivity;
	private IMapa vistaMapa;
	private IPresentadorAyuda presentadorAyuda;
	private IVista vistaAyuda, vistaDetalleVehiculo;
	private IPresentadorDetalleVehiculo presentadorDetalleVehiculo;	
	private Class ajustes;
	
	public static AppMediador getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		presentadorLoginActivity = new PresentadorLoginActivity();
		presentadorMapaActivity = new PresentadorMapaActivtiy();
		presentadorAyuda = new PresentadorAyuda();
		presentadorDetalleVehiculo = new PresentadorDetalleVehiculo();
	}

	public ILoginVista getVistaLogin() {
		return vistaLogin;
	}
	public void setVistaLogin(ILoginVista vistaLogin) {
		this.vistaLogin = vistaLogin;
	}
	public IPresentadorLoginActivity getPresentadorLoginActivity() {
		return presentadorLoginActivity;
	}
	public void setPresentadorLoginActivity(IPresentadorLoginActivity presentadorLoginActivity) {
		this.presentadorLoginActivity = presentadorLoginActivity;
	}
	public IPresentadorMapaActivity getPresentadorMapaActivity() {
		return presentadorMapaActivity;
	}
	public void setPresentadorMapaActivity(IPresentadorMapaActivity presentadorMapaActivity) {
		this.presentadorMapaActivity = presentadorMapaActivity;
	}
	public IMapa getVistaMapa() {
		return vistaMapa;
	}
	public void setVistaMapa(IMapa vistaMapa) {
		this.vistaMapa = vistaMapa;
	}
	public Class getAjustes() {
		return ajustes;
	}
	public void setAjustes(Class ajustes) {
		this.ajustes = ajustes;
	}	
	public IVista getVistaAyuda() {
		return vistaAyuda;
	}
	public void setVistaAyuda(IVista vistaAyuda) {
		this.vistaAyuda = vistaAyuda;
	}
	public IPresentadorAyuda getPresentadorAyuda() {
		return presentadorAyuda;
	}
	public void setPresentadorAyuda(IPresentadorAyuda presentadorAyuda) {
		this.presentadorAyuda = presentadorAyuda;
	}
	public IPresentadorDetalleVehiculo getPresentadorDetalleVehiculo() {
		return presentadorDetalleVehiculo;
	}
	public void setPresentadorDetalleVehiculo(IPresentadorDetalleVehiculo presentadorDetalleVehiculo) {
		this.presentadorDetalleVehiculo = presentadorDetalleVehiculo;
	}
	public IVista getVistaDetalleVehiculo() {
		return vistaDetalleVehiculo;
	}
	public void setVistaDetalleVehiculo(IVista vistaDetalleVehiculo) {
		this.vistaDetalleVehiculo = vistaDetalleVehiculo;
	}	

}
