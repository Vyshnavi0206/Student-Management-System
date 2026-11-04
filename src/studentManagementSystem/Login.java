package studentManagementSystem;

public class Login {
	private final String UserName="Admin";
	private final String Password="Admin@123";
	public static boolean login(String UserName,String Password) {
		return UserName.equals(UserName) && Password.equals(Password);
		
		
	}

}
