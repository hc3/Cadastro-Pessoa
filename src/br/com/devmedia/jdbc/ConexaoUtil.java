package br.com.devmedia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoUtil {
	
	private static ResourceBundle config;

	private static ConexaoUtil conexaoUtil;
	
	private ConexaoUtil(){
		config = ResourceBundle.getBundle("config");
	}
	
	public static ConexaoUtil getInstance(){
		if(conexaoUtil == null){
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException , SQLException {
		Class.forName(config.getString("br.com.devmedia.bd.driver.mysql"));
		return DriverManager.getConnection(config.getString("br.com.devmedia.bd.url.conexao"), 
				config.getString("br.com.devmedia.bd.usuario"), config.getString("br.com.devmedia.bd.senha"));
	}

}
