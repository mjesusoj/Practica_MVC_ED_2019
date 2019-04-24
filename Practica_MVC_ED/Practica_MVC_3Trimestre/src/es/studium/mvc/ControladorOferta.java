package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorOferta implements WindowListener, ActionListener{

	VistaMenuPrincipal vmenuprincipal = null;
	VistaModificacionOferta vmodoferta = null;
	VistaEdicionOferta vedicionoferta = null;
	VistaConsultaOfertas vconsultaofertas = null;
	ModeloOferta modeloferta = null;
	
	public ControladorOferta(VistaMenuPrincipal vmenuprincipal, ModeloOferta modeloferta) {
		this.vmenuprincipal = vmenuprincipal;
		this.modeloferta = modeloferta;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(vmenuprincipal.mniOfertasModificacion.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			vmodoferta = new VistaModificacionOferta();
			
			// Iniciar método de la clase ModeloOferta
			//ModeloOferta.cargarOferta(vmodoferta);
			
			vmodoferta.btnEditar.addActionListener(this);
			vmodoferta.btnCancelar.addActionListener(this);
			vmodoferta.addWindowListener(this);
		}
		
		else if(vmodoferta.btnEditar.equals(arg0.getSource())) {
			vmodoferta.setVisible(false);
			vedicionoferta = new VistaEdicionOferta();
			
			//ModeloOferta.cargarcomponentesEdicion(vedicionoferta, vmodoferta);
		}
		
		else if(vmodoferta.btnCancelar.equals(arg0.getSource())) {
			vmodoferta.setVisible(false);
			vmenuprincipal.setVisible(true);
		}
		
		else if(vmenuprincipal.mniOfertasConsulta.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			vconsultaofertas = new VistaConsultaOfertas();
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
			vmenuprincipal.setVisible(true);
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