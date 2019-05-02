package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControladorPrincipal extends WindowAdapter implements ActionListener{

	VistaMenuPrincipal vmenuprincipal;
	VistaBajaDemandante vbajademandante;
	VistaModificacionOferta vmodoferta;
	VistaConsultaOferta vconsultaoferta;
	VistaAltaAsignacion valtasignacion;
	Modelo modelo = null;

	public ControladorPrincipal(VistaMenuPrincipal vmenuprincipal, Modelo modelo) {
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
			vmenuprincipal.setVisible(false);

			VistaBajaDemandante vbajademandante = new VistaBajaDemandante();

			new ControladorBaja(vbajademandante, modelo);

			// Iniciar el método que carga los demandantes de la BD
			modelo.insertarDemandanteBaja(vbajademandante);
		}

		else if (vmenuprincipal.mniOfertasModificacion.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			VistaModificacionOferta vmodoferta = new VistaModificacionOferta();

			new ControladorModificacion(vmodoferta, modelo);
			// Iniciar método de la clase Modelo
			modelo.cargarOferta(vmodoferta);
		}

		else if (vmenuprincipal.mniOfertasConsulta.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			VistaConsultaOferta vconsultaoferta = new VistaConsultaOferta();
			new ControladorConsulta(vconsultaoferta, modelo);
		}

		else if (vmenuprincipal.mniGestionAlta.equals(arg0.getSource())) {
			vmenuprincipal.setVisible(false);
			VistaAltaAsignacion valtasignacion = new VistaAltaAsignacion();

			new ControladorAlta(valtasignacion, modelo);

			// Cargar los componentes desde la BD
			modelo.cargaridOfertaAlta(valtasignacion);
			modelo.cargaridDemandanteAlta(valtasignacion);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (vmenuprincipal.isActive()) {
			System.exit(0);
		}
	}
}