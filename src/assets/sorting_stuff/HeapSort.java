package assets.sorting_stuff;

import java.util.Collections;
import java.util.List;

public class HeapSort<T extends Comparable<T>> {

    public List<T> sort(List<T> list, boolean descending) {
        if (list.isEmpty()){
            return null;
        }
        buildMaxHeap(list);
        for (int i = 0; i < list.size(); i++){
            T neededItem = list.get(0);
            int endIndex = list.size() - i - 1;
            list.set(0,list.get(endIndex));
            list.set(endIndex,neededItem);
            heapDown(list, endIndex);
        }
        if (descending){
            Collections.reverse(list);
        }
        return list;
    }

    private void buildMaxHeap(List<T> list) {
        boolean running = true;
        while (running){
            running = false;
            int k = list.size() - 1;
            int p = (k - 1) / 2;
            while ((k > 0) && (p >= 0)) {
                if (list.get(k).compareTo(list.get(p)) > 0) {
                    Collections.swap(list, k, p);
                    running = true;
                }
                k--;
                p = (k - 1) / 2;
            }
        }
    }

    private void heapDown(List<T> list, int endIndex) {
        int k = 0;
        int l = 1;
        while (l < endIndex) { // left child is inside the bounds of the array
            int max = l;
            int r = l + 1;
            if (r < endIndex) { // the right child is inside the bounds of the array
                if (list.get(r).compareTo(list.get(max)) > 0) {
                    max = r;  // the max is the right child if it is bigger than the left child
                }
            }

            if (list.get(max).compareTo(list.get(k)) > 0) { // the item at index max is bigger that its parent
                // swap
                T temp = list.get(k);
                list.set(k, list.get(max));
                list.set(max, temp);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }
}
