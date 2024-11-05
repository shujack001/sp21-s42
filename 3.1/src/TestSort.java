import org.junit.Test;
import static org.junit.Assert.*;
public class TestSort {
    @Test
    public void testSort(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
//        for(int i = 0; i < input.length; i++){
//            if(!input[i].equals(except[i])){
//                System.out.println("Mismatch is positon " + i + ", except: " + except[i] + ", but got: " + input[i] + ".");
//                break;
//            }
//        }
        assertArrayEquals(expected, input);
    }
    @Test
    public void testFindSmallest(){
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actul = Sort.findSmallest(input, 0);
        assertEquals(expected, actul);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 2;
        int actul2 = Sort.findSmallest(input2, 2);
        assertEquals(expected2, actul2);
    }
    @Test
    public void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};
        int a = 0;
        int b = 2;
        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }

}
