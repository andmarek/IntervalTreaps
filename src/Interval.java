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
        low = this.low;
        high = this.high;
    }

    /**
     * sets the low interval of the node
     * @return the upper endpoint of the interval.
     */
    int getLow() {
        return low;
    }

    /**
     * sets the low interval of the node
     * @param low
     */
    void setLow( int low ){ low = this.low; }

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
    void setHigh(int high){ high = this.high; }
}
