package linkedlists;

public class Main {

	public static void main(String[] args) {
		
		Employee john = new Employee(1, "John");
		Employee mary = new Employee(2, "Mary");
		Employee luke = new Employee(3, "Luke");
		Employee frank = new Employee(4, "Frank");
		
		EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();
		list.addToFront(john);
		list.addToFront(mary);
		list.addToFront(luke);
		list.addToFront(frank);
		
		list.printList();
		
		System.out.println("Size = " + list.getSize());
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.removeFromFront());
		
		System.out.println("Size = " + list.getSize());
		
		list.printList();

	}

}
