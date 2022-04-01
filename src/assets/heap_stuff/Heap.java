package assets.heap_stuff;

import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> items;

    public Heap() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
        int k = items.size() - 1; // index of the item to
        heapUp(k);
    }

    public T delete() {
        if (this.items.isEmpty()) {
            return null;
        }
        T neededItem = this.items.get(0);
        this.items.set(0, this.items.get(this.items.size() - 1));
        this.items.remove(this.items.size() - 1);
        heapDown(this.items, 0, this.items.size());
        return neededItem;
    }

    private void heapDown(ArrayList<T> items, int startingIndex, int endIndex) {
        int k = startingIndex;
        int l = 1;
        while (l < endIndex) { // left child is inside the bounds of the array
            int max = l;
            int r = l + 1;
            if (r < endIndex) { // the right child is inside the bounds of the array
                if (this.items.get(r).compareTo(items.get(max)) > 0) {
                    max = r;  // the max is the right child if it is bigger than the left child
                }
            }

            if (this.items.get(max).compareTo(this.items.get(k)) > 0) { // the item at index max is bigger that its parent
                // swap
                T temp = this.items.get(k);
                this.items.set(k, this.items.get(max));
                this.items.set(max, temp);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    private void heapUp(int k) {
        while (k > 0) {  // working till the root of the heap
            int p = (k - 1) / 2; // the index of the parent of item at index k
            T currentItem = items.get(k);
            T parentItem = items.get(p);

            if (currentItem.compareTo(parentItem) > 0) { // check if the current item is bigger that the parent item
                // swap the items
                items.set(k, parentItem);
                items.set(p, currentItem);
                // move one level up
                k = p;
            } else {
                break;
            }
        }
    }

    public void sort(SortingType type, boolean descending) {
        if (isEmpty()){
            return;
        }
        if (type.equals(SortingType.HEAP)){
            heapSort(descending);
        }
    }

    private void heapSort(boolean descending){
        for (int i = 0; i < size(); i++){
            T neededItem = this.items.get(0);
            int endIndex = this.items.size() - i - 1;
            this.items.set(0, this.items.get(endIndex));
            this.items.set(endIndex, neededItem);
            heapDown(this.items, 0, endIndex);

        }
        if (descending){
            Collections.reverse(this.items);
        }
    }










    @Override
    public String toString() {
        return this.items.toString();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public int size() {
        return this.items.size();
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }
}
