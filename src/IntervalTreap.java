/**
 * @
 */

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
            z.setParent(prev);
        }
        size++;

        while (z.getParent() != null && z.getPriority() < z.getParent().getPriority()) {
            if (z.getParent().getLeft() == z) {
                rotateRight(z.getParent());
                Node r = z.getRight();
                r.setIMax(r.getInterv().getHigh());
                if (r.getRight() != null && r.getRight().getiMax() > r.getiMax()) {
                    r.setIMax(r.getRight().getiMax());
                }
                if (r.getLeft() != null && r.getLeft().getiMax() > r.getiMax()) {
                    r.setIMax(r.getLeft().getiMax());
                }
            } else if (z.getParent().getRight() == z) {
                rotateLeft(z.getParent()); //
                Node l = z.getLeft();
                l.setIMax(l.getInterv().getHigh());
                if (l.getRight() != null && l.getRight().getiMax() > l.getiMax()) {
                    l.setIMax(l.getRight().getiMax());
                }
                if (l.getLeft() != null && l.getLeft().getiMax() > l.getiMax()) {
                    l.setIMax(l.getLeft().getiMax());
                }
            }

        }
        System.out.println("Successful insertion");
        // Performs rotations to satisfy the constraint v.priority > v.parent.priority
    }

    /**
     * Removes some element x from the database
     */
    public void intervalDelete(Node z) {
        Node cur = this.root;
        Node parent = null;

        if (z == null) return;
        if (this.root == null) return;

        int val = z.getInterv().getLow();

        // We iterate until we find the node
        while (cur != null) {
            if (z == cur) {
                System.out.println("Found dat sheee");
                break;
            }

            parent = cur;
            if (cur.getInterv().getLow() > val) {
                cur = cur.getLeft();
            } else if (cur.getInterv().getLow() < val) {
                cur = cur.getRight();
            }
        }
        if (parent == null) {
            deleteHelper(cur);
        }

        // whatever cur is should be the node we need to delete
        if (cur.getLeft() == null && cur.getRight() != null)  {
            cur = cur.getRight();
        } else if (cur.getLeft() != null && cur.getRight() == null) {
            cur = cur.getLeft();
        } else {

        }

        // perform rotations then
        while (z.getLeft() != null || z.getRight() != null) {
            if (z.getLeft() == null) {
                rotateLeft(z);
            } else if (z.getRight() == null) {
                rotateRight(z);
            } else if (z.getLeft().getParent().getKey() < z.getRight().getRight().getKey()) {
                rotateRight(z);
            } else {
                rotateLeft(z);
            }
            if (this.root == z) {
                this.root = z.getParent();
            }
        }
    }

    // could be void since we're not actually passing it
    public Node deleteHelper(Node z) {
        if (z != null) {
            if (z.getLeft() == null && z.getRight() == null) {
                return null;
            }
            // case of two children
            if (z.getLeft() != null && z.getRight() != null) {
                Node inOrderSuccessor = deleteInOrderSuccessorDup(z);
            } else if (z.getLeft() != null) {
                // case one - left child
                z = z.getLeft();
            } else {
                // case two - right child
                z = z.getRight();
            }
        }
        return z;
    }

    public Node deleteInOrderSuccessorDup(Node z) {
        Node parent = z;
        z = z.getRight();
        while (z.getLeft() != null) {
            parent = z;
            z = z.getLeft();
        }
        if (z.getLeft() == null) {
            parent.setRight(z.getRight());
        } else {
            parent.setLeft(z.getRight());
        }
        z.setRight(null);
        return z;
    }

    /**
     * Returns a reference to an element x in the interval database such that x.interv overlaps
     * interval i
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
        if (n == null) {
            return inorder;
        }
        printInOrder(n.getLeft(), inorder);
        inorder += "[" + n.getInterv().getLow() + "],";
        return printInOrder(n.getRight(), inorder);
    }

    /* From wikipedia pseudo code
     * https://en.wikipedia.org/wiki/Tree_rotation
     */
    public void rotateLeft(Node u) {
        Node w = u.getRight();

        w.setParent(u.getParent());
        if (w.getParent() != null) {
            if (w.getParent().getLeft() == u) {
                w.getParent().setLeft(w);
            } else {
                w.getParent().setRight(w);
            }
        }
        u.setRight(w.getLeft());
        if (u.getRight() != null) {
            u.getRight().setParent(u);
        }
        u.setParent(w);
        w.setLeft(u);
        if (u == this.root) {this.root = w; root.setParent(null); }
    }

    /* From wikipedia pseudo code
     * https://en.wikipedia.org/wiki/Tree_rotation
     */
    public void rotateRight(Node u) {
        Node w = u.getLeft();
        w.setParent(u.getParent());
        if (w.getParent() != null) {
            if (w.getParent().getLeft() == u) {
                w.getParent().setLeft(w);
            } else {
                w.getParent().setRight(w);
            }
        }
        u.setLeft(w.getRight());
        if (u.getLeft() != null) {
            u.getLeft().setParent(u);
        }
        u.setParent(w);
        w.setRight(u);
        if (u == this.root) {
            this.root = w;
            this.root.setParent(null);
        }
    }
}
