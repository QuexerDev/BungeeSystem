package me.ServerAPI.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	
	public static String username;
	public static String password;
	public static String database;
	public static String host;
	public static String port;
	public static Connection con;
	
	public static void Connect(){
		if(!isConnected()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database+"?autoReconnect=true", username, password);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void close(){
		if(isConnected()){
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
		public static void update(String qry){
			if(isConnected()){
				try {
					con.createStatement().executeUpdate(qry);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static ResultSet getResult(String qry){
			if(isConnected()){
				try {
					return con.createStatement().executeQuery(qry);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
			
		
	}
	
	public static boolean isConnected(){
		return con != null;
		
	}
	public static void CreateTable(){
		if(isConnected()){
		try {
			
			con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS RankAPI(UUID VARCHAR(100), Rank VARCHAR(100), end INT)");
			con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Wartungen(JA VARCHAR(100))");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		
	}

}
