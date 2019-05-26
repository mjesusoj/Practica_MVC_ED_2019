package es.studium.mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VistaxD extends JFrame {

	private JPanel contentPane;
	private JTextField txtHola;
	private JTextField txtEee;
	private JTextField txtG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaxD frame = new VistaxD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaxD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 42, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblOfertaXxx = new JLabel("Oferta: XXX");
		GridBagConstraints gbc_lblOfertaXxx = new GridBagConstraints();
		gbc_lblOfertaXxx.insets = new Insets(0, 0, 5, 5);
		gbc_lblOfertaXxx.gridx = 3;
		gbc_lblOfertaXxx.gridy = 0;
		contentPane.add(lblOfertaXxx, gbc_lblOfertaXxx);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, -100, 0, 30);
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.gridx = 3;
		gbc_lblFecha.gridy = 1;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		txtHola = new JTextField();
		txtHola.setText("hola");
		GridBagConstraints gbc_txtHola = new GridBagConstraints();
		gbc_txtHola.insets = new Insets(0, 0, 5, 0);
		gbc_txtHola.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHola.gridx = 4;
		gbc_txtHola.gridy = 1;
		contentPane.add(txtHola, gbc_txtHola);
		txtHola.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		GridBagConstraints gbc_lblFechaFin = new GridBagConstraints();
		gbc_lblFechaFin.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFin.gridx = 3;
		gbc_lblFechaFin.gridy = 2;
		contentPane.add(lblFechaFin, gbc_lblFechaFin);
		
		txtEee = new JTextField();
		txtEee.setText("eee");
		GridBagConstraints gbc_txtEee = new GridBagConstraints();
		gbc_txtEee.insets = new Insets(0, 0, 5, 0);
		gbc_txtEee.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEee.gridx = 4;
		gbc_txtEee.gridy = 2;
		contentPane.add(txtEee, gbc_txtEee);
		txtEee.setColumns(10);
		
		JLabel lblRequisitos = new JLabel("Requisitos:");
		GridBagConstraints gbc_lblRequisitos = new GridBagConstraints();
		gbc_lblRequisitos.insets = new Insets(0, 0, 5, 5);
		gbc_lblRequisitos.gridx = 3;
		gbc_lblRequisitos.gridy = 3;
		contentPane.add(lblRequisitos, gbc_lblRequisitos);
		
		txtG = new JTextField();
		txtG.setText("g");
		GridBagConstraints gbc_txtG = new GridBagConstraints();
		gbc_txtG.insets = new Insets(0, 0, 5, 0);
		gbc_txtG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtG.gridx = 4;
		gbc_txtG.gridy = 3;
		contentPane.add(txtG, gbc_txtG);
		txtG.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizar.gridx = 3;
		gbc_btnActualizar.gridy = 4;
		contentPane.add(btnActualizar, gbc_btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 4;
		contentPane.add(btnCancelar, gbc_btnCancelar);
	}

}
