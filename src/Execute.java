import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;

public class Execute {

    /* buildNetwork:
     * This method is given to you. It reads information about advisors in a file and builds a tree of
     * these advisors.
     */
    public static BTree<Person> buildNetwork(String filename) throws FileNotFoundException, IOException {
        BTree<Person> network = new BTree<Person>();

        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        String check;
        String[] line;
        String[] person;
        String name, email;
        while (textReader.ready()) {
            check = textReader.readLine();
            line = check.split(" ");
            for (int i = 0; i < line.length; i++) {
                person = line[i].split(",");
                name = person[0];
                email = person[1];
                Person advisor = new Person(name, email);
                network.insertDataAtLocation(person[2], advisor);
            }
        }

        textReader.close();

        return network;
    }

    /*
     * TODO 15: traverseNetwork:
     * This method traverses a BTree in a pre-order fashion, using a Stack (type StackL
     * that you completed earlier).
     */
    public static void traverseNetwork(BTree<Person> network) { // pre-Order
        StackL<BTNode> newStack = new StackL<>();
        if (network.getRoot() == null) return;

        newStack.push(network.getRoot());

        while (!newStack.isEmpty()) {
            BTNode temp = newStack.peek();
            temp.printNode();
            newStack.pop();

            if (temp.getRight() != null) {
                newStack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                newStack.push(temp.getLeft());
            }


        }
    }

    /*
     * TODO 16: levelOrderTraversal:
     * This method traverses a BTree in a level-order fashion, using a Queue (type QueueA
     * that you completed earlier).
     */
    public static void levelOrderTraversal(BTree<Person> network) { // level-Order
        // Your code goes here
        QueueA<BTNode> newQueue = new QueueA<>(network.getSize());
        if (network.getRoot() == null) return;
        newQueue.enqueue(network.getRoot());

        while (!newQueue.isEmpty()) {
            BTNode temp = newQueue.peek();
            temp.printNode();
            newQueue.dequeue();

            if (temp.getLeft() != null) {
                newQueue.enqueue(temp.getLeft());
            }
            if (temp.getRight() != null) {
                newQueue.enqueue(temp.getRight());
            }

        }


    }

    /*
     * TODO 17: exploreBranch:
     * This method traverses and prints the nodes of a given branch of a BTree
     * The branch is described by parameter directions, that is a string composed of letters 'L' and 'R'
     * 'L' indicates that we need to explore the branch going to the left subtree
     * 'R' indicates that we need to explore the branch going to the right subtree
     */
    public static void exploreBranch(BTree<Person> network, String directions) {
        BTNode temp = network.getRoot();
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'L') {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                } else {
                    throw new NullPointerException();
                }
            }
            if (directions.charAt(i) == 'R') {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                }
            }
        }
        temp.printNode();
    }


    /*
     * TODO 18: complete the main method, according to the comment below
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "advisors.txt"/* filename corresponding to advisors.txt */;

        // Here we create a binary tree from the advisors listed in the above text file
        BTree<Person> network = buildNetwork(filename);
        // Once the BTree is built, we print it out
        network.print();
        System.out.println();

        // We traverse and print the BTree called network in a pre-order fashion
        traverseNetwork(network);
        System.out.println();

        // We print the branch of BTree network that is described by "LLRLRLR"
        try { // try and catch block to catch any invalid given directions
            exploreBranch(network, "LLRLRLR");
        }catch (NullPointerException e){
            System.out.println("::INVALID DIRECTION::");
        }
        System.out.println();

        // We traverse and print the BTree called network in a level-order fashion
        levelOrderTraversal(network);

    }
}
