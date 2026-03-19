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


    /**
     * Returns if the list is currently empty
     *
     * @return true if the list contains no elements, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Validates an index
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if index is outside the range 0 to size - 1
     */
    private void validateIndexForAccess(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Supplied index (" + index + ") is outside bounds of list"
            );
        }
    }

    /**
     * Returns the element stored at the validated index
     *
     * @param index the position to access
     * @return the element at the validated index
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
     */
    public String get(int index) {
        // Validation
        validateIndexForAccess(index);

        Node current = first;

        // Move from node to node until the requested index is reached
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Validates the element is not null
     *
     * @param element the String value to validate
     * @throws IllegalArgumentException if element is null
     */
    private void validateForNull(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Null values are not permitted");
        }
    }

    /**
     * Finds the index of the first case-insensitive match for the supplied element
     *
     * @param element the value to search for
     * @return the index of the first match or -1 if no match is found
     * @throws IllegalArgumentException if the supplied element is null
     */
    public int indexOf(String element) {
        // Validation
        validateForNull(element);

        Node current = first;

        // Move through each node in turn
        for (int i = 0; i < size; i++) {
            if (current.data.equalsIgnoreCase(element)) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    /**
     * Checks whether the supplied element (Search is case-insensitive) exists in the list
     *
     * @param element the value to search for
     * @return true if found, otherwise false
     * @throws IllegalArgumentException if the supplied element is null
     */
    public boolean contains(String element) {
        // Validation
        validateForNull(element);

        // Reuse indexOf logic
        return indexOf(element) != -1;
    }

}