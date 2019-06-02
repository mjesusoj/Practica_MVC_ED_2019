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
			modelo.insertarasignacion(valtasignacion);
		}

		else if(valtasignacion.btnCancelar.equals(arg0.getSource())) {
			valtasignacion.setVisible(false);
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (valtasignacion.isActive()) {
			valtasignacion.setVisible(false);
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}
	}

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
}