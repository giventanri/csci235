/**
 * DList.java
 *
 * A doubly-linked list.
 *
 * @author TVD/CGG/HK and Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 6
 * 20200421
 */

public class DList implements List235 {

    /**
     * The first node in this list.
     */
    private DLNode head;

    /**
     * Constructor.
     * POSTCONDITION: This list is empty.
     */
    public DList() {
	head = null;
    }

    /**
     * Is this list empty?
     * @return Whether this list is empty.
     */
    public boolean isEmpty() {
	return head == null;
    }

    /**
     * Insert an item at the front of this list.
     * @param item The item to add.
     */
    public void insertAtFront(int item) { 
	// set the link going forward (next)
	DLNode n = new DLNode(item);
	n.spliceAsHead(head);
	head = n;
    }

    /**
     * Insert an item at the back of this list.
     * @param item The item to add.
     */
    public void insertAtBack(int item) {
	if (head == null) insertAtFront(item);
	else {
	    DLNode last = findLast();
	    DLNode n = new DLNode(item);
	    n.spliceAfter(last);
	}
    }

    /**
     * Find the last node in this (non-empty) list.
     * @return The last node in this list.
     * PRECONDITION: this is not empty
     */
    private DLNode findLast() {
        if (!isEmpty() ) {
	    DLNode place = head;    // where we are in the list
	    while (place != null) {
		if (place.next() == null) return place;
		place = place.next();
	    }
	    return null;
	}
	else throw new RuntimeException("precondition violated");
    }
    
    /**
     * Delete the front item from this list.
     * PRECONDITION: This list is not empty.
     */
    public void deleteFront() {
        if (!isEmpty() ) head = head.spliceOut();        
        else throw new RuntimeException("precondition violated");
    }

    /**
     * Delete and return the front item from this list.
     * @return The item that was deleted.
     * PRECONDITION: This list is not empty.
     */
    public int removeFront() { 
        if (!isEmpty() ) {
	    DLNode oldHead = head;
	    head = head.spliceOut();
	    return oldHead.datum();
	}
	else throw new RuntimeException("precondition violated");
    }

    /**
     * How many items are in this list?
     * @return The number of items in this list.
     */
    public int length() {
        DLNode place = head;  // the node we are looking at
        int i = 0;           // the counter 
        while (place != null) {
            // counter incremented for each node
            i++;
            place = place.next();
        }
        return i; 
    }

    /**
     * Does the list contain an item?
     * @param item The value to look for.
     * @return Whether this list contains the item.
     */
    public boolean contains(int item) {
        DLNode place = head;
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

            DLNode place = head;  // the node we are looking at
            int i = 0;           // the position of place
            while (place != null) {
		if (i == position) { // is place the node we want?
		    return place.datum();
		}
		// do something before going to the next node
		place = place.next();
		i++;
            }
            return 0;
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
            DLNode place = head;  // the node we are looking at
            int i = 0;           // the position of place
            while (place != null) {
		if (i == position) { // is place the node we want?
		    // new node to be inserted
		    DLNode insertedNode = new DLNode(item);
		    insertedNode.spliceAfter(place);
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
        if (position >= 0 && position < length() ) {
	    if (position == 0) deleteFront();
	    else {
		DLNode place = head;    // where we are in the list
		int i = 0;             // count corresponding to place
		// There is nothing before head, so null?
		while (place != null) {
		    if (i == position) {
			place.spliceOut();
			return;
		    }
		    // move place forward
		    place = place.next();
		    i += 1;
		}
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
            DLNode place = head;
            // at the first occurence of item,
            // link the previous node to the node after place
            while (place != null) {
		if (place.datum() == item) {
		    place.spliceOut();
		    return;
		}
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
     * Insert a new item at the right place in an (assumed sorted) list.
     * @param item The item to insert in the right place.
     */
    public void insertSorted(int item) {

	// Condition 1: empty list
	if (head == null) insertAtFront(item);

	// Condition 2: item < head.datum()
	else if (item < head.datum() ) insertAtFront(item);
    
	// Else, insert in the right place	
	else {
	    DLNode place = head;    // where we are in the list
	    while (place != null) {
		if (place.next() == null || item < place.next().datum() ) {
		    // if the item is smaller then the next datum,
		    // then a new node containing the item is inserted
		    DLNode insertedNode = new DLNode(item);
		    insertedNode.spliceAfter(place);
		    return;
		}
		// move place forward
		place = place.next();
	    }
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
	    DLNode smallest = findSmallest();
	    smallest.spliceOut();
	    return smallest.datum();
	}   else throw new RuntimeException("precondition violated");
    }


    /**
     * Return the value of the smallest element of the list.
     * @return The node containing the smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    private DLNode findSmallest() {
        if (!isEmpty() ) {
	    DLNode place = head; // where we are at
	    DLNode smallest = place; // the node to be returned
	    while (place != null) {
		if (place.datum() < smallest.datum() ) {
		    smallest = place;
		}
		place = place.next();
	    }
	    return smallest;
        } else throw new RuntimeException("precondition violated");
    }

    /**
     * Print the elements of this list to System.out.
     */
    public void printList() {
	System.out.print("[ ");
	DLNode place = head;
	while (place != null) {
	    System.out.print(place.datum()+" ");
	    place = place.next();
	}
	System.out.println("]");
    }
    
    /**
     * Print the elements of this list in reverse order.
     */
    public void printListReverse() {
	DLNode place = head;
	if (place != null) {
	    while (place.next() != null) {
		place = place.next();
	    }
	}
	System.out.print ("reverse [ ");
	while (place != null) {
	    System.out.print (place.datum() + " ");
	    place = place.previous();
	}
	System.out.println ("]");
    }
	
    /*
    public static void main(String[] args) {
	// for testing
	DList x = new DList();
	x.insertAtFront(15);		
	x.insertAtFront(12);
	x.insertAtFront(4);
	x.printList();
	x.printListReverse();
    }
    */
    
}
