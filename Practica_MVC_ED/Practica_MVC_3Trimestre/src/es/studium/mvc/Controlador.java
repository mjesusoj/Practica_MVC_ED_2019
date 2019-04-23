package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener{
	
	VistaMenuPrincipal vmenuprincipal = null;
	VistaBajaDemandante vbajademandante = null;
	VistaConfirmacionBaja vconfirmarbaja = null;	
	Modelo modelo = null;
	
	VistaModificacionOferta vmodoferta = null;
	VistaEdicionOferta vedicionoferta = null;
	VistaConsultaOfertas vconsultaofertas = null;
	
	public Controlador(VistaMenuPrincipal vmenuprincipal, Modelo modelo) {
		this.vmenuprincipal = vmenuprincipal;
		this.modelo = modelo;
		
		vmenuprincipal.mniDemandantesBaja.addActionListener(this);
		vmenuprincipal.mniOfertasModificacion.addActionListener(this);
		vmenuprincipal.mniOfertasConsulta.addActionListener(this);
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
			Modelo.insertarDemandanteBaja(vbajademandante);
			
			// Añadir los escuchadores
			vbajademandante.btnEliminar.addActionListener(this);
			vbajademandante.btnCancelar.addActionListener(this);
			vbajademandante.addWindowListener(this);
		}
		
		else if(vmenuprincipal.mniOfertasModificacion.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			vmodoferta = new VistaModificacionOferta();
			
			// Iniciar método de la clase ModeloOferta
			ModeloOferta.cargarOferta(vmodoferta);
			
			vmodoferta.btnEditar.addActionListener(this);
			vmodoferta.btnCancelar.addActionListener(this);
			vmodoferta.addWindowListener(this);
		}
		
		else if(vmenuprincipal.mniOfertasConsulta.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			vconsultaofertas = new VistaConsultaOfertas();
		}
		
		else if (vbajademandante.btnEliminar.equals(arg0.getSource())) {
			vbajademandante.setVisible(false);
			vconfirmarbaja = new VistaConfirmacionBaja();
			// Llamar al método para saber que demandante se ha elegido.
			Modelo.demandanteaeliminar(vbajademandante, vconfirmarbaja);
			
			vconfirmarbaja.btnSi.addActionListener(this);
			vconfirmarbaja.btnNo.addActionListener(this);
			vconfirmarbaja.addWindowListener(this);
		}
		
		else if (vbajademandante.btnCancelar.equals(arg0.getSource())){
			vbajademandante.setVisible(false);
			vmenuprincipal.setVisible(true);
		}
		
		else if (vconfirmarbaja.btnSi.equals(arg0.getSource())) {
			Modelo.eliminarDemandante(vbajademandante, vconfirmarbaja);
		}
		
		else if (vconfirmarbaja.btnNo.equals(arg0.getSource())) {
			vconfirmarbaja.setVisible(false);
			vbajademandante.setVisible(true);
		}
		
		else if(vmodoferta.btnEditar.equals(arg0.getSource())) {
			vmodoferta.setVisible(false);
			vedicionoferta = new VistaEdicionOferta();
			
			ModeloOferta.cargarcomponentesEdicion(vedicionoferta, vmodoferta);
		}
		
		else if(vmodoferta.btnCancelar.equals(arg0.getSource())) {
			vmodoferta.setVisible(false);
			vmenuprincipal.setVisible(true);
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