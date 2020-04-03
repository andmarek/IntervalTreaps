import java.util.Random;

public class IntervalTreap {
    private Node root;
    private int size;

    /**
     * Default constructor.
     */
    public IntervalTreap() {
        this.root = null;
        size = 0;
    }

    /**
     * Non-default constructor, let's you create one with a root.
     *
     * @param root
     */
    public IntervalTreap(Node root) {
        this.root = root;
        size = 1;
    }

    /**
     * Getter method to return the root of the IntervalTree.
     *
     * @return reference to the root node.
     */
    Node getRoot() {
        return this.root;
    }

    int getSize() {
        return size;
    }

    /**
     * Getter method to retrieve the height of the IntervalTree.
     *
     * @return an integer representing the height of the tree
     */
    int getHeight() {
        return 0;
    }

    /**
     * Adds element x, whose 'interv' field references an interval to the database
     */
    public void intervalInsert(Node z) {

        // Assigns random priority to the new node.
        Random rand = new Random();
        z.setPriority(rand.nextInt());

        // if the tree is null
        if (root == null) {
            root = z;
            size++;
            return;
        }

        // Goes down the tree from the root following z.key
        Node cur = this.root;
        Node prev = null;

        while (cur != null) {
            prev = cur;
            if (z.getInterv().getLow() < cur.getInterv().getLow()) {
                // updates the parents iMax
                if (z.getiMax() > cur.getiMax()) {
                    cur.setIMax(z.getiMax());
                }
                cur = cur.getLeft();
            } else {
                // updates the parents iMax
                if (z.getiMax() > cur.getiMax()) {
                    cur.setIMax(z.getiMax());
                }
                cur = cur.getRight();
            }
        }

        // places the node in the treap
        if (prev == null) {
            prev = z;
        } else if (z.getInterv().getLow() < prev.getInterv().getLow()) {
            prev.setLeft(z);
            z.setParent(prev);
        } else {
            prev.setRight(z);
            z.setParent(z);
        }
        size++;

        while (z.getPriority() < z.getParent().getPriority()) {
            if (z.getParent().getLeft() == z) {
                rotateRight(z);
                //Node r = z.getRight();
                //r.setIMax(Math.max(Math.max(r.getiMax(), r.getLeft().getiMax()), r.getRight().getiMax()));
            } else if (z.getParent().getRight() == z){
                rotateLeft(z);
                //z.getLeft().setIMax(Math.max(Math.max(z.getiMax(), z.getLeft().getiMax()), z.getRight().getiMax()));
            }
        }


        System.out.println("Successful insertion");
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
     *
     * @return
     */
    public Node intervalSearch(Interval i) {
        Node x = this.root;
        while (x != null && !(i.doesOverlap(x.getInterv()))) {
            if (x.getLeft() != null && x.getLeft().getiMax() >= i.getLow()) {
                x.setLeft(x.getLeft());
            } else {
                x.setRight(x.getRight());
            }
        }
        return x;
    }

    /**
     * Prints the keys of an in-order traversal of the tree.
     *
     * @param n
     */
    public void printInOrder(Node n) {
        System.out.println("Print in order");
        if (n == null) {
            return;
        }
        printInOrder(n.getLeft());
        System.out.printf("%s", n.getiMax());
        printInOrder(n.getRight());
    }

    /* From wikipedia pseudo code
     * https://en.wikipedia.org/wiki/Tree_rotation
     */
    public void rotateRight(Node u) {
        Node q = u.getRight();
        u.setRight(q.getLeft());
        q.getLeft().setParent(u);
        q.setLeft(u);
        u.setParent(q);
    }

    /* From wikipedia pseudo code
     * https://en.wikipedia.org/wiki/Tree_rotation
     */
    public void rotateLeft(Node u) {
        Node q = u.getRight();
        u.setRight(q.getLeft());
        q.getLeft().setParent(u);
        q.setLeft(u);
        u.setParent(q);

    }
}
