package es.studium.mvc;

import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaModificacionOferta extends JFrame{

	private static final long serialVersionUID = 1L;

	JLabel lblOferta = new JLabel("Elegir Oferta a Editar:");
	Choice chcElegir = new Choice();
	JButton btnEditar = new JButton("Editar");
	JButton btnCancelar = new JButton("Cancelar");
	
	VistaModificacionOferta()
	{
		setTitle("Modificación Oferta");
		setLayout(new FlowLayout());
		add(lblOferta);
		add(chcElegir);
		add(btnEditar);
		add(btnCancelar);
		setSize(300,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}