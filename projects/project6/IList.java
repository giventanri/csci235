/**
 * IList.java
 *
 * A first stab at a linked list (iterative version)
 *
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 6
 * 20200421
 */

public class IList implements List235 {

    /**
     * The first INode in this list.
     */
    private INode head;

    /**
     * Constructor.
     * POSTCONDITION: This list is empty.
     */
    public IList() {
	head = null;
    }

    /**
     * Alternative to constructor: create a list for use by sorting methods.
     * To simplify the insertion methods used for sorting, this starts
     * out the list with an extra zero item on the front.
     * After fixing the insertions to work on an empty list,
     * change this method  to start with an empty list.
     */
    public static IList newSortList() {
	IList theList = new IList();
	return theList;
    }

    /**
     * Is this list empty?
     * @return Whether this list is empty.
     */
    public boolean isEmpty() {
	return head == null;
    }

    /**
     * Add an item at the front of this list.
     * @param item The item to add.
     */
    public void insertAtFront(int item) {
	head = new INode(item, head);
    }

    /**
     * Delete the front item from this list.
     * PRECONDITION: This list is not empty.
     */
    public void deleteFront() {
	if (!isEmpty() ) head = head.next();
	else throw new RuntimeException("precondition violated");
    }

    /**
     * Delete and return the front item from this list.
     * @return The item that was deleted.
     * PRECONDITION: This list is not empty.
     */
    public int removeFront() {
	if (!isEmpty() ) {
	    int temp = head.datum();
	    head = head.next();
	    return temp;
	}
	else throw new RuntimeException("precondition violated");
    }

    /**
     * Print the elements of this list to System.out.
     */
    public void printList() {
	System.out.print("[ ");
	INode place = head; // position within this list
	while (place != null) {
	    System.out.print(place.datum()+" ");
	    place = place.next();
	}
	System.out.println("]");
    }

    /**
     * How many items are in this list?
     * @return The number of items in this list.
     */
    public int length() {
	INode place = head;  // the node we are looking at
	int i = 0;           // the counter 
	while (place != null) {
	    // counter incremented for each node
	    i++;
	    place = place.next();
	}
	return i; 
    }
 
    /**
     * What is the sum of items in the list?
     * @return The sum of all items in this list.
     */
    public int sum() {
	INode place = head;
	int sum = 0;
	while (place != null) {
	    sum += place.datum(); // adds to the current sum
	    place = place.next();
	}
	return sum; 
    }

    /**
     * Does the list contain an item?
     * @param item The value to look for.
     * @return Whether this list contains the item.
     */
    public boolean contains(int item) {
	INode place = head;
	while (place != null) {
	    
	    if (place.datum () == item) { // checks every datum
		return true; // returns true once the item is detected
	    }
	    place = place.next();
	}
	return false; // returns false at all other cases
    }

    /**
     * Get the value of the item at a specified position.
     * @param position The position in the list.
     * @return The value at position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public int elementAt(int position) {
	if (position >= 0 && position < length() ) {

	    INode place = head;  // the node we are looking at
	    int i = 0;           // the position of place
	    while (place != null) {
		if (i == position) { // is place the node we want?
		    return place.datum();
		}
		// do something before going to the next node
		place = place.next();
		i++;
	    }
	    // Exception:
	    // The conditional must eventually be true, given precondition
	    throw new RuntimeException("precondition violated");
	}
	// ran off the end
	else throw new RuntimeException("precondition violated");
    }

    /**
     * Insert a new item at after a specified position.
     * @param item The value to insert.
     * @param position The index after which the item will be inserted.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void insertAfter(int item, int position) {
	if (position >= 0 && position < length() ) {
	    INode place = head;  // the node we are looking at
	    int i = 0;           // the position of place
	    while (place != null) {
		if (i == position) { // is place the node we want?
		    // new node to be inserted
		    INode insertedNode = new INode(item, place.next() );
		    place.setNext(insertedNode); // set next to the new node
		    return;
		}
		// do something before going to the next node
		place = place.next();
		i++;
	    }
	}
	else throw new RuntimeException("precondition violated");
    }

    /**
     * Delete the item at a specified position.
     * @param position The position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public void deleteAt(int position) {
	if (position >= 0 &&  position < length() ) {
	    if (position == 0) deleteFront();
	    else {
		INode place = head;    // where we are in the list
		int i = 0;             // count corresponding to place
		INode before = null; // the node before place
		// There is nothing before head, so null?
		while (place != null) {
		    if (i == position) {
			// place is the node to remove from the list;
			// so splice out place -- for which we need to know
			// the node before it
			before.setNext(place.next());
			return;
		    }
		    // move place forward
		    before = place;
		    place = place.next();
		    i += 1;
		}
		return; //avoiding Exception: catch-all return statement
	    }
	}
	else throw new RuntimeException("precondition violated");
    }
    
    /**
     * Delete the first occurrence of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteFirstOccurrence(int item) {
	if (head.datum() == item) deleteFront();
	else {
	    INode place = head;
	    INode previous = null; // null before head

	    // at the first occurence of item,
	    // link the previous node to the node after place
	    while (place != null) {
		if (place.datum() == item) {
		    previous.setNext( place.next() );
		    return;
		}
		previous = place;
		place = place.next();
	    }
	}
    }

    /**
     * Delete all occurrences of item in this list, if any.
     * @param item The item to delete
     */
    public void deleteAll(int item) {
	// delete item using loop
	while (contains(item) ) deleteFirstOccurrence(item);
    }

    /**
     * Make a new list that is the reverse of this one.
     * @return the reversed new list
     */
    public IList makeReverse() {
	IList temp = new IList();

	INode place = head;

	// insert datum to temp in reverse order
	while (place != null) {
	    temp.insertAtFront(place.datum() );
	    place = place.next(); 
	}
	
	return temp;
    }

