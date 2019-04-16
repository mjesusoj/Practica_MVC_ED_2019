package es.studium.mvc;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;

public class VistaMenuPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	MenuBar barraMenu = new MenuBar();
	
	Menu menuDemandantes = new Menu("Demandantes");
	Menu menuOfertas = new Menu("Ofertas");
	Menu menuGestion = new Menu("Gestión");
	
	// Submenús
	MenuItem mniDemandantesBaja = new MenuItem("Baja");
	MenuItem mniOfertasModificacion = new MenuItem("Modificación");
	MenuItem mniOfertasConsulta = new MenuItem("Consulta");
	MenuItem mniGestionAlta = new MenuItem("Alta");
	
	VistaMenuPrincipal()
	{
		setTitle("Práctica MVC");
		setMenuBar(barraMenu);
		
		// Añadir los menús
		barraMenu.add(menuDemandantes);
		barraMenu.add(menuOfertas);
		barraMenu.add(menuGestion);
		
		// Añadir los submenús
		menuDemandantes.add(mniDemandantesBaja);
		menuOfertas.add(mniOfertasModificacion);
		menuOfertas.add(mniOfertasConsulta);
		menuGestion.add(mniGestionAlta);
		
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}