import java.util.NoSuchElementException;

public class QueueA<T extends Object> {
    /*	ATTRIBUTES: *********************************************
     *  o	Head (an integer index)
     * 	o	Tail (an integer index)
     * 	o	Size
     * 	o	Array of integers
     */
    private int head;
    private int tail;
    private int size;
    private T[] queue;

    /* CONSTRUCTOR: *********************************************/
    public QueueA(int num) {
        queue = (T[]) new Object[num]; //new T[num];
        size = 0;
        head = -1;
        tail = 0;
    }

    /* GETTERS: *************************************************/

    /**
     * TODO 8
     * getSize
     *
     * @return the size
     */
    public int getSize() {
        return this.size;
    }


    /* OTHER METHODS: *******************************************
     *	o	TODO 9: Enqueue: takes data and adds it to the queue if it is not full
     * 	o	TODO 10: Dequeue: method that removes the head of the queue, if the queue is not empty, and returns this element
     *	o	TODO 11: Peek: returns the head element of the queue (without removing it)
     *	o	TODO 12: Clear: empties the queue
     *	o	TODO 13: isEmpty: returns true if the queue is empty, false otherwise
     * 	o	TODO 14: isFull: returns true if the queue is full, false otherwise
     */
    public void enqueue(T data) {
        // You code goes here
        if(isFull()){ // if is full , throw exception
            throw new IllegalStateException("::Queue is full::");
        }
        this.queue[tail] = data; // set queue[tail] equal to given data
        this.tail = (this.tail + 1) % this.queue.length; // readjust tail
        this.size++; // increase size
    }

    public T dequeue() {
        // You code goes here
        if (isEmpty()) { // if queue is empty, throw an exception
            throw new NoSuchElementException("::Queue is empty::");
        }
        T temp = this.queue[this.head + 1]; // create a temporary variable to return dequeued element
        this.queue[this.head + 1] = null; // remove element at head + 1
        this.head = (this.head + 1) % this.queue.length; // readjust head
        this.size--; //decrease size
		return temp;
    }

    public void clear() {
        // You code goes here
        //reset all of the class variables to the original values
        this.size = 0;
        this.head = -1;
        this.tail = 0;
        this.queue = null;
    }

    public T peek() {
        // You code goes here
        if (!isEmpty()) { // if queue is not empty, return the first element in the queue
            return queue[head + 1];
        }
        return null; // if empty return null;
    }

    public boolean isEmpty() {
        // You code goes here
        return size == 0; // isEmpty when queue size is 0
    }

    public boolean isFull() {
        // You code goes here
        return size == queue.length; // is full when the queue size is equal to num in the constructor. ( queue.length)
    }

}
