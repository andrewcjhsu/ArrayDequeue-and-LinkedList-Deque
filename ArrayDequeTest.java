public class ArrayDequeTest{
	public static void main(String[] args) {
		ArrayDeque<String> x=new ArrayDeque<String>();
		
		// System.out.println(x.get(0));
		// System.out.println(x.getSize());
		// // // System.out.println(x.get(7));
		// // // System.out.println(x.removeFirst());
		// // // System.out.println(x.get(7));
		// // // System.out.println(x.get(7));

		ArrayDeque<Integer> y =new ArrayDeque<Integer>();
		y.addFirst(0);
		y.addFirst(1);
		y.addFirst(2);
		y.addFirst(3);
		y.addFirst(4);
		y.addFirst(5);
		y.addFirst(6);
		y.addFirst(7);
		y.addFirst(8);
		y.addLast(2);
		y.removeFirst();
		y.printDeque();
		y.removeFirst();
	
		System.out.println(y.getSize());


	} 
}