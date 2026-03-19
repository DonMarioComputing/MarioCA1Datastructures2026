package shells;

public class LinkedList_Shell{

    private Node first;
    private Node last;
    private int size;

    /**
     * Constructs an empty linked list
     */
    public LinkedList_Shell() {
        first = null;
        last = null;
        size = 0;
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Returns the number of elements currently stored in the list
     *
     * @return current number of elements in the list
     */
    public int size() {
        return size;
    }


}