package es.studium.mvc;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaConfirmacionBaja extends JFrame{
	
	private static final long serialVersionUID = 1L;

	// Componentes Diálogo
	JLabel eliminarDemandante = new JLabel("¿Seguro/a de eliminar a XXXXXXXX?");
	JButton btnSi = new JButton("Sí");
	JButton btnNo = new JButton("No");
	
	VistaConfirmacionBaja()
	{
		setTitle("¿Seguro/a?");
		setLayout(new FlowLayout());
		add(eliminarDemandante);
		add(btnSi);
		add(btnNo);
		setSize(250,150);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}