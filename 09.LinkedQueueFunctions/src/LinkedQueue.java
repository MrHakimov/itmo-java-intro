/**
 * @author: Muhammadjon Hakimov
 * created: 12.11.2018 01:29:12
 */

public class LinkedQueue extends AbstractQueue {
    private Node head;
    private Node tail;

    protected void enqueueImpl(Object newElement) {
        Node newNode = new Node(newElement, null);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    protected Object elementImpl() {
        return head.value;
    }

    protected void dequeueImpl() {
        head = head.next;
    }

    public int size() {
        return size;
    }

    protected void clearImpl() {
        head.next = null;
        head.value = null;
        tail.next = null;
        tail.value = null;
    }

    protected Queue sameTypeQueue() {
        return new LinkedQueue();
    }

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            if (next != null) {
                this.next = next;
            }
        }
    }
}
