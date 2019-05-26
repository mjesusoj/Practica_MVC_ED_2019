package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControladorModificacion extends WindowAdapter implements ActionListener{

	VistaModificacionOferta vmodoferta = null;
	VistaEdicionOferta vedicionoferta = null;
	Modelo modelo = null;

	public ControladorModificacion(VistaModificacionOferta vmodoferta, Modelo modelo) {
		this.modelo = modelo;
		this.vmodoferta = vmodoferta;
		vmodoferta.btnEditar.addActionListener(this);
		vmodoferta.btnCancelar.addActionListener(this);
		vmodoferta.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {			
		if(vmodoferta.btnEditar.equals(ae.getSource())) {
			vmodoferta.setVisible(false);
			VistaEdicionOferta vedicionoferta1 = new VistaEdicionOferta();
			vedicionoferta = vedicionoferta1;

			modelo.cargarcomponentesEdicion(vedicionoferta, vmodoferta);

			// Listeners
			vedicionoferta.btnActualizar.addActionListener(this);
			vedicionoferta.btnCancelar.addActionListener(this);
			vedicionoferta.addWindowListener(this);
		}

		else if(vmodoferta.btnCancelar.equals(ae.getSource())) {
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}
		
		else if(vedicionoferta.btnActualizar.equals(ae.getSource())) {
			Modelo.modificarcamposEdicion(vedicionoferta);
		}
		
		else if(vedicionoferta.btnCancelar.equals(ae.getSource())) {
			vedicionoferta.setVisible(false);
			vmodoferta.setVisible(true);
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if(vmodoferta.isActive()) {
			VistaMenuPrincipal vmenuprincipal = new VistaMenuPrincipal();
			new ControladorPrincipal(vmenuprincipal, modelo);
		}

		else if(vedicionoferta.isActive()) {
			vedicionoferta.setVisible(false);
			VistaModificacionOferta vmodoferta = new VistaModificacionOferta();

			new ControladorModificacion(vmodoferta, modelo);
			// Iniciar método de la clase Modelo
			modelo.cargarOferta(vmodoferta);
		}
	}
}