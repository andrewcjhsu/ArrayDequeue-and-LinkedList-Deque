public class LinkedListDequeTest1{
	public static void main (String[] args){
		LinkedListDeque<Integer> x = new LinkedListDeque<Integer>();
		System.out.println(x.isEmpty());
		x.addFirst(5);
		x.printDeque();
		x.removeFirst();
		x.printDeque();
		System.out.println(x.isEmpty());


	}
}