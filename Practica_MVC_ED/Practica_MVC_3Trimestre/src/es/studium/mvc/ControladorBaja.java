package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class ControladorBaja implements WindowListener, ActionListener{

	VistaBajaDemandante vbajademandante = null;
	VistaConfirmacionBaja vconfirmarbaja = null;
	Modelo modelo = null;

	public ControladorBaja(VistaBajaDemandante vbajademandante, Modelo modelo) {
		this.vbajademandante = vbajademandante;
		this.modelo = modelo;

		vbajademandante.btnEliminar.addActionListener(this);
		vbajademandante.btnCancelar.addActionListener(this);
		vbajademandante.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (vbajademandante.btnEliminar.equals(arg0.getSource())) {
			if (vbajademandante.chcElegir.getSelectedItem().equals("Elegir uno...")){
				JOptionPane.showMessageDialog(null, "No se puede escoger ese elemento, escoja otro", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				vbajademandante.setVisible(false);
				VistaConfirmacionBaja vconfirmarbaja1 = new VistaConfirmacionBaja();
				vconfirmarbaja = vconfirmarbaja1;
				// Llamar al método para saber que demandante se ha elegido.
				modelo.demandanteaeliminar(vbajademandante, vconfirmarbaja);
				vconfirmarbaja.btnSi.addActionListener(this);
				vconfirmarbaja.btnNo.addActionListener(this);
				vconfirmarbaja.addWindowListener(this);
			}
		}

		else if (vbajademandante.btnCancelar.equals(arg0.getSource())){
			vbajademandante.setVisible(false);
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}

		else if (vconfirmarbaja.btnSi.equals(arg0.getSource())) {
			modelo.eliminarDemandante(vbajademandante, vconfirmarbaja);
		}

		else if (vconfirmarbaja.btnNo.equals(arg0.getSource())) {
			vconfirmarbaja.setVisible(false);
			vbajademandante.setVisible(true);
		}
	}

	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if (vbajademandante.isActive()) {
			vbajademandante.setVisible(false);
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}

		else if(vconfirmarbaja.isActive()) {
			vconfirmarbaja.setVisible(false);
			vbajademandante.setVisible(true);
		}
	}

	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}