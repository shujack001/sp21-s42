package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Integer> ops = new AList<>();
        AList<Double> times = new AList<>();
        SLList<Integer> item = new SLList<>();
        for(int i = 0; i < 1000; i++){
            item.addLast(i);
        }
        Stopwatch time1 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time1000 = time1.elapsedTime();
        times.addLast(time1000);
        Ns.addLast(1000);
        ops.addLast(10000);
        for(int i = 1000; i < 2000; i++){
            item.addLast(i);
        }
        Stopwatch time2 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time2000 = time2.elapsedTime();
        times.addLast(time2000);
        Ns.addLast(2000);
        ops.addLast(10000);
        for(int i = 2000; i < 4000; i++){
            item.addLast(i);
        }
        Stopwatch time3 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time4000 = time2.elapsedTime();
        times.addLast(time4000);
        Ns.addLast(4000);
        ops.addLast(10000);
        for(int i = 4000; i < 8000; i++){
            item.addLast(i);
        }
        Stopwatch time4 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time8000 = time4.elapsedTime();
        times.addLast(time8000);
        Ns.addLast(8000);
        ops.addLast(10000);
        for(int i = 8000; i < 16000; i++){
            item.addLast(i);
        }
        Stopwatch time5 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time16000 = time5.elapsedTime();
        times.addLast(time16000);
        Ns.addLast(16000);
        ops.addLast(10000);
        for(int i = 16000; i < 32000; i++){
            item.addLast(i);
        }
        Stopwatch time6 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time32000 = time6.elapsedTime();
        times.addLast(time32000);
        Ns.addLast(32000);
        ops.addLast(10000);
        for(int i = 32000; i < 64000; i++){
            item.addLast(i);
        }
        Stopwatch time7 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time64000 = time7.elapsedTime();
        times.addLast(time64000);
        Ns.addLast(64000);
        ops.addLast(10000);
        for(int i = 64000; i < 128000; i++){
            item.addLast(i);
        }
        Stopwatch time8 = new Stopwatch();
        for(int i = 0; i < 10000; i++){
            item.getLast();
        }
        double time128000 = time8.elapsedTime();
        times.addLast(time128000);
        Ns.addLast(128000);
        ops.addLast(10000);
        printTimingTable(Ns, times, ops);
    }


}
