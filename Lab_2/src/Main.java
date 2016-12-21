import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.SelectionSort;
import behaviors.SortBehavior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrew on 12.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Bubble sort demo");
        int [] arrForBubbleSort = generateAndDisplayRandomArr();

        // Bubble sort
        int [] sortedBubbleArray= new SortBehavior(new BubbleSort()).executeSort(arrForBubbleSort);
        for(int i : sortedBubbleArray)
            System.out.print(i + " ");


        System.out.println("\n\nInsertion sort demo");
        int [] arrForInsertionSort = generateAndDisplayRandomArr();

        // Insertion sort
        int [] sortedInsertionArray = new SortBehavior(new InsertionSort()).executeSort(arrForInsertionSort);
        for(int i : sortedInsertionArray)
            System.out.print(i + " ");

        System.out.println("\n\nSelection sort demo");
        int [] arrForSelectionSort = generateAndDisplayRandomArr();

        // Insertion sort
        int [] sortedSelectionArray = new SortBehavior(new SelectionSort()).executeSort(arrForSelectionSort);
        for(int i : sortedSelectionArray)
            System.out.print(i + " ");

    }

    private static int [] generateAndDisplayRandomArr (){
        // Create an ordered list
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        // Shuffle it
        Collections.shuffle(list);

        // Get an int[] array
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        for (int i : array)
            System.out.print(i + " ");
        System.out.println("\n------------------------------------------------");
        return array;
    }
}
