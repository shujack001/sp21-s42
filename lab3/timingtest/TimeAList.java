package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> items = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        Stopwatch sw = new Stopwatch();
        for(int i = 0; i < 10000000; i++){
            items.addLast(i);
            if(i == 999){
                Ns.addLast(1000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 1999){
                Ns.addLast(2000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 3999){
                Ns.addLast(4000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 7999){
                Ns.addLast(8000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 15999){
                Ns.addLast(16000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 31999){
                Ns.addLast(32000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 63999){
                Ns.addLast(64000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }else if(i == 9999999){
                Ns.addLast(10000000);
                double time = sw.elapsedTime();
                times.addLast(time);
            }
        }
        printTimingTable(Ns, times, Ns);

    }
}
