package deque;

import jh61b.junit.In;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    public void addTest(){
        LinkedListDeque<Integer> test1 = new LinkedListDeque<Integer>();
        test1.addFirst(1);
        test1.addFirst(2);
        assertEquals(Integer.valueOf(2), test1.sentinel.next.item);
        test1.addLast(3);
        assertEquals(Integer.valueOf(3), test1.sentinel.prev.item);
    }

    @Test
    public void IsEmptyTest(){
        LinkedListDeque<Integer> test2 = new LinkedListDeque<Integer>();
        assertTrue(test2.isEmpty());
        test2.addLast(1);
        assertFalse("test2 should now cotain 1 item", test2.isEmpty());
    }

    @Test
    public void sizeTest(){
        LinkedListDeque<Integer> test3 = new LinkedListDeque<Integer>();
        assertEquals(0, test3.size());
        test3.addLast(1);
        assertEquals(1, test3.size());
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    public void removeTest(){
        LinkedListDeque<Integer> test4 = new LinkedListDeque<Integer>();
        test4.addLast(1);
        test4.addLast(2);
        test4.addLast(3);
        test4.removeFirst();
        assertEquals(Integer.valueOf(2), test4.sentinel.next.item);
        test4.removeLast();
        assertEquals(Integer.valueOf(2), test4.sentinel.prev.item);
        test4.removeLast();
        assertTrue(test4.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    public void myremoveEmptyTest(){
        LinkedListDeque<Integer> test5 = new LinkedListDeque<Integer>();
        assertEquals("cuole", null, test5.removeFirst());
        test5.addLast(1);
        test5.addFirst(2);
        assertEquals(Integer.valueOf(2), test5.removeFirst());
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    public void getTest(){
        LinkedListDeque<Integer> test6 = new LinkedListDeque<Integer>();
        assertEquals(null, test6.get(0));
        test6.addFirst(1);
        assertEquals(null, test6.get(1));
        test6.addLast(2);
        assertEquals(Integer.valueOf(2), test6.get(1));
        test6.addLast(3);
        test6.addLast(4);
        test6.addLast(5);
        assertEquals(Integer.valueOf(1), test6.get(0));
        assertEquals(Integer.valueOf(5), test6.get(4));
    }

    @Test
    public void IterTest(){
        LinkedListDeque<Integer> test7 = new LinkedListDeque<>();
        test7.addLast(1);
        test7.addLast(2);
        test7.addLast(3);
        for(Integer i : test7){
            System.out.println(i);
        }
    }

    @Test
    public void getrecurTest(){
        LinkedListDeque<Integer> test8 = new LinkedListDeque<>();
        test8.addLast(1);
        test8.addLast(2);
        test8.addLast(3);
        test8.addFirst(1);
        assertEquals("wrong", Integer.valueOf(2), test8.getRecursive(2));
    }
}
