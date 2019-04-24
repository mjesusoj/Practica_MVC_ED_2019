package es.studium.mvc;

import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaAltaAsignacion extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JLabel lblFecha = new JLabel("Fecha:");
	JLabel lblOferta = new JLabel("Oferta:");
	JLabel lblDemandante = new JLabel("Demandante:");
	
	JTextField txtFecha = new JTextField(Modelo.fechaactual(), 15);
	
	Choice chcOferta = new Choice();
	Choice chcDemandante = new Choice();	
	
	JButton btnAceptar = new JButton("Aceptar");
	JButton btnCancelar = new JButton("Cancelar");
	
	JPanel pnlFecha = new JPanel();
	JPanel pnlOferta = new JPanel();
	JPanel pnlDemandante = new JPanel();
	JPanel pnlInferior = new JPanel();
	
	VistaAltaAsignacion()
	{
		setTitle("Alta Asignación");
		setLayout(new FlowLayout());
		pnlFecha.add(lblFecha);
		pnlFecha.add(txtFecha);
		// Impedir que se edite
		txtFecha.setEditable(false);
		pnlOferta.add(lblOferta);
		pnlOferta.add(chcOferta);
		pnlDemandante.add(lblDemandante);
		pnlDemandante.add(chcDemandante);
		pnlInferior.add(btnAceptar);
		pnlInferior.add(btnCancelar);
		add(pnlFecha);
		add(pnlOferta);
		add(pnlDemandante);
		add(pnlInferior, "South");
		setSize(300,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}