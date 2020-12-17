package main;
import java.util.Scanner;
import controllers.ParticipationController;
import controllers.UserController;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			int input;
			
			Scanner scanner = new Scanner(System.in);
			
			do {
				
				System.out.println("########## Menu ##########");
				
				System.out.println("1 - New User Registration :");
				
				System.out.println("2 - Admin Session :");
				
				System.out.println("Enter a menu number :");
				
				input = scanner.nextInt();
				
				switch (input) {
				
				case 1:
					
					UserController user = new UserController();
					
					user.UserCon();
					
					int inp = 0;
					
					
					do {
						
						System.out.println("1 - Make a new Participation :");
						
						System.out.println("2 - Make another Participaiton :");
						
						System.out.println("3 - Show Category Information :");
						
						System.out.println("4 - Update User Informations :");
						
						System.out.println("5 - Exit");
						
						System.out.println(" Enter a number :");
						
						inp = scanner.nextInt();
						
						switch (inp) {
						case 1:
							
							ParticipationController partiCon = new ParticipationController();
							
							partiCon.UserParti();
							
							break;
							
						case 2 :
							
							ParticipationController partiOth = new ParticipationController();
							
							partiOth.OtherParti();
							
							break;
							
						case 3 :
							
							UserController userSh = new UserController();
							
							userSh.ShowCatgory();
							
							break;
							
						case 4 :
							
							UserController userUpd = new UserController();
							
							userUpd.UpdateUser();

						default:
							
							break;
						}
						
					} while (inp != 5);
					
					break;

				default:
					
					break;
				}
				
			} while (input != 3);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}

	}

}
