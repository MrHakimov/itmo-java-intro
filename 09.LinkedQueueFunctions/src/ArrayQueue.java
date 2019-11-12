/**
 * @author: Muhammadjon Hakimov
 * created: 12.11.2018 01:22:32
 */

public class ArrayQueue extends AbstractQueue {
    private int headIndex = 0;
    private Object[] elements = new Object[1];

    protected void enqueueImpl(Object newElement) {
        ensureCapacity(size + 1);
        set(size, newElement);
    }

    private void set(int index, Object newElement) {
        elements[(headIndex + index) % elements.length] = newElement;
    }

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }

        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(headIndex + i) % elements.length];
        }
        elements = newElements;
        headIndex = 0;
    }

    protected Object elementImpl() {
        return elements[headIndex];
    }

    protected void dequeueImpl() {
        headIndex = (headIndex + 1) % elements.length;
    }

    public int size() {
        return size;
    }

    protected void clearImpl() {
        headIndex = 0;
        elements = new Object[1];
    }

    protected Queue sameTypeQueue() {
        return new ArrayQueue();
    }
}
