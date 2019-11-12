import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author: Muhammadjon Hakimov
 * created: 12.11.2018 01:21:09
 */

public abstract class AbstractQueue implements Queue {
    protected int size;

    public void enqueue(Object newElement) {
        assert newElement != null;

        enqueueImpl(newElement);
        size++;
    }

    protected abstract void enqueueImpl(Object element);

    public Object element() {
        assert size > 0;

        return elementImpl();
    }

    protected abstract Object elementImpl();

    public Object dequeue() {
        assert size > 0;

        Object result = element();
        size--;
        dequeueImpl();
        return result;
    }

    protected abstract void dequeueImpl();

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;

        clearImpl();
    }

    public final Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size(); i++) {
            Object temp = dequeue();
            array[i] = temp;
            enqueue(temp);
        }
        return array;
    }

    protected abstract void clearImpl();

    protected abstract Queue sameTypeQueue();

    public Queue filter(Predicate<Object> predicate) {
        Object[] array = toArray();
        Queue queue = sameTypeQueue();
        for (int i = 0; i < size; i++) {
            if (predicate.test(array[i])) {
                queue.enqueue(array[i]);
            }
        }
        return queue;
    }

    public Queue map(Function<Object, Object> function) {
        Object[] array = toArray();
        Queue queue = sameTypeQueue();
        for (int i = 0; i < size; i++) {
            queue.enqueue(function.apply(array[i]));
        }
        return queue;
    }
}
