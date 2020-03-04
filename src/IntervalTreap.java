public class IntervalTreap<T extends Comparable<? super T>> {
    private Node root;

    /**
     *  Default constructor.
     */
    public IntervalTreap() {
        root = null;
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

    /* It was hard to decide whether to nest this inside the class or not,
    but I think it makes sense since the nodes should not exist outside of the tree.
    We don't want to expose the nodes without some sort of abstraction.
     */
    public static class Node {
        int max, min;
        public Node(int data) {

        }
        Node getParent() {
            return null;
        }
        Node getLeft() {
            return null;
        }
        Node getRight() {
            return null;
        }
        Interval getInterv() {
            return null;
        }
        int getIMax() {
            return 0;
        }
        int getPriority() {
            return 0;
        }
    }

}
