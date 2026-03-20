package apps;

import utils.LinkedList;
import java.util.ArrayList;

public class LinkedListPerformanceComparison {

    public static void main() {

        int[] sizes = {10, 100, 1000, 10000};

        long arrayStartTotal = 0;
        long arrayEndTotal = 0;
        long arrayMiddleTotal = 0;

        long linkedStartTotal = 0;
        long linkedEndTotal = 0;
        long linkedMiddleTotal = 0;


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
            arrayStartTotal += (end - start);

            //Add at end
            start = System.nanoTime();
            arrayList.add("NEW");
            end = System.nanoTime();
            System.out.println("ArrayList Add at End: " + (end - start));
            arrayEndTotal += (end - start);

            //Get middle
            start = System.nanoTime();
            arrayList.get(size / 2);
            end = System.nanoTime();
            System.out.println("ArrayList Get Middle: " + (end - start));
            arrayMiddleTotal += (end - start);


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
            linkedStartTotal += (end - start);

            //Add at end
            start = System.nanoTime();
            linkedList.add("NEW");
            end = System.nanoTime();
            System.out.println("LinkedList Add at End: " + (end - start));
            linkedEndTotal += (end - start);

            //Get middle
            start = System.nanoTime();
            linkedList.get(size / 2);
            end = System.nanoTime();
            System.out.println("LinkedList Get Middle: " + (end - start));
            linkedMiddleTotal += (end - start);

            System.out.println();
        }

        int count = sizes.length;

        long arrayStartAvg = arrayStartTotal / count;
        long arrayEndAvg = arrayEndTotal / count;
        long arrayMiddleAvg = arrayMiddleTotal / count;

        long linkedStartAvg = linkedStartTotal / count;
        long linkedEndAvg = linkedEndTotal / count;
        long linkedMiddleAvg = linkedMiddleTotal / count;

        System.out.println("=================================");
        System.out.println("Averages");
        System.out.println("=================================");

        System.out.println("ArrayList Add at Start: " + arrayStartAvg);
        System.out.println("ArrayList Add at End: " + arrayEndAvg);
        System.out.println("ArrayList Get Middle: " + arrayMiddleAvg);

        System.out.println();

        System.out.println("LinkedList Add at Start: " + linkedStartAvg);
        System.out.println("LinkedList Add at End: " + linkedEndAvg);
        System.out.println("LinkedList Get Middle: " + linkedMiddleAvg);
    }
}