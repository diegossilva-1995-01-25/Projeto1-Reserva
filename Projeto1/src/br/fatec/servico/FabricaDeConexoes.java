package br.fatec.servico;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexoes {
	
	public Connection getConnection(){
		String url = "jdbc:mysql://localhost/sceweb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection(url,"root","alunofatec");
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}
