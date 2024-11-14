package deque;

//   抓住不变量 编写代码
// the list length is size
// nextfirst + 1 is the front index of the list
// nextlast - 1 is the back index of the list
public class ArrayDeque<T> {
    T[] array;
    int nextfirst;
    int nextlast;
    int size;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        nextfirst = 4;
        nextlast = 5;
        size = 0;
    }

    private void resizeArray(int capacity){
        T[] new_array = (T[]) new Object[capacity];
        // 抓住不变量 即nextfirst + 1 是列表的开始  size是列表大小 也就是复制个数  // 做不来的点就是这里 自己考虑的太复杂了 想用多个if来解决（用first和last的大小来判断情况...) 发现非常困难 其实要抓住代码的不变量 来做就很简单  还有一点就是 索引越界用%来处理就很简单
        for(int i = 0; i < size; i++){
            new_array[capacity / 4 + i] = array[(nextfirst + 1 + i) % array.length];
        }
        array = new_array;
        nextfirst = capacity / 4 - 1;
        nextlast = nextfirst + size + 1;
    }

    public void addFirst(T item){
        if(size == array.length){
            resizeArray(size * 2);
        }
        if(nextfirst < 0){
            nextfirst = array.length - 1;
        }
        array[nextfirst] = item;
        nextfirst -= 1;
        size += 1;
    }

    public void addLast(T item){
        if(size == array.length){
            resizeArray(size * 2);
        }
        if(nextlast == array.length){
            nextlast = 0;
        }
        array[nextlast] = item;
        nextlast += 1;
        size += 1;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = 0; i < size; i ++){
            System.out.print(array[(nextfirst + 1 + i) % array.length] + " ");
        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        if((size < array.length / 4) && (array.length >= 16)){
            resizeArray(array.length / 2);
        }
        nextfirst = (nextfirst + 1) % array.length;
        size -= 1;
        return array[nextfirst];
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        if((size < array.length / 4) && (array.length >= 16)){
            resizeArray(array.length / 2);
        }
        nextlast = (nextlast - 1 + array.length) % array.length;
        size -= 1;
        return array[nextlast];
    }

    public T get(int index){
        if(index + 1 > size){
            return null;
        }
        return array[(nextfirst + 1 + index) % array.length];
    }
}
