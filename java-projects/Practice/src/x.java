import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class x {
	
	public static <T> void print(T[] arr) {
		for(T ele:arr) {
			System.out.println(ele+"");
		}
	}
 	
	public static void main(String[] args) {
		
//		byte x=127;
//		x++;
//		System.out.println(x);
//		x++;
//		System.out.println(x);
//		String str = "abcde";
//		String str2 = "kjh";
//		System.out.println(str.concat(str2));
//		
//		int array [] = new int [5];
//        for (int i = 5; i > 0; i--)
//            array[5-i] = i;
//        Arrays.fill(array, 1, 4, 8);
//        for (int i = 0; i < 5; i++)
//            System.out.print(array[i]);

//		StringBuffer s = new StringBuffer("Hello");
//		s.deleteCharAt(0);
//	System.out.println(s);
		
		Integer[] arr1 = {100,400};
		Double[] arr2 = {300.0,500.0};
		Character[] arr3 = {'D','E','M','O'};
		
		print(arr1);
		print(arr2);
		print(arr3);

	}
//	public static synchronized void main (String [] args) throws  InterruptedException {  
//		     Thread f = new Thread ();  
//		      f. start ();  
//		      System.out.print("A");  
//		      f. wait (1000);  
//		      System.out.print("B");  
//	}  


}
