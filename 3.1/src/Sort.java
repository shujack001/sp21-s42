public class Sort {
    public static void sort(String[] x){
        // find the smallest item
        // move it to the front
        // selection sort the rest (using recursion?)
        sort(x, 0);
    }

    private static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }
    public static int findSmallest(String[] x, int start){
        int len = x.length;
        int index = start;
        for(int i = start; i < len; i++){
            if(x[i].compareTo(x[index]) < 0){
               index = i;
            }
        }
        return index;
    }

    /** swap a with b in String[]x */
    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
