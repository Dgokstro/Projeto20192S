package BDConexao;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public abstract class ControlConectar {
	public static String status="";
	static Connection cn = null;
	public static Connection getConnection() {
		
		try{
			
			Properties props = loadProperties();
			String url= props.getProperty("dburl");
			
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



