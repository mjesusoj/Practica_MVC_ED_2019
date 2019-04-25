package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorOferta implements WindowListener, ActionListener{

	VistaModificacionOferta vmodoferta = null;
	VistaEdicionOferta vedicionoferta = null;
	VistaConsultaOferta vconsultaofertas = null;
	Modelo modelo = null;
	
	public ControladorOferta(VistaModificacionOferta vmodoferta, VistaConsultaOferta vconsultaofertas, Modelo modelo) {
		this.modelo = modelo;
		this.vmodoferta = vmodoferta;
		this.vconsultaofertas = vconsultaofertas;
		vmodoferta.btnEditar.addActionListener(this);
		vmodoferta.btnCancelar.addActionListener(this);
		vmodoferta.addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {			
		if(vmodoferta.btnEditar.equals(arg0.getSource())) {
			vmodoferta.setVisible(false);
			VistaEdicionOferta vedicionoferta1 = new VistaEdicionOferta();
			vedicionoferta = vedicionoferta1;
				
			Modelo.cargarcomponentesEdicion(vedicionoferta, vmodoferta);
				
			// Listeners
			vedicionoferta.btnActualizar.addActionListener(this);
			vedicionoferta.btnCancelar.addActionListener(this);
			vedicionoferta.addWindowListener(this);
		}
		
		if(vmodoferta.btnCancelar.equals(arg0.getSource())) {
			vmodoferta.setVisible(false);
			new VistaMenuPrincipal();
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}
	
	@Override
	public void windowClosed(WindowEvent arg0) {}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		if(vmodoferta.isActive()) {
			vmodoferta.setVisible(false);
			new VistaMenuPrincipal();
		}
		
		else if(vedicionoferta.isActive()) {
			vedicionoferta.setVisible(false);
			vmodoferta.setVisible(true);
		}
	}
	
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	
	@Override
	public void windowIconified(WindowEvent arg0) {}
	
	@Override
	public void windowOpened(WindowEvent arg0) {}	
	
}