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

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
