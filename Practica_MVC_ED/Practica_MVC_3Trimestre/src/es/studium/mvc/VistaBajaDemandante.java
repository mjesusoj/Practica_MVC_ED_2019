package es.studium.mvc;

import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaBajaDemandante extends JFrame{

	private static final long serialVersionUID = 1L;

	JLabel elegirDemandante = new JLabel("Elegir Demandante a dar de Baja:");
	Choice chcElegir = new Choice();
	JButton btnEliminar = new JButton("Eliminar");
	JButton btnCancelar = new JButton("Cancelar");
	
	JPanel pnlChoice = new JPanel();
	JPanel pnlBotones = new JPanel();
	
	VistaBajaDemandante()
	{
		setTitle("Baja Demandante");
		setLayout(new FlowLayout());
		add(elegirDemandante);
		pnlChoice.add(chcElegir);
		chcElegir.add("Elegir uno...");
		pnlBotones.add(btnEliminar);
		pnlBotones.add(btnCancelar);
		add(pnlChoice, "Center");
		add(pnlBotones, "South");
		
		setSize(300,210);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}