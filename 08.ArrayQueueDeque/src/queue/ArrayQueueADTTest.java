package queue;

/**
 * @author: Muhammadjon Hakimov
 * created: 03.11.2018 23:14:03
 */

public class ArrayQueueADTTest {
    public static void fillTail(ArrayQueueADT queue) {
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
    }

    public static void fillHead(ArrayQueueADT queue) {
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.push(queue, i);
        }
    }

    public static void dumpTail(ArrayQueueADT queue) {
        while (!ArrayQueueADT.isEmpty(queue)) {
            System.out.println(
                    ArrayQueueADT.size(queue) + " " +
                            ArrayQueueADT.element(queue) + " " +
                            ArrayQueueADT.dequeue(queue)
            );
        }
    }

    public static void dumpHead(ArrayQueueADT queue) {
        while (!ArrayQueueADT.isEmpty(queue)) {
            System.out.println(
                    ArrayQueueADT.size(queue) + " " +
                            ArrayQueueADT.peek(queue) + " " +
                            ArrayQueueADT.remove(queue)
            );
        }
    }

    public static void main(String[] args) {
        ArrayQueueADT queue = new ArrayQueueADT();

        System.out.println("Adding to the end, giving from beginning:");
        fillTail(queue);
        dumpHead(queue);

        System.out.println("==");

        System.out.println("Adding to the beginning, giving from end:");
        fillHead(queue);
        dumpTail(queue);

        fillTail(queue);
        System.out.println("==");
        System.out.println("Size before clearing the queue: " + ArrayQueueADT.size(queue)); // We can also use "isEmpty"
        ArrayQueueADT.clear(queue);
        System.out.println("Size after clearing: " + ArrayQueueADT.size(queue));
    }
}
