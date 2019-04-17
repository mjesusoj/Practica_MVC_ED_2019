package es.studium.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloBaja {

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	static String login = "root";
	static String password = "Studium2018;";
	
	public static void insertarDemandanteBaja(VistaBajaDemandante vbajademandante) {
		String sentencia = "SELECT idDemandante, nombreDemandante, apellidosDemandante, dniDemandante FROM demandantes;";
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
	
	public static void demandanteaeliminar(VistaBajaDemandante vbajademandante, VistaConfirmacionBaja vconfirmarbaja) {
		String[] demandanteelegido = vbajademandante.chcElegir.getSelectedItem().split(" "+"-"+" ");
		String demandante = (demandanteelegido[1]);
		// Guardar en el label el cliente que se ha seleccionado.
		vconfirmarbaja.eliminarDemandante.setText("¿Seguro/a de eliminar a" + " " + demandante +"?");
	} 
	
	public static void eliminarDemandante(VistaBajaDemandante vbajademantante) {
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String [] escogerdato = vbajademantante.chcElegir.getSelectedItem().split(" "+"-"+" ");
			int idDemandante = Integer.parseInt(escogerdato[0]);
			System.out.println(idDemandante);
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
}