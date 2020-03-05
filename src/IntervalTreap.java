import java.util.Random;

public class IntervalTreap {
    private Node root;

    /**
     *  Default constructor.
     */
    public IntervalTreap() {
        this.root = null;
    }

    /**
     * Non-default constructor, let's you create one with a root.
     * @param root
     */
    public IntervalTreap(Node root) {
        this.root = root;
    }
    /**
     * Getter method to return the root of the IntervalTree.
     * @return reference to the root node.
     */
    Node getRoot() {
        return this.root;
    }

    int getSize() {
        return 0;
    }

    /**
     *  Getter method to retrieve the height of the IntervalTree.
     * @return an integer representing the height of the tree
     */
    int getHeight() {
        return 0;
    }

    /**
     * Adds element x, whose 'interv' field references an interval to the database
     */
    public void intervalInsert(Node z) {
        // Assigns random priority
        Random rand = new Random();
        z.setPriority(rand.nextInt());

        // Goes down the tree from the root following z.key
        Node cur = this.root;
        Node prev = null;

        while (cur != null) {
            prev = cur;
            if (z.getKey() < cur.getKey()) {
               cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }

        if (prev == null) {
            prev = z;
        } else if (z.getKey() < prev.getKey()) {
            prev.setLeft(z);
        } else {
            prev.setRight(z);
        }

        System.out.println("Successeful insertion");
        // Performs rotations to satisfy the constraint v.priority > v.parent.priority
    }

    /**
     * Removes some element x from the database
     */
    public void intervalDelete(Node z) {

    }

    /**
     * Returns a reference to an element x in the interval database such that x.interv overlaps
     * interval i
     * @return
     */
    public Node intervalSearch(Interval i) {
        return null;
    }

    /**
     * Prints the keys of an in-order traversal of the tree.
     * @param n
     */
    public void printInOrder(Node n) {
        System.out.println("Print in order");
        if (n == null)  {
            return;
        }
        printInOrder(n.getLeft());
        System.out.printf("%s", n.getKey());
        printInOrder(n.getRight());
    }
}
