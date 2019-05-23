package es.studium.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Modelo {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	static String login = "root";
	static String password = "Studium2018;";
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet rs = null;
	
	public void insertarDemandanteBaja(VistaBajaDemandante vbajademandante) {
		String sentencia = "SELECT idDemandante, nombreDemandante, apellidosDemandante, dniDemandante FROM demandantes;";
		
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				int idDemandante = rs.getInt("idDemandante");
				String nombreDemandante = rs.getString("nombreDemandante");
				String apellidosDemandante = rs.getString("apellidosDemandante");
				String dniDemandante = rs.getString("dniDemandante");
				vbajademandante.chcElegir.add(idDemandante+" "+"-"+" "+nombreDemandante+" "+apellidosDemandante+" "+ "("+dniDemandante+")");
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		desconectar();
	}
	
	public void demandanteaeliminar(VistaBajaDemandante vbajademandante, VistaConfirmacionBaja vconfirmarbaja) {
		if (vbajademandante.chcElegir.getSelectedItem().equals("Elige uno...")) {
			System.out.println("No puede escoger ese elemento");
		}
		
		String[] demandanteelegido = vbajademandante.chcElegir.getSelectedItem().split(" "+"-"+" ");
		String demandante = (demandanteelegido[1]);
		// Guardar en el label el cliente que se ha seleccionado.
		vconfirmarbaja.eliminarDemandante.setText("�Seguro/a de eliminar a" + " " + demandante +"?");
	} 
	
	public void eliminarDemandante(VistaBajaDemandante vbajademandante, VistaConfirmacionBaja vconfirmarbaja) {
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String [] escogerdato = vbajademandante.chcElegir.getSelectedItem().split(" "+"-"+" ");
			int idDemandante = Integer.parseInt(escogerdato[0]);
			statement.executeUpdate("DELETE FROM demandantes WHERE idDemandante = '"+idDemandante+"';");
		}
		
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		desconectar();
	}
	
	public void cargarOferta(VistaModificacionOferta vmodoferta) {
		String sentencia = "SELECT idOferta, DATE_FORMAT(fechaOferta,'%d/%m/%Y') AS 'fechaOferta', "
				+ "DATE_FORMAT(fechaFinOferta,'%d/%m/%Y') AS 'fechaFinOferta', requisitosOferta FROM ofertas;";
		
		try
		{
			Class.forName(driver);
			//Establecer la conexi�n con la BD
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
			rs = statement.executeQuery(sentencia);
			vmodoferta.chcElegir.add("Elegir uno...");
			while (rs.next())
			{
				int idOferta = rs.getInt("idOferta");
				String fechaOferta = rs.getString("fechaOferta");
				String fechaFinOferta = rs.getString("fechaFinOferta");
				String requisitosOferta = rs.getString("requisitosOferta");
				vmodoferta.chcElegir.add(idOferta + " " + "-" + " " + fechaOferta + " " + "|" + fechaFinOferta + " " + "|" + " " + requisitosOferta);
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		desconectar();
	}

	public void cargarcomponentesEdicion(VistaEdicionOferta vedicionoferta, VistaModificacionOferta vmodoferta) {
		String [] oferta = vmodoferta.chcElegir.getSelectedItem().split("-" + " ");  
		String [] escoger = vmodoferta.chcElegir.getSelectedItem().split(" ");  
		String fechaFinOferta = escoger[3].replace("|", "");
		
		// Introducir lo seleccionado en los componentes de edici�n
		vedicionoferta.oferta.setText("Oferta:" + " " + oferta[0]);
		vedicionoferta.txtFecha.setText(escoger[2]);
		vedicionoferta.txtFechaFin.setText(fechaFinOferta);
		vedicionoferta.txtRequisitos.setText(escoger[5]);
	}
	
	public static void modificarcamposEdicion(VistaEdicionOferta vedicionoferta) {
		String[] oferta = vedicionoferta.oferta.getText().split(":" + " ");
		String idOferta = oferta[1];
		
		String[] escogerfechaOferta = vedicionoferta.txtFecha.getText().split("/");
		String fechaOferta = escogerfechaOferta[2] + "-" + escogerfechaOferta[1] + "-" + escogerfechaOferta[0];
		
		String[] escogerfechaFinOferta = vedicionoferta.txtFechaFin.getText().split("/");
		String fechaFinOferta = escogerfechaFinOferta[2] + "-" + escogerfechaFinOferta[1] + "-" + escogerfechaFinOferta[0];
		
		String sentencia = "UPDATE ofertas SET fechaOferta= '"+fechaOferta+"' , "
				+ "fechaFinOferta= '"+fechaFinOferta+"', "
						+ "requisitosOferta= '"+vedicionoferta.txtRequisitos.getText()+"' "
								+ "WHERE idOferta = '"+idOferta+"';";
		
		try 
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();						
			statement.executeUpdate(sentencia);
		}

		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}

		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}

		desconectar();
	}
	
	public static Object[][] rellenarTabla() {
		String sentencia = "SELECT idOferta AS 'Oferta', COUNT(idDemandanteFK) AS 'N� Demandantes Asignados', "
				+ "DATE_FORMAT(fechaFinOferta,'%d/%m/%Y') AS 'Fecha Fin'\r\n" + 
				"FROM ofertas, asignaciones\r\n" + 
				"WHERE ofertas.idOferta = asignaciones.idDemandanteFK\r\n" + 
				"ORDER BY 1;";

		try 
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();						
			rs = statement.executeQuery(sentencia);
			
			ResultSetMetaData rsMd = rs.getMetaData();
			// Guardar en una variable las columnas que hay
			int cantidadColumnas = rsMd.getColumnCount();

			// Bucle para ir de 1 hasta las columnas que existen
			for (int i=1;i<=cantidadColumnas;i++) {
				// A�adir los t�tulos de las columnas
				VistaConsultaOferta.modelo.addColumn(rsMd.getColumnLabel(i));
			}

			while (rs.next()) {
				Object [] fila = new Object[cantidadColumnas];
				for (int i=0;i<cantidadColumnas;i++) {
					// Coger los objetos de la bd	
					fila[i] = rs.getObject(i+1);
				}
				// A�adir las columnas
				VistaConsultaOferta.modelo.addRow(fila);
			}
		}

		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}

		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}

		desconectar();
		return null;
	}
	
	public void cargaridOfertaAlta(VistaAltaAsignacion valtasignacion) {
		String sentencia = "SELECT * FROM ofertas;";

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
			rs = statement.executeQuery(sentencia);
			valtasignacion.chcOferta.add("Elegir uno...");
			
			while (rs.next())
			{
				int idOferta = rs.getInt("idOferta");
				String requisitosOferta = rs.getString("requisitosOferta");
				valtasignacion.chcOferta.add(idOferta +" " + requisitosOferta);
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		desconectar();
	}
	
	public void cargaridDemandanteAlta(VistaAltaAsignacion valtasignacion) {
		String sentencia = "SELECT * FROM demandantes;";

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			valtasignacion.chcDemandante.add("Elegir uno...");
			
			while (rs.next())
			{
				int idDemandante = rs.getInt("idDemandante");
				String nombreDemandante = rs.getString("nombreDemandante");
				String apellidosDemandante = rs.getString("apellidosDemandante");
				String dniDemandante = rs.getString("dniDemandante");
				valtasignacion.chcDemandante.add(idDemandante+" " + nombreDemandante + " " + apellidosDemandante + " " + dniDemandante);
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		desconectar();
	}
	
	public void insertarasignacion(VistaAltaAsignacion valtasignacion){
		String [] elegir = valtasignacion.chcDemandante.getSelectedItem().split(" ");
		String [] elegiridOferta = valtasignacion.chcOferta.getSelectedItem().split(" ");
		
		String idDemandante = elegir[0];
		String idOferta = elegiridOferta[0];

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			// Realizar la actualizaci�n
			statement.executeUpdate("INSERT INTO asignaciones VALUES(NULL, '"+fechamericana(valtasignacion)+"', '"+idOferta+"', '"+idDemandante+"');");
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		desconectar();
	}
	
	public static void desconectar() {
		try
		{
			if(connection!=null)
			{
				connection.close();
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "No se puede cerrar la conexi�n con la BD", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static String fechaactual() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha= dateFormat.format(date);
		return fecha;
	}
	
	public static String fechamericana(VistaAltaAsignacion valtasignacion){
		String fecha = valtasignacion.txtFecha.getText();
		String quitarbarra [] = fecha.split("/");
		String fechamericana = quitarbarra[2] + "-" + quitarbarra[1] + "-" + quitarbarra[0];
		return fechamericana;
	}
}