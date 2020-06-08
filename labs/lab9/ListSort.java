/**
 * ListSort.java
 * 
 *  This program exercises various sorting algorithms.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CSCI 235
 * 
 * 
 */

import java.lang.reflect.*;

public class ListSort {

    public static void main(String[] args) {
        
        try {
            String sortName = args[0];            // the name of the sort class
            Class[] sortMethodFormals = new Class[1];     // just "int[]"
            sortMethodFormals[0] = (new IList()).getClass();
            Method sortMethod =  ClassLoader.getSystemClassLoader()  // the sorting method
                .loadClass(sortName).getMethod("sort", sortMethodFormals);
            
            IList sortList = createRandomList();   // the list to sort
            
            System.out.println("Before sorting: ");
            sortList.printList();
            
            Object[] sortMethodActuals = new Object[1];  // just sortArray
            sortMethodActuals[0] = sortList;
            
            sortList = (IList) sortMethod.invoke(null, sortMethodActuals);
            
            System.out.println("After sorting: ");
            sortList.printList();
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Please give the name of a sorting class on the command line.");
        } 
        catch (ClassNotFoundException cnfe) {
            System.out.println("Class " + args[0] + " not found.");
        }
        catch (NoSuchMethodException nsme) {
            System.out.println("Class " + args[0] + 
                               " does not have a public method void sort(int[]).");
        }
        catch (IllegalAccessException iae) {
            System.out.println("Please make method void sort(int[]) in " + args[0] + " public.");
        }
        catch (InvocationTargetException ite) {
            Throwable throwy = ite.getCause();
            System.out.println(throwy.getClass() + " " + throwy.getMessage());
            throwy.printStackTrace();
        }
    }
        

    /**
     * Create a list of size 10 filled with random values from 0 to 99.
     * Math.random() returns a random double in [0, 1). Multiply by 100
     * and cast to int to get an integer from 0 to 99.
     * @return The randomly filled list.
     */
    static IList createRandomList() {
        IList toReturn = new IList();
        for (int i = 0; i < 10 ; i++)
            toReturn.insertAtFront((int) (Math.random() * 99) + 1);
        return toReturn;
    }
    
}
