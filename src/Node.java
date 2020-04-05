import java.util.Random;

public class Node {
    private Interval interval;
    private int iMax, priority;
    private Node parent, left, right;

    public Node() {
        iMax = 0;
        priority = 0;
        parent = null;
        left = null;
        right = null;
        interval = null;
    }

    //edge case Interval is empty?
    public Node(Interval interval){
        this.interval = interval;
        iMax = interval.getHigh();
        parent = null;
        left = null;
        right = null;
        priority = 0;
    }

    public int getiMax() {
        return iMax;
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

    public int getPriority() {
        return this.priority;
    }

    public int getKey() {
       return this.getInterv().getLow();
    }

    public void setIMax(int iMax) {
        this.iMax = iMax;
    }

    //if we set an interval do we need to set iMax?
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
