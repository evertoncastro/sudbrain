package br.com.project.sudbrain.model.dao;
import java.sql.*;
/**
 *@author Everton de Castro
 *@category
 *@since 2015/14/02
 */

public class ConnectionFactoryDAO {
	
	
	private final static String DRIVER = "org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost:5432/sudbraindb";
	private static String userName = "postgres";
	private static String password = "jessica";
	
	public static Connection criaConexao(){
		Connection con = null;
		try{
			Class.forName(DRIVER).newInstance();
			con = DriverManager.getConnection(URL, userName, password);
			System.out.println("Conex�o criada com sucesso");
		}catch(Exception e){
			System.out.println("Erro ao criar conex�o");
			e.printStackTrace();
		}
				
		return con;
	}
	
}
