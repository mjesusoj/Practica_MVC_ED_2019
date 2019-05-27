package es.studium.mvc;

import java.awt.Choice;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	
	JPanel pnlComponentes = new JPanel();
	
	VistaAltaAsignacion()
	{
		setTitle("Alta Asignación");
		// Colocar Borde
		pnlComponentes.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Colocar el Panel
		setContentPane(pnlComponentes);
		// Llamar al layout correspondiente
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		// Aplicar el layout al panel
		pnlComponentes.setLayout(gbl_contentPane);
		
		// Se define la restricción de fecha
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		// Anchura
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		// Posiciones
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 1;
		// Añadir al panel el componente además de las restricciones
		pnlComponentes.add(lblFecha, gbc_lblFecha);
		
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.gridwidth = 2;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 1;
		pnlComponentes.add(txtFecha, gbc_txtFecha);
		// Aplicarle columnas al txtFecha
		txtFecha.setColumns(10);
		
		GridBagConstraints gbc_lblOferta = new GridBagConstraints();
		gbc_lblOferta.anchor = GridBagConstraints.EAST;
		gbc_lblOferta.insets = new Insets(0, 0, 5, 5);
		gbc_lblOferta.gridx = 1;
		gbc_lblOferta.gridy = 2;
		pnlComponentes.add(lblOferta, gbc_lblOferta);
		
		GridBagConstraints gbc_chcOferta = new GridBagConstraints();
		gbc_chcOferta.fill = GridBagConstraints.HORIZONTAL;
		gbc_chcOferta.gridwidth = 2;
		gbc_chcOferta.insets = new Insets(0, 0, 5, 5);
		gbc_chcOferta.gridx = 2;
		gbc_chcOferta.gridy = 2;
		pnlComponentes.add(chcOferta, gbc_chcOferta);
		
		GridBagConstraints gbc_lblDemandante = new GridBagConstraints();
		gbc_lblDemandante.insets = new Insets(0, 0, 5, 5);
		gbc_lblDemandante.gridx = 1;
		gbc_lblDemandante.gridy = 3;
		pnlComponentes.add(lblDemandante, gbc_lblDemandante);
		
		GridBagConstraints gbc_chcDemandante = new GridBagConstraints();
		gbc_chcDemandante.gridwidth = 2;
		gbc_chcDemandante.insets = new Insets(0, 0, 5, 5);
		gbc_chcDemandante.gridx = 2;
		gbc_chcDemandante.gridy = 3;
		pnlComponentes.add(chcDemandante, gbc_chcDemandante);
		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 4;
		pnlComponentes.add(btnAceptar, gbc_btnAceptar);
		
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 4;
		pnlComponentes.add(btnCancelar, gbc_btnCancelar);
		
		setSize(350,180);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}