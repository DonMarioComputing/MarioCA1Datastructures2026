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

        //Averages for each size
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

        //Overall Comparison
        System.out.println();
        System.out.println("=================================");
        System.out.println("Overall Comparison");
        System.out.println("=================================");

        System.out.println("Add at Start");
        System.out.println("ArrayList Avg: " + arrayStartAvg);
        System.out.println("LinkedList Avg: " + linkedStartAvg);
        System.out.println();

        System.out.println("Add at End");
        System.out.println("ArrayList Avg: " + arrayEndAvg);
        System.out.println("LinkedList Avg: " + linkedEndAvg);
        System.out.println();

        System.out.println("Get Middle Element");
        System.out.println("ArrayList Avg: " + arrayMiddleAvg);
        System.out.println("LinkedList Avg: " + linkedMiddleAvg);

        //Explanation
        System.out.println();
        System.out.println("=================================");
        System.out.println("Explanation");
        System.out.println("=================================");

        System.out.println("Add at Start:");
        System.out.println("ArrayList is usually slower for adding at the start because all existing elements");
        System.out.println("must be shifted one position to the right. This gives ArrayList a time complexity");
        System.out.println("of O(n) for add at start.");
        System.out.println("LinkedList is usually faster for adding at the start because it only needs to");
        System.out.println("change the reference to the first node. This gives LinkedList a time complexity");
        System.out.println("of O(1) for add at start.");
        System.out.println();

        System.out.println("Add at End:");
        System.out.println("ArrayList is usually fast for adding at the end, with an average time complexity");
        System.out.println("of O(1), although resizing can occasionally make a single add slower.");
        System.out.println("LinkedList is also O(1) for add at end in this implementation because the list");
        System.out.println("stores a reference to the last node, so the new node can be linked directly.");
        System.out.println();

        System.out.println("Get Middle Element:");
        System.out.println("ArrayList is much faster for get middle element because it supports direct index");
        System.out.println("access, giving a time complexity of O(1).");
        System.out.println("LinkedList is slower for get middle element because it must traverse from the");
        System.out.println("first node step by step until it reaches the middle. This gives LinkedList a");
        System.out.println("time complexity of O(n).");
        System.out.println();
    }
}