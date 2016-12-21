package algorithms;

import abstractions.ISort;

/**
 * Created by Andrew on 12.10.2016.
 */
public class InsertionSort implements ISort {
    @Override
    public int[] sort(int[] arr) {

        for (int i=0; i < arr.length; i++){
            int current = arr[i];
            int j = i;
            while (j > 0 && current < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current;
        }
        return arr;
    }
}
