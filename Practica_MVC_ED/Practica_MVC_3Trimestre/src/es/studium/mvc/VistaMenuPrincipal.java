package es.studium.mvc;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaMenuPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	JMenuBar barraMenu = new JMenuBar();
	
	JMenu menuDemandantes = new JMenu("Demandantes");
	JMenu menuOfertas = new JMenu("Ofertas");
	JMenu menuGestion = new JMenu("Gestión");
	
	// Submenús
	JMenuItem mniDemandantesBaja = new JMenuItem("Baja");
	JMenuItem mniOfertasModificacion = new JMenuItem("Modificación");
	JMenuItem mniOfertasConsulta = new JMenuItem("Consulta");
	JMenuItem mniGestionAlta = new JMenuItem("Alta");
	
	VistaMenuPrincipal()
	{
		setTitle("Práctica MVC");
		setJMenuBar(barraMenu);
		
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