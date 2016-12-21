package algorithms;

import abstractions.ISort;

public class BubbleSort implements ISort {

    @Override
    public int[] sort( int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    // Just to clean code on loop
    private void swap (int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
