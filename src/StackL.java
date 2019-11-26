
public class StackL<T> {
    private Node<T> top;
    private int size;

    /* Constructors ****************************************************************
        TODO 1
        o	One default constructor
        o	One constructor that take a node and starts the stack with this node in it
     */
    StackL() {
        this.top = new Node<T>();
        this.size++;
    }

    StackL(Node<T> root) {
        this.top = root;
        this.size++;
    }


    // Getters *********************************************************************

    /**
     * TODO 2
     * getSize
     *
     * @return the size
     */
    public int getSize() {
        return this.size;
    }


    // Other methods ***************************************************************
    /* 	o	TODO 3: Push: takes data T (see Person.java) and adds it to the stack
     *	o	TODO 4: Pop: void method that removes the top element of the stack, if the stack is not empty
     *	o	TODO 5: Peek: returns the top element of the stack (without removing it)
     *	o	TODO 6: Clear: empties the stack
     *	o	TODO 7: isEmpty: returns true if the stack is empty, false otherwise
     */
    public void push(T data) {
        // Your code goes here
		Node myNode = new Node(data);
        if (isEmpty()) {
			this.top = myNode;
        }
        myNode.setNext(this.top);
        this.top = myNode;

        this.size++;
    }

    public void pop() {
        // Your code goes here
        if (isEmpty()) return;
        this.top = top.getNext();
        this.size--;
    }

    public T peek() {
        if (!isEmpty()) {
            return top.getData();
        }
        return null;
    }

    public void clear() {
        // Your code goes here
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        // Your code goes here
        return this.top == null;
    }

}
