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

    /**
     * Adds a new element to the end of the list
     *
     * @param element the value to add
     * @throws IllegalArgumentException if the supplied element is null
     */
    public void add(String element) {
        // Validation
        validateForNull(element);

        // Wrap the new value in a node
        Node newNode = new Node(element);

        // First and last both point to the new node if the list is empty
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            // Link the new node after the current last node
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    /**
     * Validates an index
     *
     * Adding is allowed at positions from 0 to size
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if index is outside the range 0 to size
     */
    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Supplied index (" + index + ") is outside bounds of list"
            );
        }
    }


    /**
     * Adds a new element at the supplied position
     *
     * @param index the position at which to insert the new element
     * @param element the value to insert
     * @throws IllegalArgumentException if the supplied element is null
     * @throws IndexOutOfBoundsException if index is outside the range 0 to size
     */
    public void add(int index, String element) {
        // Validation
        validateForNull(element);
        validateIndexForAdd(index);

        Node newNode = new Node(element);

        // Adding to an empty list
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        }
        // Adding at the start of a non-empty list
        else if (index == 0) {
            newNode.next = first;
            first = newNode;
        }
        // Adding at the end
        else if (index == size) {
            last.next = newNode;
            last = newNode;
        }
        // Adding somewhere in the middle
        else {
            Node current = first;

            // Move to the node before the insertion
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // Insert the new node
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    /**
     * Removes and returns the element at the supplied index
     *
     * @param index the position to remove from
     * @return the removed element
     * @throws IndexOutOfBoundsException if index is outside the range 0 to size - 1
     */
    public String remove(int index) {
        // Validation
        validateIndexForAccess(index);

        String removed;

        // Remove the first element
        if (index == 0) {
            removed = first.data;
            first = first.next;

            // If the list had only one element, last must also become null
            if (size == 1) {
                last = null;
            }
        } else {
            Node current = first;

            // Move to the node before the one to remove
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node target = current.next;
            removed = target.data;

            current.next = target.next;

            // Update last if the removed node was the last node
            if (target == last) {
                last = current;
            }
        }

        size--;

        return removed;
    }

    /**
     * Removes the first case-insensitive instance of the supplied element
     *
     * @param element the value to remove
     * @return true if the element was found and removed, otherwise false
     * @throws IllegalArgumentException if the supplied element is null
     */
    public boolean remove(String element) {
        // Validation
        validateForNull(element);

        // Find the first occurrence
        int index = indexOf(element);

        // Nothing can be removed if not found
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

}