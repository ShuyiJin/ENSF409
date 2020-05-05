/**
 * The class SimpleList creates a linked list of type Nodes
 *
 * @author Shuyi Jin
 * @version 1.0
 * @since Janurary 25, 2018
 */
 public class SimpleList{
	/**
	 * The size of the SimpleList object
	 */
	private int sizeM;
	
	/**
	 * The first element of the SimpleListObject
	 */
	private Node headM;
	
	/**
	 * This is a private class inside SimpleList to create Node objects
	 */
	private class Node{
		/**
		 * The integer value of the Node object
		 */
		public int item;
		
		/**
		 * The next Node object the current Node object points to
		 */
		public Node next;
	}
	
	/**
	 * Creates empty list.
	 */
	public SimpleList(){
		headM = null;
		sizeM = 0;
	}
	
	/**
	 * Find the size of the LinkedList object
	 * @return the size of the LinkedList object
	 */
	public int size(){return sizeM;};
	
	/**
	 * Adds a node with an item to the end of the list, and increments sizeM
	 * @param item  the integer value to be added
	 */
	public void push_back(final int item){
		Node new_node = new Node();
		if(new_node == null){
			System.out.println("No memory available to create a node.");
			return;
		}
		new_node.item = item;
		
		if(headM == null){
			new_node.next = headM;
			this.headM = new_node;
		}
		else{
			Node p = headM;
			while(p.next != null){
				p = p.next;
			}
			p.next = new_node;
			new_node.next = null;
		}
		sizeM++;
	}
	
	/**
	 * Adds a node with an item to the beginning of the list, and increments sizeM
	 * @param item  the integer value to be added
	 */
	public void push_front(final int item){
		Node new_node = new Node();
		new_node.item = item;
		new_node.next = headM;
		headM = new_node;
		sizeM++;
	}
	
	/**
	 * A node with a copy of itemA is inserted at the nth position, and
	 * sizeM will be incremented if the operation of insert was successfull.
	 * If index is out of range, return and do nothing.
	 * @param itemA  the integer value to be added
	 * @param n		 the index itemA is inserted at
	 */
	public void insert(final int itemA, int n){
		if(n < 0 || n > sizeM)
			return;
		else if(n == 0)
			push_front(itemA);
		else if(n == sizeM) 
			push_back(itemA);
		else{
			Node new_node = new Node();
			if (new_node == null) {
				System.out.println("Sorry memory is unavailable to create a new node.");
				System.exit(1);
			}
			new_node.item = itemA;
			
			
			Node before = headM;      // will point to node in front of new node
			Node after = headM.next; // will be 0 or point to node after new node
			for(int i = 1; i < n; i++){
				before = after;
				after = after.next;
			}
			
			new_node.next = after;
			before.next = new_node;
			sizeM++;
		}
	}
	
	/**
	 * An item is return at the nth position in the list. 
	 * @param n  the index to be returned
	 * @return the value of index n
	 */
	public int get(int n){
		if(n < 0 || n >= sizeM){
			System.out.println( "Illegal Access. Program Terminates...");
			System.exit(0);
		}
		
		Node p = headM;
		for(int i = 0; i < n; i++)
			p = p.next;
		
		return p.item;
	}
	
	/**
	 * puts the value of v at the n-th position 
	 * @param n  the index to be set
	 * @param v  the new value of index n
	 */
	public void set(int n, int v){
		if(n < 0 || n >= sizeM){
			System.out.println("Illegal Access. Program Terminates...");
			return;
		}
		
		Node p = headM;
		for(int i= 0; i < n; i++)
			p = p.next;
		
		p.item = v;
	}
	
	/**
	 * Deallocate all nodes, and sets headM to null, and size to zero
	 */
	public void clear(){
		headM = null;
		sizeM = 0;;
	}
	
	/**
	 * Does nothing if index is out of range. Otherwise, if list is not empty
	 * removes the node at the position n.
	 * @param n  the index to be removed
	 */
	public void remove(int n){
		if (headM == null || n < 0 || n >= sizeM)
			return;
		
		Node before, be_deleted;
		
		if(n == 0){
			headM = headM.next;
		}
		else{
			before = headM;
			be_deleted = before.next;
			
			
			for(int i = 1; i < n; i++){
				before = be_deleted;
				be_deleted = before.next;
			}
			
			before.next = be_deleted.next;
			be_deleted.next = null;
		}
		sizeM--;
	}
	
	/**
	 * prints values in the list from first node (node number 0) to the last node.
	 * @param list the list to be printed
	 */
	public void print(SimpleList list){
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.printf("\n");
	}
	
	public static void main(String[] args){
		SimpleList list = new SimpleList();
		System.out.println("List just after creation -- is empty.");
		
		list.push_front(50);
		System.out.println("After calling push_front. list must have: 50");
		list.print(list);
		
		list.push_back(440);
    
		list.set(0,770);
		System.out.println("After calling push_back and set function list must have: 770 440");
		list.print(list);
		
		list.push_back(330);
		list.push_back(220);
		list.push_back(110);
    
		System.out.println("After three more calls to push_back, list must have: 770, 440, 330, 220, 110");
		list.print(list);
		
		list.remove(0);
		list.remove(2);
		
		System.out.println("After removing two nodes. list must have: 440, 330, 110");
		list.print(list);
		
		list.insert(40, 3); //insert node with the value of 40 at the 4th position
		list.insert(20, -1); // do nothing
		list.insert(30, 30000); // do nothing
		list.insert(10, 0); //insert node with the value of 10 at the 1st position
		list.insert(33, 2); // insert node with the value 33 at the 3rd position
		
		System.out.println("Two  more nodes inserted, must have: 10, 440, 33, 330, 110, 40");
		list.print(list);
		
		list.remove(0);
		list.remove(1);
		list.remove(2);
		list.remove(3);
		list.remove(4);
		list.remove(5);
		
		System.out.println("After 6 removes, list must have: 440, 330, 40");
		list.print(list);

		list.clear();
		System.out.println ("After call to clear, list must be empty:");
		list.print(list);
		
		list.push_back(331);
		list.push_back(221);
		list.push_back(111);
		
		System.out.println("After three calls to push_back, list must have: 331, 221, 111");
		list.print(list);
	}
}