package es.studium.mvc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaConsultaOferta extends JFrame{

	private static final long serialVersionUID = 1L;

	JTable tabla = new JTable();
	
	JButton btnAceptar = new JButton("Aceptar");
	
	static DefaultTableModel modelo = new DefaultTableModel();
	
	VistaConsultaOferta()
	{
		setTitle("Consulta Ofertas");
		setLayout(new FlowLayout());
		tabla = new JTable(Modelo.rellenarTabla(), nombreColumnas);
		tabla.setModel(modelo);
		add(new JScrollPane(tabla), BorderLayout.CENTER);
		add(btnAceptar);
		setSize(500,550);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private String [] nombreColumnas= {};
}