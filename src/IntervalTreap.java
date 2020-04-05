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
            if (z.getKey() <= cur.getKey()) {
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
        } else if (z.getKey() < prev.getKey()) {
            prev.setLeft(z);
            z.setParent(prev);
        } else {
            prev.setRight(z);
            z.setParent(prev);
        }

        size++;

        while (z != this.root && z.getPriority() < z.getParent().getPriority()) {
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
                rotateLeft(z.getParent());
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

        if (z == null) {
            return;
        }

        if (this.root == null) {
            return;
        }

        int val = z.getKey();

        if (cur == this.root) {
            this.root = null;
        }
        // We iterate until we find the node
        while (cur != null) {
            if (z == cur) {
                System.out.println("Found dat sheee");
                break;
            }

            parent = cur;
            if (cur.getKey() > val) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }

        // Case 1: it's a fucking LEAF.
        if (cur.getRight() == null && cur.getLeft() == null) {
            if (cur.getParent() == null)  {
                cur = null;
            } else if (parent.getLeft() == cur) {
               parent.setLeft(null);
            } else if (parent.getRight() == cur) {
               parent.setRight(null);
            }
        // Case 2: The node to be deleted has one child
        } else if (cur.getRight() != null ^ cur.getLeft() != null) {
            if (cur.getRight() != null) {
                parent.setRight(cur.getRight());
            } else {
                parent.setLeft(cur.getLeft());
            }
            cur = null;
        // Case 3: 2 children
        } else {
            // replace by successor
            // kind sketchy imo
            if (parent.getLeft() == cur) {
                parent.setLeft(getInOrderSuccessor(cur));
            } else {
                parent.setRight(getInOrderSuccessor(cur));
            }
        }
        // Update iMax pls

        // Rotations -- Duplicated code but whatever
        while (z != this.root && z.getPriority() < z.getParent().getPriority()) {
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
                rotateLeft(z.getParent());
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
        this.size--;
    }

    public Node getInOrderSuccessor(Node x) {
        if (x.getRight() != null) {
            return getMin(x.getRight());
        }
        Node parent = x.getParent();
        while (parent != null && x == parent.getRight()) {
            x = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    public Node getMin(Node x) {
        Node cur = x;
        while (cur.getLeft() != null) {
            cur = cur.getLeft();
        }
         return cur;
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
                x = x.getLeft();
            } else {
                x = x.getRight();
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
        if(n.getLeft() != null) {
            inorder = printInOrder(n.getLeft(), inorder);
        }
        inorder += "[" + n.getKey() + "],";
        if(n.getRight()!=null){
            inorder = printInOrder(n.getRight(), inorder);
        }
        return inorder;
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
