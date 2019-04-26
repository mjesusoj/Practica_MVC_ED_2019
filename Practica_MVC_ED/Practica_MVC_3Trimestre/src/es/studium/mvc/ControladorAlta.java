package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorAlta implements WindowListener, ActionListener{
	
	VistaAltaAsignacion valtasignacion;
	Modelo modelo = null;
	
	public ControladorAlta(VistaAltaAsignacion valtasignacion, Modelo modelo) {
		this.valtasignacion = valtasignacion;
		this.modelo = modelo;
		
		valtasignacion.btnAceptar.addActionListener(this);
		valtasignacion.btnCancelar.addActionListener(this);
		valtasignacion.addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(valtasignacion.btnAceptar.equals(arg0.getSource())) {
			valtasignacion.setVisible(false);
			VistaAltaAsignacion valtasignacion1 = new VistaAltaAsignacion();
			valtasignacion = valtasignacion1;
			
			modelo.insertarasignacion(valtasignacion);
		}
		else if(valtasignacion.btnCancelar.equals(arg0.getSource())) {
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new Controlador(vmenuprincipal, modelo);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		if (valtasignacion.isActive()) {
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new Controlador(vmenuprincipal, modelo);
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