import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsPractice {

	public static void main(String[] args) {

		/*
		ArrayList<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(6);
		a.add(34);
		a.add(77);
		for(Object z : a) {
			System.out.println(z);
		}
		System.out.println(a.stream().filter(t->t>5).min((i1,i2)->i1.compareTo(i2)));
		*/
		
		List<String> colors = new ArrayList<String>();
		colors.add("red");
		colors.add("blue");
		colors.add("pink");
		if(colors.contains("pink")) {
			System.out.println("yes " + colors.indexOf("pink"));
		}
		System.out.println(colors);
		colors.add(1,"black");
		colors.set(0,"white");
		colors.add("black");
		//colors.add("black");
		Collections.sort(colors);
		System.out.println(colors.subList(0, 2));
		
		ArrayList<String> colors2 = new ArrayList<>();
		colors.add("green");
		colors.add("green");
		colors.add("green");
		Iterator<String> p = colors.listIterator(3);
		while(p.hasNext()) {
			System.out.println(p.next());
		}
		colors.addAll(colors2);
		colors.removeAll(colors);
		System.out.println(colors.isEmpty());
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(10);
		ll.add(5);
		ll.add(23);
		ll.add(3);
		ll.offerLast(0);
		Iterator<Integer> p2 = ll.descendingIterator();
		while(p2.hasNext()) {
			System.out.println(p2.next());
		}
		System.out.println(ll.peek());
		
		System.out.println("\nHASH SET");
		Set<String> hx = new HashSet<String>();
		hx.add("b");
		hx.add("a");
		hx.add("c");
		hx.add(null);
		System.out.println(hx);
		
		System.out.println("\nTREE SET");
		Set<String> ts = new TreeSet();
		ts.add("x");
		ts.add("b");
		ts.add("d");
		ts.add("b");
		//ts.add(null);
		System.out.println(ts);
		
		System.out.println("\nPRIORITY QUEUE");
		PriorityQueue<String> q = new PriorityQueue<>();
		q.add("a");
		q.add("x");
		q.add("c");
		q.add("a");
		//q.add(null);
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
		pq1.add(10);
		pq1.add(22);
		pq1.add(36);
		pq1.add(25);
		pq1.add(16);
		pq1.add(70);
		pq1.add(82);
		pq1.add(89);
		pq1.add(14);
		System.out.println("Original Priority Queue: "+pq1);
		String str = pq1.toString();
		System.out.println("String rep" + str + "\n");
		
		System.out.println("HASH MAP");
		HashMap<Integer,String> hm = new HashMap();
		hm.put(1, "a");
		hm.put(5, "x");
		hm.put(3, "c");
		hm.put(32, "g");
		hm.put(11, "a");
		System.out.println(hm);
		for(Map.Entry x: hm.entrySet()) {
			if(x.getKey()==(Object)32) {
				x.setValue("h");
			}
			
			System.out.println(x.getKey() + " " + x.getValue());
		}
		System.out.println("\nTREE MAP");
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("z",26);
		tm.put("d", 4);
		tm.put("j", 10);
		tm.put("a", 1);
		System.out.println(tm);
	
	}

}
