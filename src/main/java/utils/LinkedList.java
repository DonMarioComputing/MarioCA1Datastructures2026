package utils;

public class LinkedList implements List{

    private int size;
    private Node first;
    private Node last;

    public LinkedList(){
        clear();
    }

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Validates that the supplied String is not null
     *
     * @param element the value to validate
     * @throws IllegalArgumentException if the supplied value is null
     */
    private static void validateForNull(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Null values are not permitted");
        }
    }

    /**
     * Validates an index for access for get, remove, and set
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if index is outside the range 0 to size - 1
     */
    private void validateIndexAccess(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    /**
     * Validates an index for add operations
     *
     * Adding is allowed at positions from 0 to size inclusive
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if index is outside the range 0 to size
     */
    private void validateIndexAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String get(int index){
        validateIndexAccess(index);

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public void add(String element) {
        validateForNull(element);

        Node newNode = new Node(element);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }


    @Override
    public void add(int index, String element) {
        validateForNull(element);
        validateIndexAdd(index);

        Node newNode = new Node(element);

        //Adding to an empty list
        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        // Adding at the start
        else if (index == 0) {
            newNode.next = first;
            first = newNode;
        }
        // Adding at the end
        else if (index == size) {
            last.next = newNode;
            last = newNode;
        }
        else {
            Node current = first;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    public String remove(int index){
        validateIndexAccess(index);

        String removed;
        if (index == 0) {
            removed = first.data;
            first = first.next;

            if (size == 1) {
                last = null;
            }
        } else {
            Node current = first;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node target = current.next;
            removed = target.data;

            current.next = target.next;

            if (target == last) {
                last = current;
            }
        }

        size--;
        return removed;
    }

    @Override
    public boolean remove(String element) {
        validateForNull(element);

        int index = indexOf(element);

        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(String element) {
        validateForNull(element);

        Node current = first;

        for (int i = 0; i < size; i++) {
            if (current.data.equalsIgnoreCase(element)) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    public boolean contains(String target){
        validateForNull(target);

        return indexOf(target) != -1;
    }

}