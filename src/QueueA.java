
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
	 * @return the size
	 */
	public int getSize(){
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
		if(!isFull()){
			this.queue[tail]= data;
			this.size++;
			this.tail++;
		}
		return;
	}

	public T dequeue() {
        // You code goes here
		if(!isEmpty()){
			this.head = (this.head + 1) % this.queue.length;
			this.size--;
			this.tail--;
		}
		return null;
	}

	public void clear() {
        // You code goes here
		this.size = 0;
		this.head = -1;
		this.tail = 0;
		this.queue = null;
	}

	public T peek() {
        // You code goes here
		if(!isEmpty()){
			return queue[head];
		}
		return null;
	}

	public boolean isEmpty() {
        // You code goes here
		return queue.length == 0;
	}

	public boolean isFull() {
        // You code goes here
		return size == queue.length;
	}

}
