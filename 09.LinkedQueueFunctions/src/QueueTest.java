/**
 * @author: Muhammadjon Hakimov
 * created: 13.11.2018 10:39:49
 */

public class QueueTest {
    public static void fill(Queue queue) {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
    }

    public static void dump(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " +
                    queue.element() + " " + queue.dequeue());
        }
    }

    public static void test(Queue queue) {
        fill(queue);
        dump(queue);

        fill(queue);
        System.out.println("--");
        System.out.println("Size before clearing the queue: " + queue.size()); // We can also use "isEmpty"
        queue.clear();
        System.out.println("Size after  clearing: " + queue.size());
    }

    public static void main(String[] args) {
        System.out.println("Testing queue.ArrayQueue:");
        test(new ArrayQueue());
        System.out.println("=======");
        System.out.println("Testing queue.LinkedQueue:");
        test(new LinkedQueue());
    }
}
