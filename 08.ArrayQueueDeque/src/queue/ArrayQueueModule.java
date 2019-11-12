package queue;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.11.2018 23:13:19
 */

// INV: FIFO (First in - first out)
public class ArrayQueueModule {
    private static int size = 0;
    private static int headIndex = 0;
    private static Object[] elements = new Object[1];

    // PRE:  size = size*
    // POST: last element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    public static void enqueue(Object newElement) {
        assert newElement != null;

        ensureCapacity(size + 1, false);
        set(size++, newElement);
    }

    private static void set(int index, Object newElement) {
        elements[(headIndex + index) % elements.length] = newElement;
    }

    private static void ensureCapacity(int capacity, boolean addingToHead) {
        if (capacity <= elements.length) {
            return;
        }

        Object[] newElements = new Object[2 * capacity];
        int startIndex = 0;
        if (addingToHead) {
            startIndex = 1;
        }
        for (int i = 0; i < size; i++) {
            newElements[i + startIndex] = elements[(headIndex + i) % elements.length];
        }
        elements = newElements;
        headIndex = 0;
        if (addingToHead) {
            headIndex = 1;
        }
    }

    // PRE:  isEmpty() = false
    // POST: queue - immutable
    //       R = first element of queue
    public static Object element() {
        assert size > 0;

        return elements[headIndex];
    }

    // PRE:  isEmpty() = false && size = size*
    // POST: R = first element of queue
    //       first element of queue = next element
    //       other elements are immutable
    //       size = size* - 1
    public static Object dequeue() {
        assert size > 0;

        size--;
        int currentHeadIndex = headIndex;
        headIndex = (headIndex + 1) % elements.length;
        return elements[currentHeadIndex];
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = size of queue
    public static int size() {
        return size;
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = (size() == 0)
    public static boolean isEmpty() {
        return size == 0;
    }

    // PRE:  None
    // POST: isEmpty() = true
    public static void clear() {
        size = 0;
        headIndex = 0;
        elements = new Object[1];
    }

    // PRE:  size = size*
    // POST: first element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    public static void push(Object newElement) {
        assert newElement != null;

        ensureCapacity(size + 1, true);
        if (headIndex != 0) {
            elements[--headIndex] = newElement;
        } else {
            elements[elements.length - 1] = newElement;
            headIndex = elements.length - 1;
        }
        size++;
    }

    // PRE:  isEmpty() = false
    // POST: queue - immutable
    //       R = last element of queue
    public static Object peek() {
        assert size > 0;

        return elements[(headIndex + size - 1) % elements.length];
    }

    // PRE:  isEmpty() = false && size = size*
    // POST: R = last element of queue
    //       last element of queue = previous element
    //       other elements are immutable
    //       size = size* - 1
    public static Object remove() {
        assert size > 0;

        int tailIndex = (headIndex + size - 1) % elements.length;
        Object returnValue = elements[tailIndex];
        elements[tailIndex] = null;
        size--;
        return returnValue;
    }
}
