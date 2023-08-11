
public class Loops {

	public static void main(String[] args) {
		
		// print 1 to 10 using do-while
		int x=1;
		do {
			System.out.println(x);
			x++;
		}while(x<11);
		
		// star pattern using for loop
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}

	}

}
