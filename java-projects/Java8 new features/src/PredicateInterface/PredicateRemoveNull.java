package PredicateInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateRemoveNull {

	public static void main(String[] args) {
		
		String[] names = {"Durga","",null,"Ravi","","Shiva",null};
		List<String> l = new ArrayList<>();

		Predicate<String> p = s -> s!=null && s.length()>0; 
		
		System.out.println("List of strings that are not empty and null: ");
		for(String s:names) {
			if(p.test(s)) {
					l.add(s);
			}
		}
		
		System.out.println(l);
	}

}
