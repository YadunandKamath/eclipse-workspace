package PredicateInterface;

import java.util.Scanner;
import java.util.function.Predicate;

class User {
	
	String username;
	String pwd;
	public User(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}
	
}

public class UserAuthentication {

	public static void main(String[] args) {
		
		Predicate<User> p = u -> u.username.equalsIgnoreCase("durga") && u.pwd.equalsIgnoreCase("java");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username: ");
		String uname = sc.next();
		System.out.println("Enter password: ");
		String pwd = sc.next();
		
		User u = new User(uname, pwd);
		if(p.test(u)) {
			System.out.println("Valid User");
		}
		else {
			System.out.println("Invalid User");
		}

	}

}
