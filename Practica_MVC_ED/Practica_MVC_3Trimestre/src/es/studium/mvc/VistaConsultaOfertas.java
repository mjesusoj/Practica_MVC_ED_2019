package es.studium.mvc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaConsultaOfertas extends JFrame{

	private static final long serialVersionUID = 1L;

	JButton btnAceptar = new JButton("Aceptar");
	
	VistaConsultaOfertas()
	{
		setTitle("Consulta Ofertas");
		setLayout(new FlowLayout());
		JTable tabla = new JTable(datosFila, nombreColumnas);
		add(new JScrollPane(tabla), BorderLayout.CENTER);
		add(btnAceptar);
		setSize(500,200);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private String [] nombreColumnas= {"Oferta", "Nº Demandantes Asignados", "Fecha Fin"};
	
	private Object [][] datosFila={
		{"Hola", 21211, 0, false},
		{"Pepe", 20321, 1, true}
	};
}