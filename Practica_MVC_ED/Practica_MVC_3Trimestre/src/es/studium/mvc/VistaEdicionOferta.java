package es.studium.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaEdicionOferta extends JFrame{

	private static final long serialVersionUID = 1L;

	JLabel oferta = new JLabel();
	JLabel fecha = new JLabel("Fecha:");
	JLabel fechaFin = new JLabel("Fecha Fin:");
	JLabel requisitos = new JLabel("Requisitos:");

	JTextField txtFecha = new JTextField(15);
	JTextField txtFechaFin = new JTextField(15);
	JTextField txtRequisitos = new JTextField(15);
	
	JButton btnActualizar = new JButton("Actualizar");
	JButton btnCancelar = new JButton("Cancelar");
	
	JPanel pnlSuperior = new JPanel();
	JPanel pnlCentral = new JPanel();
	JPanel pnlInferior = new JPanel();
	
	VistaEdicionOferta()
	{
		setTitle("Edición Oferta");
		pnlSuperior.add(oferta);
		pnlCentral.add(fecha);
		pnlCentral.add(txtFecha);
		pnlCentral.add(fechaFin);
		pnlCentral.add(txtFechaFin);
		pnlCentral.add(requisitos);
		pnlCentral.add(txtRequisitos);
		pnlInferior.add(btnActualizar);
		pnlInferior.add(btnCancelar);
		add(pnlSuperior, BorderLayout.NORTH);
		add(pnlCentral, BorderLayout.CENTER);
		add(pnlInferior, "South");
		setSize(270,200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}