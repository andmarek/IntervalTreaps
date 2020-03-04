import java.util.Random;

public class Node {
    private Interval interval;
    private int key, priority;
    private Node parent, left, right;

    public Node(int data) {
        key = 0;
        priority = 0;
        parent = null;
        left = null;
        right = null;
        interval = null;
    }

    public int getKey() {
        return key;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Interval getInterv() {
        return this.interval;
    }

    public int getIMax() {
        return 0;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setKey(int key) {
        this.key = key;
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
