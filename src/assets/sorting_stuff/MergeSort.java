package assets.sorting_stuff;

import java.util.*;

public class MergeSort<T extends Comparable<T>> {
    public T[] sort(T[] array, boolean descending) {
        mergeSort(array,0,array.length);

        if (descending) {
            for (int i = 0; i < array.length / 2; i++) {
                T temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
        return array;
    }

    private void mergeSort(T[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private void merge(T[] array, int start,int mid, int end){
        int comp = array[mid-1].compareTo(array[mid]);
        if (comp <= 0){
            return;
        }
        int i = start;
        int j = mid;
        int k = 0;
        Object[] tempArray = new Object[end - start];
        while(i < mid && j < end){
            comp = array[i].compareTo(array[j]);
            tempArray[k++] = (comp <= 0) ? array[i++] : array[j++];
        }

        System.arraycopy(array,i,array,start+k,mid-i);
        System.arraycopy(tempArray,0,array,start,k);
    }
}
