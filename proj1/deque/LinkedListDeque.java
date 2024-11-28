package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{

    public class Node{
        T item;
        Node prev;
        Node next;

        private Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // add and remove must  take constant time, this mean cannot use loops
    @Override
    public void addFirst(T item){
        Node new_First = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = new_First;
        sentinel.next = new_First;
        size += 1;
    }
    @Override
    public void addLast(T item){
        Node new_Last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = new_Last;
        sentinel.prev = new_Last;
        size += 1;
    }
//    @Override
//    public boolean isEmpty(){
//        if (size == 0){
//            return true;
//        }else{
//            return false;
//        }
//    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        Node temp = sentinel;
        while(true){
            if(temp.next == sentinel){
                break;
            }else{
                temp = temp.next;
                System.out.print(temp.item + " ");
            }
        }
        System.out.println("");
    }
    @Override
    public T removeFirst(){
        if(size == 0){
            return null;
        }else{
            T f_item = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return f_item;
        }
    }
    @Override
    public T removeLast(){
        if(size == 0){
            return null;
        }else{
            T L_item = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return L_item;
        }
    }

    // get must be iteration, not recursion
    @Override
    public T get(int index){
        Node temp = sentinel;
        for(int i = 0; i <= index; i++){
            if(temp.next == sentinel){
                return null;
            }
            temp = temp.next;
        }
        return temp.item;
    }

    private T getRecursiveHelper(int index, Node p){
        if(p.item == null){
            return null;
        }
        if(index == 0){
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }

    public T getRecursive(int index){
        Node p = sentinel.next;
        if(index < 0){
            return null;
        }
        return getRecursiveHelper(index, p);
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(!(o instanceof Deque)){
            return false;
        }
        Deque<?> otherDeque = (Deque<?>) o;
        if(otherDeque.size() != this.size()){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(!(otherDeque.get(i).equals(this.get(i)))){
                return false;
            }
        }
        return true;
    }
    @Override
    public Iterator<T> iterator(){
        return new LinkedDequeIterator();
    }

    private class LinkedDequeIterator implements Iterator<T>{
        private int wizpos;

        public LinkedDequeIterator(){
            wizpos = 0;
        }
        @Override
        public boolean hasNext(){
            return wizpos < size;
        }
        @Override
        public T next(){
            T returnitem;
            Node temp = sentinel.next;
            for(int i = 0; i < wizpos; i++){
                temp = temp.next;
            }
            wizpos += 1;
            return temp.item;
        }
    }

}
