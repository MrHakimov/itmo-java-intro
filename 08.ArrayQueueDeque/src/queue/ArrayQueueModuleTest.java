package queue;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.11.2018 23:14:15
 */

public class ArrayQueueModuleTest {
    public static void fillTail() {
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.enqueue(i);
        }
    }

    public static void fillHead() {
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.push(i);
        }
    }

    public static void dumpHead() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(
                    ArrayQueueModule.size() + " " +
                            ArrayQueueModule.element() + " " +
                            ArrayQueueModule.dequeue()
            );
        }
    }

    public static void dumpTail() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(
                    ArrayQueueModule.size() + " " +
                            ArrayQueueModule.peek() + " " +
                            ArrayQueueModule.remove()
            );
        }
    }

    public static void main(String[] args) {
        System.out.println("Adding to the end, giving from beginning:");
        fillTail();
        dumpHead();

        System.out.println("==");

        System.out.println("Adding to the beginning, giving from end:");
        fillHead();
        dumpTail();

        fillTail();
        System.out.println("==");
        System.out.println("Size before clearing the queue: " + ArrayQueueModule.size()); // We can also use "isEmpty"
        ArrayQueueModule.clear();
        System.out.println("Size after clearing: " + ArrayQueueModule.size());
    }
}
