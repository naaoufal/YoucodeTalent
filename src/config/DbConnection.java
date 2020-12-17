package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private String url;
	private String username;
	private String pass;
	
	public DbConnection() {
		
	}

	public DbConnection(String url, String username, String pass) {
		// TODO Auto-generated constructor stub
		this.url = url;
		this.username = username;
		this.pass = pass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Connection connec () throws SQLException {
		
		Connection connect = DriverManager.getConnection(this.url,this.username,this.pass);
		
		return connect;
		
	}
		
}
