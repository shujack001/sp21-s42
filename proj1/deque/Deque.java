package deque;

public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    // print first to last
    public void printDeque();
    // remove and return the front of the deque, if no such item exists, return null
    public T removeFirst();
    public T removeLast();
    // get the item if index, 0 is the front, if no exists, return null
    public T get(int index);
    // ??
//    public Iterator<T> iterator();
    // if o == deque return true use instanceof keywords
    public boolean equals(Object o);
}
