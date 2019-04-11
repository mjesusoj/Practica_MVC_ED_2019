package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener{
	
	VistaMenuPrincipal vmenuprincipal = null;
	VistaBajaDemandante vbajademandante = null;
	Modelo modelo = null;
	
	public Controlador(VistaMenuPrincipal vmenuprincipal, Modelo modelo) {
		this.vmenuprincipal = vmenuprincipal;
		this.modelo = modelo;
		
		vmenuprincipal.mniDemandantesBaja.addActionListener(this);
		vmenuprincipal.mniOfertasConsulta.addActionListener(this);
		vmenuprincipal.mniOfertasModificacion.addActionListener(this);
		vmenuprincipal.mniGestionAlta.addActionListener(this);
		vmenuprincipal.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.vmenuprincipal.mniDemandantesBaja.equals(arg0.getSource())) {
			// Hacer visible la otra vista
			vmenuprincipal.setVisible(false);
			vbajademandante = new VistaBajaDemandante();
			
			// Añadir los Actionlisteners y WindowListener
			vbajademandante.btnCancelar.addActionListener(this);
			vbajademandante.btnEliminar.addActionListener(this);
			vbajademandante.addWindowListener(this);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		if (vmenuprincipal.isActive()) {
			System.exit(0);
		}
		
		else if(vbajademandante.isActive()) {
			vbajademandante.setVisible(false);
			vmenuprincipal.setVisible(true);
		}
	}


	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}
	
	@Override
	public void windowIconified(WindowEvent e) {}
	
	@Override
	public void windowOpened(WindowEvent e) {}
}