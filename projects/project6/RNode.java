/**
 * RNode.java
 *
 * Node for a recursive linked list.
 *
 * Note that in the recursive version, most of the work for the list methods
 * is done here.
 *
 * @author TVD/CGG/HK, and Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 6
 * Date 20200421
 */

public class RNode {
    /**
     * The payload for this RNode.  This should be treated as immutable.
     */

    private final int datum;
    /**
     * The INode following this one.
     */
    private RNode next;

    /**
     * Constructor.
     * @param datum The payload for this RNode.
     * @param next  The node that follows this one.
     */
    public RNode(int datum, RNode next) {
        this.datum = datum;
        this.next = next;
    }

    /**
     * Accessor method.
     */
    public int datum() { return datum; }

    /**
     * Accessor method.
     */
    public RNode next() { return next; }
	
    /**
     * Insert an item at the back of this list.
     * @param item The item to add.
     */
    public RNode insertAtBack(int item) {
        if (next == null) {
            next = new RNode(item, null);
            return this;
        } else {
            next = next.insertAtBack(item);
            return this; 
        }
    }

    /**
     * How many items are in this list?
     * @return The number of items in this list.
     */
    public int length() {
	if (next == null) return 1;
	else return 1 + next.length();
    }

    /**
     * Does the list contain an item?
     * @param item The value to look for.
     * @return Whether this list contains the item.
     */
    public boolean contains(int item) {
        if (item == datum() ) return true; // true upon finding the item
        else if (next() == null) return false; // false if item not found until the end of list
        else return next.contains(item); 
    }

    /**
     * Get the value of the item at a specified position.
     * @param position The position in the list.
     * @return The value at position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public int elementAt(int position) {
	if (position >= 0 && position < length() ) {
	    if (position == 0) return datum;
	    else return next.elementAt(position - 1);
	}
	else throw new RuntimeException("precondition violated");
    }

    /**
     * Insert a new item at after a specified position.
     * @param item The value to insert.
     * @param position The index after which the item will be inserted.
     * @return The RNode to be passsed
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public RNode insertAfter(int item, int position) {
        if (position >= 0 && position < length() ) {
	    if (position == 0) {
		next = new RNode(item, next);
		return this; 
	    } else {
		next = next.insertAfter(item, position - 1);
		return this;
	    }
	}
	else throw new RuntimeException("precondition violated");
    }

    /**
     * Delete the item at a specified position.
     * @param position The position in the list.
     * PRECONDITION: position >= 0 and position < length of this list
     */
    public RNode deleteAt(int position) {
        if (position >= 0 && position < length() ) {
	    if (position == 0) return next;
	    else {
		next = next.deleteAt(position - 1);
		return this;
	    }
        }
	else throw new RuntimeException("precondition violated");
    }


    /**
     * Delete the first occurrence of item in this list, if any.
     * @param item The item to delete
     */
    public RNode deleteFirstOccurrence(int item) {
	if (item == datum() ) return next;
	else {
	    if (next != null) next = next.deleteFirstOccurrence(item);
	    return this;
	}
    }

    // deleteAll() method is written to be an RList method

    /**
     * Insert a new item at the right place in an (assumed sorted) list.
     * @param item The item to insert in the right place.
     */
    public RNode insertSorted(int item) {
        if (item < datum () ) {
            return new RNode(item, this);
        } else if (next == null) {
            next = new RNode(item, null);
            return this;
        } else {
            next = next.insertSorted(item);
            return this; 
        }
    }
 
    /**
     * Return the value of the smallest element of the list.
     * @return The smallest element in the list.
     * PRECONDITION: the list is not empty.
     */
    public int findSmallest() {
	/*
	  Cases:
	  If last or only node, return datum

	  Otherwise:
	  Return whatever is smaller: 
	  The datum of the current node,
	  or the datum of the next node 
	*/  
	if (next == null) return datum; 
	else {
	    int nextDatum = next.findSmallest();
	    if (nextDatum < datum) return nextDatum;
	    else return datum;
	}
    }
  
    /**
     * print this node and its successors
     */
    public void print() {
        System.out.print(datum+" ");
        if (next != null) {
            next.print();
        }
    }

}
