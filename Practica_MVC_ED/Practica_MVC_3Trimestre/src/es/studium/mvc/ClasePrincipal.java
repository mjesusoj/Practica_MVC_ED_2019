package es.studium.mvc;

public class ClasePrincipal {
	public static void main(String[] args) {
		VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
		Modelo modelo = new Modelo();
		new ControladorPrincipal(vmenuprincipal, modelo);
	}
}