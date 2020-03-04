import java.util.Random;

public class Node {
    private Interval interval;
    private int priority;
    private Node parent, left, right;

    public Node(int data) {
        Random rand = new Random();
        priority = rand.nextInt();
        parent = null;
        left = null;
        right = null;
        interval = null;
    }

    Node getParent() {
        return this.parent;
    }

    Node getLeft() {
        return this.left;
    }

    Node getRight() {
        return this.right;
    }

    Interval getInterv() {
        return this.interval;
    }

    int getIMax() {
        return 0;
    }

    int getPriority() {
        return this.priority;
    }
}
