package controllers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import config.DbConnection;
import models.ParticipationModels;

public class ParticipationController {

	DbConnection connectDb;
	 
	 Scanner scanner = new Scanner(System.in);
	
	public ParticipationController() {
		
			connectDb = new DbConnection("jdbc:mysql://localhost/talent", "root", "");
	}
	
	public void UserParti () throws SQLException {
		
		ParticipationModels partiMod = new ParticipationModels();
		
		System.out.println("Enter the User ID :");
		
		long userId = scanner.nextLong();
		
		partiMod.setUserID(userId);
		
		System.out.println("Enter the Category ID :");
			
		long categoryId = scanner.nextLong();
			
		partiMod.setCategoryID(categoryId);
			
		System.out.println("Enter the Participation Description :");
			
		String descParti = scanner.next();
			
		partiMod.setDescParti(descParti);
			
		System.out.println("Type start to Start");
			
		String test = scanner.next();
			
		LocalDateTime timeStart = LocalDateTime.now();
				
		partiMod.setTimeStart(timeStart);
			
		System.out.println("Type end to End");
			
		String test1 = scanner.next();
				
		LocalDateTime timeEnd = LocalDateTime.now();
				
		partiMod.setTimeEnd(timeEnd);
			
		String sql1 = "insert into participation (id_user, id_categorie, desc_parti, show_start_time, show_end_time, attached_file, is_accepted) values('"+ userId +"', '"+ categoryId +"', '"+ descParti +"', '"+ timeStart +"', '"+ timeEnd +"', 'test', '0')";
			
		PreparedStatement stm1 = connectDb.connec().prepareStatement(sql1);
			
		int row1 = stm1.executeUpdate();
			
			if(row1 > 0) {
				
				System.out.println("Your Praticipation is Added");
				
				String sql3 = "select * from users where id = '"+ userId +"'";
				
				Statement stm3 = connectDb.connec().createStatement();
				
				ResultSet res3 = stm3.executeQuery(sql3);
				
				while (res3.next()) {
					
					System.out.println("Your Informations are :"+res3.getString("id")+" "+res3.getString("first_name")+" "+res3.getString("last_name")+" "+res3.getString("email")+" "+res3.getString("phone"));
					
				}
			
			}
				
	}

	public void OtherParti () throws SQLException {
		
		ParticipationModels partiOth = new ParticipationModels();
		
		System.out.println("Enter the User ID :");
		
		Long userId = scanner.nextLong();
		
		partiOth.setUserID(userId);
		
		System.out.println("Enter the Category ID :");
		
		Long ctgId = scanner.nextLong();
		
		partiOth.setCategoryID(ctgId);
		
		String sql = "select * from participation where id_user = '"+ userId +"' and id_categorie = '"+ ctgId +"'";
		
		PreparedStatement stm = connectDb.connec().prepareStatement(sql);
		
		ResultSet res = stm.executeQuery();
		
		if(res.next()) {
			
			long test = res.getLong("id_user");
			
			long test1 = res.getLong("id_categorie");
			
			if(test == userId && test1 == ctgId) {
				
				System.out.println("User Already Participate in this Category");
				
			} 
		
		} else {
			
			System.out.println("Enter the Participation Description :");
			
			String descParti = scanner.next();
				
			partiOth.setDescParti(descParti);
				
			System.out.println("Type start to Start");
				
			String t = scanner.next();
				
			LocalDateTime timeStart = LocalDateTime.now();
					
			partiOth.setTimeStart(timeStart);
				
			System.out.println("Type end to End");
				
			String t1 = scanner.next();
					
			LocalDateTime timeEnd = LocalDateTime.now();
					
			partiOth.setTimeEnd(timeEnd);
				
			String sql1 = "insert into participation (id_user, id_categorie, desc_parti, show_start_time, show_end_time, attached_file, is_accepted) values('"+ userId +"', '"+ ctgId +"', '"+ descParti +"', '"+ timeStart +"', '"+ timeEnd +"', 'test', '0')";
				
			PreparedStatement stm1 = connectDb.connec().prepareStatement(sql1);
				
			int row1 = stm1.executeUpdate();
				
				if(row1 > 0) {
					
					System.out.println("You Participate in Other Category");
					
					String sql3 = "select * from users where id = '"+ userId +"'";
					
					Statement stm3 = connectDb.connec().createStatement();
					
					ResultSet res3 = stm3.executeQuery(sql3);
					
					while (res3.next()) {
						
						System.out.println("Your Informations are :"+res3.getString("id")+" "+res3.getString("first_name")+" "+res3.getString("last_name")+" "+res3.getString("email")+" "+res3.getString("phone"));
						
					}
				
				}
			
		}
		
	}
	
}
