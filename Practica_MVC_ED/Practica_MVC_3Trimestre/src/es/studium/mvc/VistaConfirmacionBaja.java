package es.studium.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaConfirmacionBaja extends JFrame{
	
	private static final long serialVersionUID = 1L;

	// Componentes Diálogo
	JLabel eliminarDemandante = new JLabel();
	JButton btnSi = new JButton("Sí");
	JButton btnNo = new JButton("No");
	
	// Paneles
	JPanel panelCentral = new JPanel();
	
	VistaConfirmacionBaja()
	{
		setTitle("¿Seguro/a?");
		panelCentral.add(eliminarDemandante);
		panelCentral.add(btnSi);
		panelCentral.add(btnNo);
		add(panelCentral, BorderLayout.CENTER);
		setSize(400,100);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}