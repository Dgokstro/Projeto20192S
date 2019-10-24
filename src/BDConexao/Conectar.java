package BDConexao;



import java.sql.*;
public abstract class Conectar {
	public static String status="";
	
	public static Connection getConnection() {
		Connection cn = null;
		try{
			String banco   = "bd242702017";
			String url     = "jdbc:jtds:sqlserver://10.4.0.90:1433/" + banco;
			String usuario = "bd242702017";
			String senha   = "123456";
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection( url ,usuario , senha);
			
			status = "Conexão Aberta";
		}catch(SQLException e){
			status =  e.getMessage();
		}catch(ClassNotFoundException e){
			status =  e.getMessage();
		}catch(Exception e){
			status =  e.getMessage();
		}
		return cn;
	}

}
