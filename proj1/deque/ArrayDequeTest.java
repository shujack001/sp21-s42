package deque;
import jh61b.junit.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addfirstTest(){
        ArrayDeque<Integer> test1 = new ArrayDeque<Integer>();
        test1.addFirst(1);
        test1.addFirst(2);
        test1.addFirst(3);
        test1.addFirst(4);
        test1.addFirst(5);
        test1.addFirst(6);
        test1.addFirst(7);
        test1.addLast(8);
        test1.addLast(9);
        assertEquals(9, test1.size());
    }

    @Test
    public void isEmptyTest(){
        ArrayDeque<Integer> test2 = new ArrayDeque<Integer>();
        assertTrue(test2.isEmpty());
        test2.addLast(1);
        assertFalse(test2.isEmpty());
    }

    @Test
    public void printDequeTest(){
        ArrayDeque<Integer> test3 = new ArrayDeque<Integer>();
        test3.addFirst(1);
        test3.addFirst(2);
        test3.addFirst(3);
        test3.addFirst(4);
        test3.addFirst(5);
        test3.addFirst(6);
        test3.addFirst(7);
        test3.printDeque();
    }

    @Test
    public void removeTest(){
        ArrayDeque<Integer> test4 = new ArrayDeque<Integer>();
        test4.addFirst(1);
        test4.addFirst(2);
        test4.addFirst(3);
        test4.addFirst(4);
        test4.addFirst(5);
        test4.addFirst(6);
        test4.addFirst(7);
        test4.addLast(8);
        test4.addLast(9);
        test4.removeFirst();
        test4.removeFirst();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
        test4.removeLast();
    }

    @Test
    public void getTest(){
        ArrayDeque<Integer> test5 = new ArrayDeque<>();
        test5.addFirst(1);
        test5.addFirst(2);
        test5.addFirst(3);
        test5.addFirst(4);
        test5.addFirst(5);
        test5.addFirst(6);
        test5.addFirst(7);
        test5.addLast(8);
        test5.addLast(9);
        for(int i = 0; i < test5.size(); i++){
            System.out.print(test5.get(i) + " ");
        }
    }

    @Test
    public void IterTest(){
        ArrayDeque<Integer> test6 = new ArrayDeque<>();
        test6.addLast(1);
        test6.addLast(2);
        test6.addLast(3);
        for(Integer i : test6){
            System.out.println(i);
        }
    }

}
