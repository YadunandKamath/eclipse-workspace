
public class VariablesUsage {

	public static void main(String[] args) {
			
		int i = 1000;
		byte b = 127;
		char c = 'x';
		float f = 43.4343f;
		double d = 76.987678;
		boolean bo = true;
		 
		System.out.println("int = " + i + "\nbyte = " + b + "\nchar = " + c + "\nfloat = " + f + "\ndouble = " + d 
				+ "\nboolean = " + bo);
		
		System.out.printf("int + byte = %d\n",i+b);
		System.out.printf("int + float = %f\n",i+f);
		System.out.printf("float + double = %f\n",f+d);
		System.out.println("char + char = "+ c + c);
		
	}

}
