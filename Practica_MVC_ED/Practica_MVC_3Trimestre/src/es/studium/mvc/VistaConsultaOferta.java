package es.studium.mvc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaConsultaOferta extends JFrame{

	private static final long serialVersionUID = 1L;

	JTable tabla = new JTable();
	
	JButton btnAceptar = new JButton("Aceptar");
	
	VistaConsultaOferta()
	{
		setTitle("Consulta Ofertas");
		setLayout(new FlowLayout());
		// Añadir la tabla y pasarle como parámetros el método que coge datos de la BD
		tabla = new JTable(Modelo.rellenarTabla(), nombreColumnas);
		// Añadir el modelo de la tabla
		tabla.setModel(Modelo.modelotabla);
		// Añadir un Panel de Scroll al centro
		add(new JScrollPane(tabla), BorderLayout.CENTER);
		add(btnAceptar);
		setSize(500,550);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private String [] nombreColumnas= {};
}