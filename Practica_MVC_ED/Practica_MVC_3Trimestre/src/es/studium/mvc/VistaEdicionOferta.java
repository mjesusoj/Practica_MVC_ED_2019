package es.studium.mvc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	
	VistaEdicionOferta()
	{
		setTitle("Edición Oferta");
		
		pnlSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlSuperior);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlSuperior.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_lblOfertaXxx = new GridBagConstraints();
		gbc_lblOfertaXxx.insets = new Insets(0, 0, 5, 0);
		gbc_lblOfertaXxx.gridx = 2;
		gbc_lblOfertaXxx.gridy = 0;
		pnlSuperior.add(oferta, gbc_lblOfertaXxx);

		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, -100, 0, 30);
		gbc_lblFecha.gridx = 2;
		gbc_lblFecha.gridy = 1;
		pnlSuperior.add(fecha, gbc_lblFecha);
		
		GridBagConstraints gbc_txtHola = new GridBagConstraints();
		gbc_txtHola.insets = new Insets(0, 0, 5, 0);
		gbc_txtHola.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHola.gridx = 3;
		gbc_txtHola.gridy = 1;
		pnlSuperior.add(txtFecha, gbc_txtHola);
		txtFecha.setColumns(10);
		
		GridBagConstraints gbc_lblFechaFin = new GridBagConstraints();
		gbc_lblFechaFin.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFin.insets = new Insets(0, -100, 0, 30);
		gbc_lblFechaFin.gridx = 2;
		gbc_lblFechaFin.gridy = 2;
		pnlSuperior.add(fechaFin, gbc_lblFechaFin);
		
		GridBagConstraints gbc_txtEee = new GridBagConstraints();
		gbc_txtEee.insets = new Insets(0, 0, 5, 0);
		gbc_txtEee.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEee.gridx = 3;
		gbc_txtEee.gridy = 2;
		pnlSuperior.add(txtFechaFin, gbc_txtEee);
		txtFechaFin.setColumns(10);
		
		GridBagConstraints gbc_lblRequisitos = new GridBagConstraints();
		gbc_lblRequisitos.insets = new Insets(0, 0, 5, 5);
		gbc_lblRequisitos.gridx = 2;
		gbc_lblRequisitos.gridy = 3;
		pnlSuperior.add(requisitos, gbc_lblRequisitos);
		
		GridBagConstraints gbc_txtG = new GridBagConstraints();
		gbc_txtG.insets = new Insets(0, 0, 5, 0);
		gbc_txtG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtG.gridx = 3;
		gbc_txtG.gridy = 3;
		pnlSuperior.add(txtRequisitos, gbc_txtG);
		txtRequisitos.setColumns(10);
		
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizar.gridx = 2;
		gbc_btnActualizar.gridy = 4;
		pnlSuperior.add(btnActualizar, gbc_btnActualizar);
		
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 4;
		pnlSuperior.add(btnCancelar, gbc_btnCancelar);
		
		setSize(270,200);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}
}