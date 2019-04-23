package es.studium.mvc;

public class ClasePrincipal {
	public static void main(String[] args) {
		VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
		Modelo modelobaja = new Modelo();
		new Controlador(vmenuprincipal, modelobaja);
	}
}