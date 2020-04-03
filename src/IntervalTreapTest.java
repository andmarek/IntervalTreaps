import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class IntervalTreapTest {
    Interval val1;
    Interval val2;
    Interval val3;
    Interval val4;
    Interval val5;
    Interval val6;
    Interval val7;
    Interval val8;
    Interval val9;
    Interval val10;


    @BeforeEach
    void setup(){
        val1 = new Interval(0, 3);
        val2 = new Interval(5, 8);
        val3 = new Interval(6, 10);
        val4 = new Interval(8, 9);
        val5 = new Interval(15, 23);
        val6 = new Interval(16, 21);
        val7 = new Interval(17, 19);
        val8 = new Interval(19, 20);
        val9 = new Interval(25, 30);
        val10 = new Interval(26, 26);
    }

    @Test
    void getRoot() {
        IntervalTreap treap = new IntervalTreap();
        assertNull(treap.getRoot());

        Interval root = new Interval(0, 3);
        Node n = new Node(root);
        IntervalTreap treap1 = new IntervalTreap();
        treap1.intervalInsert(n);
        assertEquals(n, treap1.getRoot());
    }

    @Test
    void getSize() {
        IntervalTreap treap = new IntervalTreap();
        Node n1 = new Node(new Interval(0,1));
        treap.intervalInsert(n1);
        assertEquals(1, treap.getSize());
        Node n2 = new Node(new Interval(1,5));
        treap.intervalInsert(n2);
        assertEquals(2, treap.getSize());
        Node n3 = new Node(new Interval(5, 7));
        treap.intervalInsert(n3);
        assertEquals(3, treap.getSize());
    }

    @Test
    void getHeight() {
    }

    @Test
    void intervalInsertRoot(){
        Node root = new Node(new Interval(0, 12));
        IntervalTreap treap = new IntervalTreap();
        treap.intervalInsert(root);

        // testing if it insert node to root
        assertEquals(root, treap.getRoot());
    }

    @Test
    void intervalInsertTest() {

    }

    @Test
    void intervalDelete() {
    }

    @Test
    void intervalSearch() {
    }

    @Test
    void printInOrder() {
    }


}