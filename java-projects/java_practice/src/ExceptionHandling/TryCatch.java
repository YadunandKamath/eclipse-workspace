package ExceptionHandling;

public class TryCatch {

	public static void main(String[] args) {
		
		try{
			System.out.println("Try");
			int c = 3/0;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finally");
		}
		
	}

}
