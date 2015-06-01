package br.com.project.sudbrain.model.dao;
import java.sql.*;
/**
 *@author Everton de Castro
 *@category
 *@since 2015/14/02
 */

public class ConnectionFactoryDAO {
	
	private final static String DRIVER_SQLITE = "org.sqlite.JDBC";
	private final static String URL_SQLITE = "jdbc:sqlite:/home/everton/git/projetos/sudbrain/database/sudbraindb";	
	
//	private final static String DRIVER = "org.postgresql.Driver";
//	private final static String URL = "jdbc:postgresql://localhost:5432/sudbraindb";
//	private static String userName = "postgres";
//	private static String password = "everton";
	
	public static Connection criaConexao(){
		Connection con = null;
		try{
			Class.forName(DRIVER_SQLITE).newInstance();
			con = DriverManager.getConnection(URL_SQLITE);
			System.out.println("Conexao criada com sucesso");	
		}catch(Exception e){
			System.out.println("Erro ao criar conexao");
			e.printStackTrace();
		}
				
		return con;
	}
	
}
