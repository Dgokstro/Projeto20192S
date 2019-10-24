package BDConexao;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;
public abstract class Conectar {
	public static String status="";
	static Connection cn = null;
	public static Connection getConnection() {
		
		try{
			/*
			String banco   = "projeto20192s";
			String url     = "jdbc:mysql://localhost:3306/" + banco;
			String usuario = "dev";
			String senha   = "030294";
			*/
			Properties props = loadProperties();
			String url= props.getProperty("dburl");
			//Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection( url ,props );
			
			status = "Conexão Aberta";
		}catch(SQLException e){
			status =  e.getMessage();
		}catch(Exception e){
			status =  e.getMessage();
		}
		return cn;
	}
	public static void closeConnection() {
		if (cn !=null) {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				status =  e.getMessage();
			}
		}
	}
	
	private static Properties loadProperties() throws IOException {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw e;
		}
	}

}


/* catch(ClassNotFoundException e){
	status =  e.getMessage();
}*/
