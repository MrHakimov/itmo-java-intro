package queue;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.11.2018 23:12:34
 */

// INV: FIFO (First in - first out)
public class ArrayQueue {
    private int size = 0;
    private int headIndex = 0;
    private Object[] elements = new Object[1];

    // PRE:  size = size*
    // POST: last element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    public void enqueue(Object newElement) {
        assert newElement != null;

        ensureCapacity(size + 1, false);
        set(size++, newElement);
    }

    private void set(int index, Object newElement) {
        elements[(headIndex + index) % elements.length] = newElement;
    }

    private void ensureCapacity(int capacity, boolean addingToHead) {
        if (capacity > elements.length) {
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
    }

    // PRE:  isEmpty() = false
    // POST: queue - immutable
    //       R = first element of queue
    public Object element() {
        assert size > 0;

        return elements[headIndex];
    }

    // PRE:  isEmpty() = false && size = size*
    // POST: R = first element of queue
    //       first element of queue = next element
    //       other elements are immutable
    //       size = size* - 1
    public Object dequeue() {
        assert !isEmpty();

        size--;
        int currentHeadIndex = headIndex;
        headIndex = (headIndex + 1) % elements.length;
        return elements[currentHeadIndex];
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = size of queue
    public int size() {
        return size;
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = (size() == 0)
    public boolean isEmpty() {
        return size == 0;
    }

    // PRE:  None
    // POST: isEmpty() = true
    public void clear() {
        size = 0;
        headIndex = 0;
        elements = new Object[1];
    }

    // PRE:  size = size*
    // POST: first element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    public void push(Object newElement) {
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
    public Object peek() {
        assert size > 0;

        return elements[(headIndex + size - 1) % elements.length];
    }

    private Object get(int index) {
        return elements[(headIndex + index) % elements.length];
    }

    // PRE:  isEmpty() = false && size = size*
    // POST: R = last element of queue
    //       last element of queue = previous element
    //       other elements are immutable
    //       size = size* - 1
    public Object remove() {
        assert size > 0;

        Object returnValue = get(size - 1);
        elements[(headIndex + size - 1) % elements.length] = null;
        size--;
        return returnValue;
    }
}
