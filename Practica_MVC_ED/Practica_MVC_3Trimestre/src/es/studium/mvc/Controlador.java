package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener{
	
	VistaMenuPrincipal vmenuprincipal = null;
	VistaBajaDemandante vbajademandante = null;
	VistaModificacionOferta vmodoferta = null;
	VistaConfirmacionBaja vconfirmarbaja = null;
	ModeloBaja modelobaja = null;
	
	public Controlador(VistaMenuPrincipal vmenuprincipal, ModeloBaja modelobaja) {
		this.vmenuprincipal = vmenuprincipal;
		this.modelobaja = modelobaja;
		
		vmenuprincipal.mniDemandantesBaja.addActionListener(this);
		vmenuprincipal.mniOfertasConsulta.addActionListener(this);
		vmenuprincipal.mniOfertasModificacion.addActionListener(this);
		vmenuprincipal.mniGestionAlta.addActionListener(this);
		vmenuprincipal.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (vmenuprincipal.mniDemandantesBaja.equals(arg0.getSource())) {
			// Hacer visible la otra vista
			vmenuprincipal.setVisible(false);
			vbajademandante = new VistaBajaDemandante();
			
			// Iniciar el método que carga los demandantes de la BD
			ModeloBaja.insertarDemandanteBaja(vbajademandante);
			
			// Añadir los Actionlisteners y WindowListener
			vbajademandante.btnCancelar.addActionListener(this);
			vbajademandante.btnEliminar.addActionListener(this);
			vbajademandante.addWindowListener(this);
		}
		
		else if (vbajademandante.btnEliminar.equals(arg0.getSource())) {
			vbajademandante.setVisible(false);
			vconfirmarbaja = new VistaConfirmacionBaja();
			
			vconfirmarbaja.btnSi.addActionListener(this);
			vconfirmarbaja.btnNo.addActionListener(this);
			vconfirmarbaja.addWindowListener(this);
		}
		
		else if (vconfirmarbaja.btnSi.equals(arg0.getSource())) {
			ModeloBaja.eliminarDemandante(vbajademandante, vbajademandante);
		}
		
		else if (vconfirmarbaja.btnNo.equals(arg0.getSource())) {
			vconfirmarbaja.setVisible(false);
			vbajademandante.setVisible(true);
		}
		
		else if (vmenuprincipal.mniOfertasModificacion.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			vmodoferta = new VistaModificacionOferta();
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
		
		else if(vconfirmarbaja.isActive()) {
			vconfirmarbaja.setVisible(false);
			vbajademandante.setVisible(true);
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