    /**
     * Reverse this list (without making a new list).
     * (Ideally, do it without making any new nodes.)
     */
    public void reverse() {
	// System.out.println("length: "+ length());
	for (int i = length() - 1; i > 0; i--) {
	    insertAfter(removeFront(), i - 1);
	}
    }
	


    /**
     * Insert a new item at the right place in an (assumed sorted) list.
     * @param item The item to insert in the right place.
     */
    public void insertSorted(int item) {

	// Condition 1: empty list
	if (head == null) insertAtFront(item);

	// Condition 2: item < head.datum()
	else if (item < head.datum() ) {
	    INode temp = head;
	    insertAtFront(item);
	    head.setNext(temp);
	
	    // Else, insert in the right place	
	} else {
	    INode place = head;    // where we are in the list
	    while (place != null) {
		if (place.next() == null || item < place.next().datum() ) {
		    // if the item is smaller then the next datum,
		    // then a new node containing the item is inserted
		    INode insertedNode = new INode(item, place.next() );
		    place.setNext(insertedNode);
		    return;
		}
		// move place forward
		place = place.next();
	    }
	}
    }

    /**
     * Insert an item at the back of the list.
     * @param item The item to to add
     */
    public void insertAtBack(int item) {
	INode place = head;
	while (place != null) {
	    if (place.next() == null) {
		INode insertedNode = new INode(item, null);
		place.setNext(insertedNode);
		return;
	    }
	    place = place.next();
	}
    }

    /**
     * Remove and return the smallest element of the list.
     * First find the smallest, then delete it, then return it.
     * @return The (now removed) smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    public int removeSmallest() {
	if (!isEmpty() ) { 
	    int smallest = findSmallest();
	    deleteFirstOccurrence(smallest);
	    return smallest;
	}         else throw new RuntimeException("precondition violated");
    }

    /**
     * Return the value of the smallest element of the list.
     * @return smallest The smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    private int findSmallest() {
	if (!isEmpty() ) {
	    int smallest = elementAt(0); 
	    for (int i = 0; i < length(); i++) {	    
		if (elementAt(i) < smallest) {
		    smallest = elementAt(i);
		}
	    }
	    return smallest;
	}         else throw new RuntimeException("precondition violated");
    }

	
    /*
      public static void main(String[] args) {
      // test
      IList x = new IList();
	
      // test isEmpty()
      System.out.println("isEmpty()? "+x.isEmpty());
      System.out.print("Initial: ");
      x.printList();

      // All insert methods //

      // test insertAtFront()
      x.insertAtFront(3);
      x.insertAtFront(2);
      x.insertAtFront(1);
      x.printList();	// [ 1 2 3 ]
      // test insertAfter()
      System.out.println(x.head.datum());

      //x.insertAfter(5, -5); // test Exception
      x.insertAfter(5, 0);
      x.printList(); // [ 1 5 2 3 ]
	
      // test insertSorted()
      x.insertSorted(4);
      x.insertSorted(2);
      x.printList(); // [ 1 2 4 5 2 3 ]

      // test insertAtBack()
      x.insertAtBack(2);
      x.insertAtBack(7);
      x.insertAtBack(8);
      x.printList(); // [ 1 2 4 5 2 3 2 7 8 ]


      // Other helper methods //

      // test length()
      System.out.println("x.length(): " + x.length() ); // 9
      // test sum()
      System.out.println("x.sum(): " + x.sum() ); //  34

      // test contains()
      System.out.println("x.contains(9): " + x.contains(9) ); // false
      System.out.println("x.contains(2): " + x.contains(2) ); // true

      // test elementAt()
      // System.out.println("x.elementAt(): " + x.elementAt(99) ); // Exception
      System.out.println("x.elementAt(): " + x.elementAt(3) ); // 5

      // test findSmallest()
      System.out.println("x.length(): " + x.length() ); // 9 


      // Mutator methods //

      // test deleteFront()
      x.deleteFront();
      x.printList(); // [ 2 4 5 2 3 2 7 8 ]
      // test removeFront()
      int intRemoved = x.removeFront();
      System.out.println("intRemoved = " + intRemoved); // 2
      x.printList(); // [ 4 5 2 3 2 7 8 ]

      // test deleteAt()
      // x.deleteAt(99); // Exception
      x.deleteAt(3); 
      x.printList(); // [ 4 5 2 2 7 8 ]

      // test deleteFirstOccurrence()
      x.deleteFirstOccurrence(7); 
      x.printList(); // [ 4 5 2 2 8 ]

      // test deleteAll() 
      x.deleteAll(2);
      x.printList(); // [ 4 5 8 ]

      // test removeSmallest()
      x.removeSmallest();
      x.printList(); // [ 5 8 ]

      // build a new list
      x = new IList();
      x.insertSorted(3);
      x.insertSorted(4);
      x.insertSorted(2);
      x.insertSorted(5);
      x.insertSorted(1);
      x.printList(); // [ 1 2 3 4 5 ]


      // test makeReverse()
      IList reversedX = x.makeReverse(); 
      System.out.println("x:");
      x.printList(); // [ 1 2 3 4 5 ]
      System.out.println("reversedX:");
      reversedX.printList(); // [ 5 4 3 2 1 ]

      // test reverse()
      x.printList(); // [ 5 4 3 2 1 ]

      x.reverse(); 
      x.printList(); // [ 5 4 3 2 1 ]

      // build a new list with the length of 1
      x = new IList();
      x.insertSorted(1);
	
      // test reverse(), case: length of 1
      x.printList(); // [ 1 ]
      x.reverse(); 
      x.printList(); // [ 1 ]

	
      }
    */
}
