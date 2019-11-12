/**
 * @author: Muhammadjon Hakimov
 * created: 11.11.2018 21:34:02
 */

import java.util.function.Function;
import java.util.function.Predicate;

// INV: FIFO (First in - first out)
public interface Queue {
    // PRE:  size = size*
    // POST: last element of queue = newElement,
    //       previous elements are immutable
    //       size = size* + 1
    /*public*/ void enqueue(Object newElement);

    // PRE:  isEmpty() = false
    // POST: queue - immutable
    //       R = first element of queue
    /*public*/ Object element();

    // PRE:  isEmpty() = false && size = size*
    // POST: R = first element of queue
    //       first element of queue = next element
    //       other elements are immutable
    //       size = size* - 1
    /*public*/ Object dequeue();

    // PRE:  None
    // POST: queue - immutable
    //       R = size of queue
    /*public*/ int size();

    // PRE:  None
    // POST: queue - immutable
    //       R = (size() == 0)
    /*public*/ boolean isEmpty();

    // PRE:  None
    // POST: isEmpty() = true
    /*public*/ void clear();

    // PRE:  None
    // POST: R = array of queue elements
    //       from first to last element
    //       queue - immutable
    Object[] toArray();

    // PRE:  predicate != null;
    // POST: queue - immutable
    //       R = new queue with elements filtered by predicate
    Queue filter(Predicate<Object> predicate);

    // PRE:  function != null;
    // POST: queue - immutable
    //       R = new queue of elements gotten by
    //       performing a function on elements of
    //       current queue
    Queue map(Function<Object, Object> function);
}
