import java.util.Random;

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
        // Assigns random priority


        // Goes down the tree from the root following z.key
        // Inserts as a child of existing node
        // Performs rotations to satisfy the constraint v.priority > v.parent.priority
        //
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

}
