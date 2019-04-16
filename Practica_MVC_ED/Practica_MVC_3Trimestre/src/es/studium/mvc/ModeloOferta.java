package es.studium.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloOferta {

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	static String login = "root";
	static String password = "Studium2018;";

	public static void cargarOferta(VistaModificacionOferta vmodoferta) {

		String sentencia = "SELECT * FROM ofertas;";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
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
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}

	public static void cargarcomponentesEdicion(VistaEdicionOferta vedicionoferta, VistaModificacionOferta vmodoferta) {
		String [] oferta = vmodoferta.chcElegir.getSelectedItem().split("-" + " ");  
		String [] escoger = vmodoferta.chcElegir.getSelectedItem().split(" ");  
		String fechaFinOferta = escoger[3].replace("|", "");
		
		// Introducir lo seleccionado en los componentes de edición
		vedicionoferta.oferta.setText("Oferta:" + " " + oferta[0]);
		vedicionoferta.txtFecha.setText(escoger[2]);
		vedicionoferta.txtFechaFin.setText(fechaFinOferta);
		vedicionoferta.txtRequisitos.setText(escoger[5]);
	}
}