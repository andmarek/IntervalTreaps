import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


class IntervalTreapTest {
    Node n1;
    Node n2;
    Node n3;
    Node n4;
    Node n5;
    Node n6;
    Node n7;
    Node n8;
    Node n9;
    Node n10;




    @BeforeEach
    void setup(){
        n1 = new Node(new Interval(0, 3));
        n2 = new Node(new Interval(5, 8));
        n3 = new Node(new Interval(6, 10));
        n4 = new Node(new Interval(8, 9));
        n5 = new Node(new Interval(15, 23));
        n6 = new Node(new Interval(16, 21));
        n7 = new Node(new Interval(17, 19));
        n8 = new Node(new Interval(19, 20));
        n9 = new Node(new Interval(25, 30));
        n10 = new Node(new Interval(26, 26));
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
        treap.intervalInsert(n1);
        assertEquals(1, treap.getSize());
        treap.intervalInsert(n2);
        assertEquals(2, treap.getSize());
        treap.intervalInsert(n3);
        assertEquals(3, treap.getSize());
    }

    @Test
    void getHeight() {
    }

    @Test
    void intervalInsertRoot(){
        IntervalTreap treap = new IntervalTreap();
        treap.intervalInsert(n1);

        // testing if it insert node to root
        assertEquals(n1, treap.getRoot());
    }

    @Test
    void intervalInsertTest() {
        IntervalTreap treap = new IntervalTreap();
        IntervalTreap treap2 = new IntervalTreap();
        IntervalTreap treap3 = new IntervalTreap();
//        treap.intervalInsert(n1);
//        treap.intervalInsert(n2);
//        treap.intervalInsert(n3);
//        treap.intervalInsert(n4);
//        treap.intervalInsert(n5);
//        treap.intervalInsert(n6);
//        treap.intervalInsert(n7);
//        treap.intervalInsert(n8);
//        treap.intervalInsert(n9);
//        treap.intervalInsert(n10);
//
//        assertEquals("[0],[5],[6],[8],[15],[16],[17],[19],[25],[26],", treap.printInOrder(treap.getRoot(), ""));
//
//        treap2.intervalInsert(n5);
//        treap2.intervalInsert(n6);
//        treap2.intervalInsert(n7);
//        treap2.intervalInsert(n8);
//        treap2.intervalInsert(n9);
//        treap2.intervalInsert(n10);
//        treap2.intervalInsert(n1);
//        treap2.intervalInsert(n2);
//        treap2.intervalInsert(n3);
//        treap2.intervalInsert(n4);
//        assertEquals("[0],[5],[6],[8],[15],[16],[17],[19],[25],[26],", treap2.printInOrder(treap2.getRoot(), ""));

        treap3.intervalInsert(n5);
        treap3.intervalInsert(n1);
        treap3.intervalInsert(n6);
        treap3.intervalInsert(n2);
        treap3.intervalInsert(n7);
        treap3.intervalInsert(n3);
        treap3.intervalInsert(n8);
        treap3.intervalInsert(n4);
        treap3.intervalInsert(n9);
        treap3.intervalInsert(n10);
        assertEquals("[0],[5],[6],[8],[15],[16],[17],[19],[25],[26],", treap3.printInOrder(treap3.getRoot(), ""));

    }

    @Test
    void intervalDelete() {
    }

    @Test
    void intervalSearch() {
    }

    @Test
    void printRoot(){
        Node root = new Node(new Interval(0, 12));
        IntervalTreap treap = new IntervalTreap();
        treap.intervalInsert(root);
        String actual = treap.printInOrder(root, "");
        assertEquals("[0],", actual);

    }

    @Test
    void printInOrderTest() {
        IntervalTreap treap = new IntervalTreap();
        treap.intervalInsert(n1);
        String actual = treap.printInOrder(treap.getRoot(), "");
        assertEquals("[0],", actual);
        treap.intervalInsert(n2);
        String actual2 = treap.printInOrder(treap.getRoot(), "");
        assertEquals("[0],[5],", actual2);
        treap.intervalInsert(n3);
        String actual3 = treap.printInOrder(treap.getRoot(), "");
        assertEquals("[0],[5],[6],", actual3);
        treap.intervalInsert(n4);
        String actual4 = treap.printInOrder(treap.getRoot(), "");
        assertEquals("[0],[5],[6],[8],", actual4);

    }


}