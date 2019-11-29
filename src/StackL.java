
public class StackL<T> {
    private Node<T> top;
    private int size;

    /* Constructors ****************************************************************
        TODO 1
        o	One default constructor
        o	One constructor that take a node and starts the stack with this node in it
     */
    StackL() {
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
    } // return the size;


    // Other methods ***************************************************************
    /* 	o	TODO 3: Push: takes data T (see Person.java) and adds it to the stack
     *	o	TODO 4: Pop: void method that removes the top element of the stack, if the stack is not empty
     *	o	TODO 5: Peek: returns the top element of the stack (without removing it)
     *	o	TODO 6: Clear: empties the stack
     *	o	TODO 7: isEmpty: returns true if the stack is empty, false otherwise
     */
    public void push(T data) {
        // Your code goes here
		Node myNode = new Node(data); //create a new node with the data given
        if (isEmpty()) {
			this.top = myNode; // if stack is empty assign top to myNode
        } else {
            myNode.setNext(this.top); // if stack contains element , assign the next element to the top element (
                                        //  new element placed)
            this.top = myNode; // top is set equal to myNode
        }

        this.size++; // increase size
    }

    public void pop() {
        // Your code goes here
        if (isEmpty()) return;
        // remove the first element of the stack by readjusting the pointer to top.getNext()
        this.top = this.top.getNext();
        this.size--; // decrease size
    }

    public T peek() {
        if (!isEmpty()) {
            return this.top.getData(); // return the element at the top of stack , top.getData()
        }
        return null;
    }

    public void clear() {
        // Your code goes here
        //set the top to null and the size to 0 to reset
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        // Your code goes here
        return this.top == null; // if the top does not have element assigned --> it is empty
    }

}
