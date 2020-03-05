
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class IntervalTest {
    Interval val1 = new Interval(0, 3);
    Interval val2 = new Interval(5, 8);
    Interval val3 = new Interval(6, 10);
    Interval val4 = new Interval(8, 9);
    Interval val5 = new Interval(15, 23);
    Interval val6 = new Interval(16, 21);
    Interval val7 = new Interval(17, 19);
    Interval val8 = new Interval(19, 20);
    Interval val9 = new Interval(25, 30);
    Interval val10 = new Interval(26, 26);

    @Test
    void getLow() {
        assertEquals(0, val1.getLow());
        assertEquals(5, val2.getLow());
        assertEquals(6, val3.getLow());
        assertEquals(8, val4.getLow());
        assertEquals(15, val5.getLow());
        assertEquals(16, val6.getLow());
        assertEquals(17, val7.getLow());
        assertEquals(19, val8.getLow());
        assertEquals(25, val9.getLow());
        assertEquals(26, val10.getLow());
    }

    @Test
    void setLow() {
        Interval updateVal = new Interval(0, 4);
        updateVal.setLow(2);
        assertEquals(2, updateVal.getLow());
    }

    @Test
    void getHigh() {
        assertEquals(3, val1.getHigh());
        assertEquals(8, val2.getHigh());
        assertEquals(10, val3.getHigh());
        assertEquals(9, val4.getHigh());
        assertEquals(23, val5.getHigh());
        assertEquals(21, val6.getHigh());
        assertEquals(19, val7.getHigh());
        assertEquals(20, val8.getHigh());
        assertEquals(30, val9.getHigh());
        assertEquals(26, val10.getHigh());
    }

    @Test
    void setHigh() {
        Interval updateVal = new Interval(0, 4);
        updateVal.setHigh(8);
        assertEquals(8, updateVal.getHigh());
    }
}