package es.studium.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	
	public void insertarDemandanteBaja(VistaBajaDemandante vbajademandante) {
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
	
	public void demandanteaeliminar(VistaBajaDemandante vbajademandante, VistaConfirmacionBaja vconfirmarbaja) {
		if (vbajademandante.chcElegir.getSelectedItem().equals("Elige uno...")) {
			System.out.println("No puede escoger ese elemento");
		}
		
		String[] demandanteelegido = vbajademandante.chcElegir.getSelectedItem().split(" "+"-"+" ");
		String demandante = (demandanteelegido[1]);
		// Guardar en el label el cliente que se ha seleccionado.
		vconfirmarbaja.eliminarDemandante.setText("¿Seguro/a de eliminar a" + " " + demandante +"?");
	} 
	
	public void eliminarDemandante(VistaBajaDemandante vbajademandante, VistaConfirmacionBaja vconfirmarbaja) {
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String [] escogerdato = vbajademandante.chcElegir.getSelectedItem().split(" "+"-"+" ");
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
	
	public void cargarOferta(VistaModificacionOferta vmodoferta) {
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

	public void cargarcomponentesEdicion(VistaEdicionOferta vedicionoferta, VistaModificacionOferta vmodoferta) {
		String [] oferta = vmodoferta.chcElegir.getSelectedItem().split("-" + " ");  
		String [] escoger = vmodoferta.chcElegir.getSelectedItem().split(" ");  
		String fechaFinOferta = escoger[3].replace("|", "");
		
		// Introducir lo seleccionado en los componentes de edición
		vedicionoferta.oferta.setText("Oferta:" + " " + oferta[0]);
		vedicionoferta.txtFecha.setText(escoger[2]);
		vedicionoferta.txtFechaFin.setText(fechaFinOferta);
		vedicionoferta.txtRequisitos.setText(escoger[5]);
	}
	
	public Object[][] rellenarTabla() {
		
		String sentencia = "SELECT * FROM ofertas;";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();						
			rs = statement.executeQuery(sentencia);
			
			while (rs.next()) {
				int idCliente = rs.getInt("idCliente");
				String numDemandantes = rs.getString("numDemandantes");
				String fechaFin = rs.getString("fechaFin");

				Object [][] datosFilaFinal= {
						{idCliente, numDemandantes, fechaFin}
				};

				return datosFilaFinal;
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
		return null;
	}
	
	public void cargaridOfertaAlta(VistaAltaAsignacion valtasignacion) {

		String sentencia = "SELECT idOferta FROM ofertas;";
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
			
			valtasignacion.chcOferta.add("Elegir uno...");
			
			while (rs.next())
			{
				int idOferta = rs.getInt("idOferta");
				valtasignacion.chcOferta.add(idOferta+"");
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
	
	public void cargaridDemandanteAlta(VistaAltaAsignacion valtasignacion) {

		String sentencia = "SELECT idDemandante FROM demandantes;";
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

			valtasignacion.chcDemandante.add("Elegir uno...");
			
			while (rs.next())
			{
				int idDemandante = rs.getInt("idDemandante");
				valtasignacion.chcDemandante.add(idDemandante+"");
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
	
	public void insertarasignacion(VistaAltaAsignacion valtasignacion) {
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
			statement.executeUpdate("INSERT INTO asignaciones VALUES(NULL, '"+fechamericana()+"', '"+valtasignacion.chcOferta.getSelectedItem()+"', '"+valtasignacion.chcDemandante.getSelectedItem()+"');");
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
	
	public static String fechaactual() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha= dateFormat.format(date);
		
		return fecha;
	}
	
	public String fechamericana() {
		Date date = new Date();
		DateFormat dateFormatAmerican = new SimpleDateFormat("yyyy/MM/dd");
		String fechamericana = dateFormatAmerican.format(date);
		
		return fechamericana;
	}
}