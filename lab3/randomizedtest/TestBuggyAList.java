package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> correctList = new AListNoResizing<>();
        BuggyAList<Integer> bugList = new BuggyAList<>();
        for(int i = 4; i < 7; i++){
            correctList.addLast(i);
            bugList.addLast(i);
        }
        for(int i = 0; i < 3; i++){
            Integer correctLast = correctList.removeLast();
            Integer bugLast = bugList.removeLast();
            assertEquals("last wrong", correctLast, bugLast);
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B  = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int Bsize = B.size();
                assertEquals("size is " + size + " don't " + Bsize, size, Bsize);
            }else if(operationNumber == 2){
                if(L.size() != 0){
                    // getLast
                    Integer last = L.getLast();
                    Integer Blast = B.getLast();
                    assertEquals("last is " + last + " don't " + Blast, last, Blast);
                }
            }else if(operationNumber == 3){
                if(L.size() != 0 && B.size() != 0){
                    // removeLast
                    Integer last = L.removeLast();
                    Integer Blast = B.removeLast();
                    assertEquals("removeLast is " + last + " don't " + Blast, last, Blast);
                }
            }
        }
    }
}
