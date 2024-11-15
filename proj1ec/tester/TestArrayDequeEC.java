package tester;
import org.junit.Test;
import static org.junit.Assert.*;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;

// (void)add (T)remove (int)size (boolean)isEmpty (T)get
public class TestArrayDequeEC {


    @Test
    public void addremovegetsizeTest() {
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctDeque = new ArrayDequeSolution<>();
        StringBuilder operations = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            int operation = StdRandom.uniform(4);
            if (operation == 0) { // addFirst size isEmpty
                int randVal = StdRandom.uniform(100);
                studentDeque.addFirst(randVal);
                correctDeque.addFirst(randVal);
                operations.append("addFirst(").append(randVal).append(")\n");
                assertEquals(operations + " studentDeque size should " + correctDeque.size() + " doesn't " + studentDeque.size(), correctDeque.size(), studentDeque.size());
                assertEquals(operations + " studentDeque first should " + correctDeque.get(0) + " doesn't " + studentDeque.get(0), correctDeque.get(0), studentDeque.get(0));
            } else if (operation == 1) {
                int randVal = StdRandom.uniform(100);
                studentDeque.addLast(randVal);
                correctDeque.addLast(randVal);
                operations.append("addLast(").append(randVal).append(")\n");
                assertEquals(operations + "studentDeque size should " + correctDeque.size() + " doesn't " + studentDeque.size(), correctDeque.size(), studentDeque.size());
                assertEquals(operations + "studentDeque last should " + correctDeque.get(correctDeque.size() - 1) + " doesn't " + studentDeque.get(studentDeque.size() - 1), correctDeque.get(correctDeque.size() - 1), studentDeque.get(studentDeque.size() - 1));
            } else if (operation == 2) {
                if (!studentDeque.isEmpty() && !correctDeque.isEmpty()) {
                    Integer studentFirst = studentDeque.removeFirst();
                    Integer correctFirst = correctDeque.removeFirst();
                    operations.append("removeFirst()\n");
                    assertEquals(operations.toString(), correctFirst, studentFirst);
                    assertEquals(operations + "studentDeque size should " + correctDeque.size() + " doesn't " + studentDeque.size(), correctDeque.size(), studentDeque.size());
//                    assertEquals("studentDeque first should" + correctDeque.get(correctDeque.size() - 1) + "doesn't" + studentDeque.get(studentDeque.size() - 1), correctDeque.get(correctDeque.size() - 1), studentDeque.get(studentDeque.size() - 1));
                }
            } else if (operation == 3) {
                if (!studentDeque.isEmpty() && !correctDeque.isEmpty()) {
                    Integer studentLast = studentDeque.removeLast();
                    Integer correctLast = correctDeque.removeLast();
                    operations.append("removeLast()\n");
                    assertEquals(operations.toString(), correctLast, studentLast);
                    assertEquals(operations + "studentDeque size should " + correctDeque.size() + " doesn't " + studentDeque.size(), correctDeque.size(), studentDeque.size());
//                  assertEquals("studentDeque last should" + correctDeque.get(correctDeque.size() - 1) + "doesn't" + studentDeque.get(studentDeque.size() - 1), correctDeque.get(correctDeque.size() - 1), studentDeque.get(studentDeque.size() - 1));
                }
            }
        }
    }
}







//    @Test
//    public void randomTest() {
//        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
//        ArrayDequeSolution<Integer> correctDeque = new ArrayDequeSolution<>();
//
//        StringBuilder operations = new StringBuilder();  // 用于记录操作步骤
//
//        for (int i = 0; i < 1000; i++) {  // 进行多次操作来测试
//            int operation = StdRandom.uniform(4);  // 生成一个0到3的随机数
//
//            if (operation == 0) {  // addFirst
//                int randVal = StdRandom.uniform(100);
//                studentDeque.addFirst(randVal);
//                correctDeque.addFirst(randVal);
//                operations.append("addFirst(").append(randVal).append(")\n");
//            } else if (operation == 1) {  // addLast
//                int randVal = StdRandom.uniform(100);
//                studentDeque.addLast(randVal);
//                correctDeque.addLast(randVal);
//                operations.append("addLast(").append(randVal).append(")\n");
//            } else if (operation == 2) {  // removeFirst
//                if (!studentDeque.isEmpty() && !correctDeque.isEmpty()) {
//                    Integer studentResult = studentDeque.removeFirst();
//                    Integer correctResult = correctDeque.removeFirst();
//                    operations.append("removeFirst()\n");
//                    assertEquals(operations.toString(), correctResult, studentResult);
//                }
//            } else if (operation == 3) {  // removeLast
//                if (!studentDeque.isEmpty() && !correctDeque.isEmpty()) {
//                    Integer studentResult = studentDeque.removeLast();
//                    Integer correctResult = correctDeque.removeLast();
//                    operations.append("removeLast()\n");
//                    assertEquals(operations.toString(), correctResult, studentResult);
//                }
//            }
//        }
//    }

