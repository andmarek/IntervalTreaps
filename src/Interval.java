public class Interval {
    private int low, high;

    /**
     * Default Constructor
     */
    public Interval() {
    }

    /**
     * Constructor for interval creation
     * @param low
     * @param high
     */
    public Interval(int low, int high){
        this.low = low;
        this.high = high;
    }

    /**
     * sets the low interval of the node
     * @return the upper endpoint of the interval.
     */
    int getLow() {
        return this.low;
    }

    /**
     * sets the low interval of the node
     * @param low
     */
    void setLow( int low ){ this.low = low; }

    /**
     * @return the lower endpoint of the interval.
     */
    int getHigh() {
        return high;
    }

    /**
     * sets the max interval of the node
     * @param high
     */
    void setHigh(int high){ this.high = high; }

    boolean doesOverlap(Interval i) {
        if (this.high < i.low)  {
            return false;
        } else if (i.high < this.low) {
            return false;
        } else {
            return true;
        }
    }
}
