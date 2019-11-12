package queue;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.11.2018 23:13:49
 */

public class ArrayQueueTest {
    public static void fillTail(ArrayQueue queue) {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
    }

    public static void fillHead(ArrayQueue queue) {
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
    }

    public static void dumpHead(ArrayQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " +
                    queue.element() + " " + queue.dequeue());
        }
    }

    public static void dumpTail(ArrayQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " +
                    queue.peek() + " " + queue.remove());
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        System.out.println("Adding to the end, giving from beginning:");
        fillTail(queue);
        dumpHead(queue);

        System.out.println("==");

        System.out.println("Adding to the beginning, giving from end:");
        fillHead(queue);
        dumpTail(queue);

        fillTail(queue);
        System.out.println("==");
        System.out.println("Size before clearing the queue: " + queue.size()); // We can also use "isEmpty"
        queue.clear();
        System.out.println("Size after clearing: " + queue.size());
    }
}
