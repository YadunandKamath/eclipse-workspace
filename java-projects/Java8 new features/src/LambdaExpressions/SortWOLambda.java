package LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class myComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		/*
		if(o1>o2) {
			return -1;
		}
		else if(o1<o2) {
			return 1;
		}
		else {
			return 0;
		}
		*/
		return (o1>o2)?-1:(o1<o2)?1:0;
		
	}
	
}

public class SortWOLambda {

	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<>();
		l.add(10);
		l.add(0);
		l.add(20);
		l.add(5);
		l.add(15);
		System.out.println("Before sorting: " + l);
		Collections.sort(l, new myComparator());
		System.out.println("After sorting: " + l);

	}

}
