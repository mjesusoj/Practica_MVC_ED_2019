package es.studium.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloBaja {

	public static void insertarDemandanteBaja(VistaBajaDemandante vbajademantante) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
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
				vbajademantante.chcElegir.add(idDemandante+" "+"-"+" "+nombreDemandante+" "+apellidosDemandante+" "+ "("+dniDemandante+")");
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
	
	public static void eliminarDemandante(VistaBajaDemandante informativo, VistaBajaDemandante vbajademantante) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = null;
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			String [] escogerdato = vbajademantante.chcElegir.getSelectedItem().split(" "+"-"+" "+" ");
			int idDemandante = Integer.parseInt(escogerdato[0]);
			sentencia = "DELETE FROM demandantes WHERE ('idDemandante' ='"+idDemandante+"')";
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