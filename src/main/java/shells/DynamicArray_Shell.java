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



}