package shells;

public class DynamicArray_Shell {
    // todo: create a SHARED/STATIC variable to specify how big the internal array should be
    private static final int INITIAL_CAPACITY = 10;
    // todo: create a SHARED/STATIC variable to specify how much to grow the internal array by
    private static final int EXPANSION_FACTOR = 2;

    private String[] data;
    private int size;

    public DynamicArray_Shell() {
        // todo: specify what size array to build
        data = new String[INITIAL_CAPACITY];
        size = 0;

        // Populate with dummy data for testing purposes
        bootstrap();
    }

    /**
     * Constructor allowing custom initial capacity.
     * Capacity must be >= 0.
     *
     * @param initialSize initial capacity for internal array
     * @throws IllegalArgumentException if initialSize is negative
     */
    public DynamicArray_Shell(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Initial size cannot be negative");
        }
        data = new String[initialSize];
        size = 0;
    }

     /**
     * Adds some values so the provided ShellTestBed can immediately show data.
     */
    private void bootstrap() {
        // Ensure array exists
        if (data == null) {
            data = new String[INITIAL_CAPACITY];
        }

        // Ensure there's room for 5 items
        while (data.length < 5) {
            ensureCapacity();
        }

        for (int i = 0; i < 5; i++) {
            data[i] = "Hello " + i;
            size++;
        }
    }


     /**
     * Returns the size of the list.
     *
     * @return The number of elements currently stored in the list
     */
    public int size() {
        // todo: Add code to return the number of elements currently in the list
        return size;
    }

    /**
     * Checks whether the list contains no elements.
     *
     * @return true if size == 0, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index index/position to read
     * @return element at that position
     * @throws IndexOutOfBoundsException if index is < 0 or >= size
     */
    public String get(int index) {
        validateIndexForAccess(index);
        return data[index];
    }

    /**
     * Validate a given index to check if it's within boundaries of the Data in the list.
     *
     * @param index index/position to validate
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     */
    private void validateIndexForAccess(int index) {
        // Must be within the stored elements, not within the array length
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside bounds of list");
        }
    }

    /**
     * Validate an index for inserting; add at position.
     * For inserts allow index == size (insert after last element).
     *
     * @param index insert position
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     */
    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside bounds of list");
        }
    }

    /**
     * Returns the position of the first case-insensitive match for element.
     *
     * @param element element to find (must not be null)
     * @return index of first match, or -1 if not found
     * @throws IllegalArgumentException if element is null
     */
    public int indexOf(String element) {
        validateForNull(element);

        // Linear search through the stored data
        for (int i = 0; i < size; i++) {
            if (data[i].equalsIgnoreCase(element)) {
                return i;
            }
        }

        // Not found
        return -1;
    }


    /**
     * Ensures the internal array can store at least one more element.
     * If full, replaces it with a new larger array.
     */
    private void ensureCapacity() {
        // If internal array is full, expand it
        if (size == data.length) {
            int newCapacity = Math.max(INITIAL_CAPACITY, data.length * EXPANSION_FACTOR);
            // if data.length is 0, multiplying stays 0; make it to INITIAL_CAPACITY
            if (newCapacity == 0) {
                newCapacity = INITIAL_CAPACITY;
            }

            String[] expanded = new String[newCapacity];

            // Copy existing elements into expanded array
            System.arraycopy(data, 0, expanded, 0, size);

            // Swap references so expanded becomes the new backing array
            data = expanded;
        }
    }

    /**
     * Validates that a supplied element is not null.
     *
     * @param element element to validate
     * @throws IllegalArgumentException if element is null
     */
    private void validateForNull(String element) {
        if (element == null) {
            throw new IllegalArgumentException("List does not support null elements");
        }
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element element to add, must not be null
     * @throws IllegalArgumentException if element is null
     */
    public void add(String element) {
        validateForNull(element);

        // Make sure has space
        ensureCapacity();

        // Place the element at the first free slot (index == size)
        data[size] = element;

        // Update
        size++;
    }

    /**
     * Adds an element at a specific index, shifting existing elements right.
     *
     * @param index   insert position
     * @param element element to insert (must not be null)
     * @throws IllegalArgumentException  if element is null
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void add(int index, String element) {
        validateForNull(element);
        validateIndexForAdd(index);

        ensureCapacity();

        // Shift elements right by one from index size-1
        // Copy items starting at 'index' to 'index+1'
        System.arraycopy(data, index, data, index + 1, size - index);

        // Insert new element
        data[index] = element;

        size++;
    }

    /**
     * Checks whether an element exists in the list (case-insensitive).
     *
     * @param element element to search for (must not be null)
     * @return true if present, false otherwise
     * @throws IllegalArgumentException if element is null
     */
    public boolean contains(String element) {
        validateForNull(element);
        return indexOf(element) != -1;
    }


}