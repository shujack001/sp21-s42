package deque;

public class ArrayDeque<T> {
    T[] array;
    int first;
    int last;
    int size;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        first = 4;
        last = 5;
        size = 0;
    }

    private void resizeArray(int n){
        T[] new_array = (T[]) new Object[n];
        int j = 0;
        for(int i = first; i < array.length; i++, j++){
            new_array[j] = array[i];
        }
        for(int i = 0; i < first; i++, j++){
            new_array[j] = array[i];
        }
        System.arraycopy(new_array, 0, new_array, array.length / 2, array.length);
        first = array.length / 2 - 1;
        last = first + array.length + 1;
        array = new_array;
    }

    public void addFirst(T item){
        if(size == array.length){
            resizeArray(size * 2);
        }
        if(first < 0){
            first = array.length - 1;
        }
        array[first] = item;
        first -= 1;
        size += 1;
    }

}
