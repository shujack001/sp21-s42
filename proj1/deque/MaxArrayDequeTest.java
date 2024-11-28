package deque;
import net.sf.saxon.functions.Minimax;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void maxTest(){
        MaxArrayDeque<Integer> test1 = new MaxArrayDeque<>(new IntComparator());
        for(int i = 0; i < 5; i++){
            test1.addLast(i);
        }
        assertEquals("Wrong", Integer.valueOf(4), test1.max());
    }

    @Test
    public void maxTest2(){
        MaxArrayDeque<String> test2 = new MaxArrayDeque<>(new StringLengthComparator());
        test2.addLast("shuwenjie");
        test2.addLast("dongbeishifandaxue");
        test2.addLast("tenxun");
        assertEquals("Wrong", "dongbeishifandaxue", test2.max());
        assertEquals("Wrong", "dongbeishifandaxue", test2.max(new StringLengthComparator()));
    }

    private static class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer I1, Integer I2){
            return I1 - I2;
        }
    }

    private static class StringLengthComparator implements  Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            int len1 = s1.length();
            int len2 = s2.length();
            return len1 - len2;
        }
    }

}
