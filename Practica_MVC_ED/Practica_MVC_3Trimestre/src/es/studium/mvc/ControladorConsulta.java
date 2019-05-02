package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControladorConsulta extends WindowAdapter implements ActionListener{

	VistaConsultaOferta vconsultaoferta = null;
	Modelo modelo = null;

	public ControladorConsulta(VistaConsultaOferta vconsultaoferta, Modelo modelo) {
		this.vconsultaoferta = vconsultaoferta;
		this.modelo = modelo;

		vconsultaoferta.btnAceptar.addActionListener(this);
		vconsultaoferta.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (vconsultaoferta.btnAceptar.equals(ae.getSource())) {
			vconsultaoferta.setVisible(false);
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if (vconsultaoferta.isActive()) {
			vconsultaoferta.setVisible(false);
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}
	}
}