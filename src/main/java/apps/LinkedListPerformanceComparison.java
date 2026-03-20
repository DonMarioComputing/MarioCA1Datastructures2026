package apps;

import utils.LinkedList;
import java.util.ArrayList;

public class LinkedListPerformanceComparison {

    public static void main() {

        int[] sizes = {10, 100, 1000, 10000};

        for (int size : sizes) {

            System.out.println("=================================");
            System.out.println("List Size: " + size);
            System.out.println("=================================");

            //Arraylist
            ArrayList<String> arrayList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                arrayList.add("Item " + i);
            }

            //Add at start
            long start = System.nanoTime();
            arrayList.add(0, "NEW");
            long end = System.nanoTime();
            System.out.println("ArrayList Add at Start: " + (end - start));

            //Add at end
            start = System.nanoTime();
            arrayList.add("NEW");
            end = System.nanoTime();
            System.out.println("ArrayList Add at End: " + (end - start));

            //Get middle
            start = System.nanoTime();
            arrayList.get(size / 2);
            end = System.nanoTime();
            System.out.println("ArrayList Get Middle: " + (end - start));


            //Linkedlist
            LinkedList linkedList = new LinkedList();

            for (int i = 0; i < size; i++) {
                linkedList.add("Item " + i);
            }

            //Add at start
            start = System.nanoTime();
            linkedList.add(0, "NEW");
            end = System.nanoTime();
            System.out.println("LinkedList Add at Start: " + (end - start));

            //Add at end
            start = System.nanoTime();
            linkedList.add("NEW");
            end = System.nanoTime();
            System.out.println("LinkedList Add at End: " + (end - start));

            //Get middle
            start = System.nanoTime();
            linkedList.get(size / 2);
            end = System.nanoTime();
            System.out.println("LinkedList Get Middle: " + (end - start));

            System.out.println();
        }
    }
}