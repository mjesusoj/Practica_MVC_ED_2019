package es.studium.mvc;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaModificacionOferta extends JFrame{

	private static final long serialVersionUID = 1L;

	JLabel lblOferta = new JLabel("Elegir Oferta a Editar:");
	Choice chcElegir = new Choice();
	JButton btnEditar = new JButton("Editar");
	JButton btnCancelar = new JButton("Cancelar");
	
	JPanel pnlSuperior = new JPanel();
	JPanel pnlChoice = new JPanel();
	JPanel pnlInferior = new JPanel();
	
	VistaModificacionOferta()
	{
		setTitle("Modificación Oferta");
		setLayout(new FlowLayout());
		pnlSuperior.add(lblOferta);
		pnlChoice.add(chcElegir);
		pnlInferior.add(btnEditar);
		pnlInferior.add(btnCancelar);
		add(pnlSuperior, BorderLayout.NORTH);
		add(pnlChoice, BorderLayout.CENTER);
		add(pnlInferior, BorderLayout.SOUTH);
		setSize(300,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}