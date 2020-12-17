package models;

public class AdminModels extends UsersModels{

	private String pass;
	
	public AdminModels (long id, String firstName, String lastName, String email, int phone, String pass) {
		
		super(id, firstName, lastName, email, phone);
		
		this.pass = pass;
		
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "AdminModels [pass=" + pass + "]";
	}
	
	public AdminModels () {
		
	}
	
}
