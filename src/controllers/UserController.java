package controllers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import config.DbConnection;
import models.UsersModels;

public class UserController {
		
	DbConnection connectDb;
	 
	 Scanner scanner = new Scanner(System.in);
	 
	public UserController() {
		
			connectDb = new DbConnection("jdbc:mysql://localhost/talent", "root", "");
	}
	
	public void UserCon () throws SQLException {
		
		UsersModels userCon = new UsersModels();
		
		long userId = (long)(Math.random()* 100000000);
		
		userCon.setId(userId);
		
		System.out.println("Enter the first name :");
		
		String userFirst = scanner.next();
		
		userCon.setFirstName(userFirst);
		
		System.out.println("Enter the last name :");
		
		String userLast = scanner.next();
		
		userCon.setLastName(userLast);
		
		System.out.println("Enter the email :");
		
		String userEmail = scanner.next();
		
		userCon.setEmail(userEmail);
		
		System.out.println("Enter the phone number :");
		
		int userPhone = scanner.nextInt();
		
		userCon.setPhone(userPhone);
		
		String sql = "insert into users (id, first_name, last_name, email, phone) values ('"+ userId +"', '"+ userFirst +"', '"+ userLast +"', '"+ userEmail +"', '"+ userPhone +"')";
				
		PreparedStatement stm = connectDb.connec().prepareStatement(sql);
		
		int rows = stm.executeUpdate();
		
		if(rows > 0) {
			
			System.out.println("User Added Successfully");

		}
		
		String sql2 = "select * from users where id = '"+ userId +"'";
		
		Statement stm2 = connectDb.connec().createStatement();
		
		ResultSet res = stm2.executeQuery(sql2);
		
		while(res.next()) {
			
			System.out.println("Your Informations are : " + res.getLong("id")+" "+res.getString("first_name")+" "+res.getString("last_name")+" "+res.getString("email")+" "+res.getString("phone"));
			
		}
		
	}
	
	public void ShowCatgory () throws SQLException {
		
		String sql = "select * from categorie";
		
		Statement stm = connectDb.connec().createStatement();
		
		ResultSet res = stm.executeQuery(sql);
		
		while (res.next()) {
			
			System.out.println(res.getString("id_categorie")+" "+res.getString("name_categorie"));
			
		}
		
	}
	
	public void UpdateUser () throws SQLException {
		
		System.out.println("Enter the User ID to Update :");
		
		long idScan = scanner.nextLong();
		
		System.out.println("Enter the first name :");
		
		String firstName = scanner.next();
		
		System.out.println("Enter the last name :");
		
		String lastName = scanner.next();
		
		System.out.println("Enter the email :");
		
		String email = scanner.next();
		
		System.out.println("Enter the phone number :");
		
		int phoneNum = scanner.nextInt();
		
		String sql = "update users set first_name = '"+ firstName +"', last_name = '"+ lastName +"', email = '"+ email +"', phone = '"+ phoneNum +"' where id = '"+ idScan +"'";
		
		PreparedStatement stm = connectDb.connec().prepareStatement(sql);
		
		int res = stm.executeUpdate(sql);
		
		if(res > 0) {
			
			System.out.println("User Updated Successfully");
			
		}
		
		String sql2 = "select * from users where id = '"+ idScan +"'";
		
		Statement stm2 = connectDb.connec().createStatement();
		
		ResultSet res1 = stm2.executeQuery(sql2);
		
		while(res1.next()) {
			
			System.out.println("Your Informations are : " + res1.getLong("id")+" "+res1.getString("first_name")+" "+res1.getString("last_name")+" "+res1.getString("email")+" "+res1.getString("phone"));
			
		}
		
		connectDb.connec().close();
		
	}
}
