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
     * Getter method to retrieve the height of the IntervalTree
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
            } else if (z.getParent().getRight() == z) {
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
        // Find the node
        if (this.root == null)
            return;

        Node cur = this.root;
        Node p = null;
        int val = z.getInterv().getLow();

        while (true) {
            if (val > cur.getInterv().getLow()) {
                /* val is greater, and the right child isn't null, then
                 * we move down the tree */
                if (cur.getRight() != null) {
                    p = cur;
                    cur = cur.getRight();
                } else {
                    System.out.println("Hey we good bro, we ain't got nothing man.");
                    break;
                }
            } else if (val < cur.getInterv().getLow()) {
                /* val is greater, and the right child isn't null, then
                we move down the tree */
                if (cur.getLeft() != null) {
                    p = cur;
                    cur = cur.getLeft();
                }
            } else {
                if (cur.getLeft() == null && cur.getRight() == null) {
                    if (p == null) {
                        this.root = null;
                    } else if (p.getLeft().getInterv().getLow() == cur.getInterv().getLow()) {
                        p.setLeft(null);
                    } else {
                        p.setRight(null);
                    }
                } else if (cur.getLeft() == null) {
                    if (p == null) {
                        this.root = cur.getRight();
                    } else if (p.getLeft().getInterv().getLow() == cur.getInterv().getLow()) {
                        p.setLeft(cur.getRight());
                    } else {
                        p.setRight(cur.getRight());
                    }
                } else if (cur.getRight() == null) {
                    if (p == null) {
                        this.root = cur.getLeft();
                    } else if (p.getLeft().getInterv().getLow() == cur.getInterv().getLow()) {
                        p.setLeft(cur.getRight());
                    } else {
                        p.setRight(cur.getRight());
                    }
                } else {
                    int successorNodeKey = getSuccessorNodeKey(z);
                    //intervalDelete();
                    cur.getInterv().setLow(successorNodeKey);
                }
            }
        }
    }

    public int getSuccessorNodeKey(Node n) {
        while (true) {
            if (n.getLeft() != null) {
                n = n.getLeft();
            } else {
                break;
            }
        }
        return n.getInterv().getLow();
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
    public String printInOrder(Node n, String inorder) {
        System.out.println("Print in order");
        if (n == null) {
            return inorder;
        }

        printInOrder(n.getLeft(), inorder);
        inorder += "[" + n.getInterv().getLow() + "],";
        printInOrder(n.getRight(), inorder);
        return inorder;
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
