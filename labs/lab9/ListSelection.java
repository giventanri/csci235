/**
 * ListSelection.java
 * 
 *  This program implements selection sort on lists
 *
 * @author Thomas VanDrunen
 * Wheaton College, CSCI 235
 * 
 * 
 */

public class ListSelection {

    public static IList sort(IList unsorted) {
        
        IList sorted = IList.newSortList();

        while(! unsorted.isEmpty()) {
            int smallest = unsorted.removeSmallest();
            sorted.insertAtBack(smallest);
        }

        return sorted;
    }
}
