public class selectSort {
    public static void sort(int[] x){
        int len = x.length;
        int min = x[0];
        int index = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(x[j] <= min){
                    min = x[j];
                    index = j;
                }
            }
            int temp = x[i];
            x[i] = x[index];
            x[index] = temp;
        }
    }
    public static void main(String[] args){
        int[] x = {1, 2, 3};
        sort(x);
    }
}
