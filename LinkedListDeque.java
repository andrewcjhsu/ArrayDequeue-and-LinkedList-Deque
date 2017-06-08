public class LinkedListDeque<Blorp> implements Deque<Blorp>{
	private class Node {
    	public Blorp item;   
    	public Node next; 
    	public Node previous;

		public Node(Blorp i, Node h,Node j) {
            item = i;
            next = h; 
            previous=j;
        }
	}

 	private int size;
 	private Node sentinel;

	public LinkedListDeque(){
		size=0;
		sentinel=new Node(null,null,null);
	}

	public LinkedListDeque(Blorp item){
		size=1;
		sentinel=new Node(null,null,null);
		sentinel.next=new Node(item,null,sentinel);
		sentinel.previous=sentinel.next;

	}

	public void addFirst(Blorp item){
		if (size==0){
			Node ptr=new Node (item,sentinel,sentinel);
			sentinel.next=ptr;
			sentinel.previous=ptr;
			size++;
		}
		else{
			Node ptr=new Node (item,sentinel.next,sentinel);
			sentinel.next.previous=ptr;
			sentinel.next=ptr;
			size++;
		}
	}

	public void addLast(Blorp item){
		if (size==0){
			Node ptr=new Node (item,sentinel,sentinel);
			sentinel.previous=ptr;
			sentinel.next=ptr;
			size++;
		}
		else {
			Node ptr=new Node(item,sentinel,sentinel.previous);
			sentinel.previous=ptr;
			size++;
		}
	}

	public boolean isEmpty(){
		System.out.print(sentinel.next);
		return sentinel.next==null;
	}

	public int size(){
		return size;
	}
	public void printDeque(){
		Node ptr=sentinel;
		for (int i=0;i<size;i++){
			ptr=ptr.next;
			System.out.print(ptr.item+" ");
		}
		System.out.println();
	}

	public Blorp removeFirst(){
		if (size==0){
			return null;
		}
		if (size==1){
			Blorp ptr=sentinel.next.item;
			sentinel.next=null;
			size--;
			return ptr;

		}
		else {
			Blorp ptr=sentinel.next.item;
			sentinel.next=sentinel.next.next;
			sentinel.next.next.previous=sentinel;
			size--;
			return ptr;
		}
	}

	public Blorp removeLast(){
		if (size==0){
			return null;
		}
		if (size==1){
			Blorp ptr=sentinel.next.item;
			sentinel.next=null;
			size--;
			return ptr;
		}
		else {
			Blorp ptr=sentinel.previous.item;
			sentinel.previous.previous.next=sentinel;
			sentinel.previous=sentinel.previous.previous;
			size--;
			return ptr;
		}
	}
	public Blorp get(int index){
		Node ptr=sentinel.next;
		int count=1;
		if (ptr==null){
			return null;
		}
		while (index>count){
			ptr=ptr.next;
			count++;
		}
        return ptr.item;
    }


	public Blorp getRecursive(int index){
		Node ptr=sentinel.next;
		if (ptr==null){
			return null;
		}
		while (ptr!=null){
			ptr=ptr.next;
			return getRecursive(index-1);
		}
		return ptr.item;
	}
}