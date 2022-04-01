package assets.sorting_stuff;

import java.util.Collections;
import java.util.List;

public class SelectionsSort<T extends Comparable<T>> {

    public List<T> sort(List<T> list, boolean descending) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = getMin(list, i + 1);
            if (list.get(i).compareTo(list.get(minIndex)) > 0) {
                Collections.swap(list, i, minIndex);
            }
        }
        if (descending) {
            Collections.reverse(list);
        }
        return list;
    }

    private int getMin(List<T> list, int start) {
        int currentMin = start;
        for (int i = currentMin; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(currentMin)) < 0) {
                currentMin = i;
            }
        }
        return currentMin;
    }
}

