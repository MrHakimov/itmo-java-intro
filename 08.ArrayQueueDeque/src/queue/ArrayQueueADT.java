package queue;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.11.2018 23:13:01
 */

// INV: FIFO (First in - first out)
public class ArrayQueueADT {
    private int size = 0;
    private int headIndex = 0;
    private Object[] elements = new Object[1];

    // PRE:  size = size*
    // POST: last element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    public static void enqueue(ArrayQueueADT queue, Object newElement) {
        assert newElement != null;

        ensureCapacity(queue, queue.size + 1, false);
        set(queue, queue.size++, newElement);
    }

    private static void set(ArrayQueueADT queue, int index, Object newElement) {
        queue.elements[(queue.headIndex + index) % queue.elements.length] = newElement;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity, boolean addingToHead) {
        if (capacity <= queue.elements.length) {
            return;
        }

        Object[] newElements = new Object[2 * capacity];
        int startIndex = 0;
        if (addingToHead) {
            startIndex = 1;
        }
        for (int i = 0; i < queue.size; i++) {
            newElements[i + startIndex] = queue.elements[(queue.headIndex + i) % queue.elements.length];
        }
        queue.elements = newElements;
        queue.headIndex = 0;
        if (addingToHead) {
            queue.headIndex = 1;
        }
    }

    // PRE:  isEmpty() = false
    // POST: queue - immutable
    //       R = first element of queue
    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;

        return queue.elements[queue.headIndex];
    }

    // PRE:  isEmpty() = false && size = size*
    // POST: R = first element of queue
    //       first element of queue = next element
    //       other elements are immutable
    //       size = size* - 1
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;

        queue.size--;
        int currentHeadIndex = queue.headIndex;
        queue.headIndex = (queue.headIndex + 1) % queue.elements.length;
        return queue.elements[currentHeadIndex];
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = size of queue
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // PRE:  None
    // POST: queue - immutable
    //       R = (size() == 0)
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // PRE:  None
    // POST: isEmpty() = true
    public static void clear(ArrayQueueADT queue) {
        queue.size = 0;
        queue.headIndex = 0;
        queue.elements = new Object[1];
    }

    // PRE:  size = size*
    // POST: first element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    public static void push(ArrayQueueADT queue, Object newElement) {
        assert newElement != null;

        ensureCapacity(queue, queue.size + 1, true);
        if (queue.headIndex != 0) {
            queue.elements[--queue.headIndex] = newElement;
        } else {
            queue.elements[queue.elements.length - 1] = newElement;
            queue.headIndex = queue.elements.length - 1;
        }
        queue.size++;
    }

    // PRE:  isEmpty() = false
    // POST: queue - immutable
    //       R = last element of queue
    public static Object peek(ArrayQueueADT queue) {
        assert queue.size > 0;

        return queue.elements[(queue.headIndex + queue.size - 1) % queue.elements.length];
    }

    // PRE:  isEmpty() = false && size = size*
    // POST: R = last element of queue
    //       last element of queue = previous element
    //       other elements are immutable
    //       size = size* - 1
    public static Object remove(ArrayQueueADT queue) {
        assert queue.size > 0;

        int tailIndex = (queue.headIndex + queue.size - 1) % queue.elements.length;
        Object returnValue = queue.elements[tailIndex];
        queue.elements[tailIndex] = null;
        queue.size--;
        return returnValue;
    }
}
