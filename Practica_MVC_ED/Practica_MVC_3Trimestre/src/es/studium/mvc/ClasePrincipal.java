package es.studium.mvc;

public class ClasePrincipal {
	public static void main(String[] args) {
		VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
		ModeloBaja modelobaja = new ModeloBaja();
		new Controlador(vmenuprincipal, modelobaja);
	}
}