import assets.heap_stuff.Heap;
import assets.sorting_stuff.HeapSort;
import assets.sorting_stuff.MergeSort;
import assets.sorting_stuff.SelectionsSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        run(30);
    }

    private static void run(int length) {
        Random random = new Random();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        int bound = 100;
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(bound);
            list1.add(rand);
            list2.add(rand);
            list3.add(rand);
            list4.add(rand);
        }


        System.out.println("without sorting:      " + list1);


        // built in
        long start = System.nanoTime();
        Collections.sort(list1);
        Collections.reverse(list1);
        long end = System.nanoTime();
        System.out.println("built_in:             " + list1 + "  ,t = " + (end - start));


        // heap sort
        start = System.nanoTime();
        System.out.print("using heap sort:      " + (new HeapSort<Integer>()).sort(list2, true));
        end = System.nanoTime();;
        System.out.println("  ,t = " + (end - start));

        // selections sort
        start = System.nanoTime();
        System.out.print("using selection sort: " + (new SelectionsSort<Integer>()).sort(list3, true));
        end = System.nanoTime();
        System.out.println("  ,t = " + (end - start));

        // merge sort
        start = System.nanoTime();
        Integer[] array = new Integer[length];
        list4.toArray(array);
        System.out.print("using merge sort:     " + Arrays.toString((new MergeSort<Integer>()).sort(array, true)));
        end = System.nanoTime();
        System.out.println("  ,t = " + (end - start));

    }

}
