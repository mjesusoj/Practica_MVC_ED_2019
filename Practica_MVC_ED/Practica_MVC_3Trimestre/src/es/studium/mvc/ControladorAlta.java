package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorAlta implements WindowListener, ActionListener{
	
	VistaAltaAsignacion valtasignacion;
	Modelo modelo;
	
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
			Modelo.insertarasignacion(valtasignacion);
		}
		else if(valtasignacion.btnCancelar.equals(arg0.getSource())) {
			valtasignacion.setVisible(false);
			new VistaMenuPrincipal();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		
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