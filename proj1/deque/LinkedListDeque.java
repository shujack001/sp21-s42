package deque;

public class LinkedListDeque<T>{

    public class Node{
        T item;
        Node prev;
        Node next;

        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // add and remove must  take constant time, this mean cannot use loops
    public void addFirst(T item){
        Node new_First = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = new_First;
        sentinel.next = new_First;
        size += 1;
    }

    public void addLast(T item){
        Node new_Last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = new_Last;
        sentinel.prev = new_Last;
        size += 1;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

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

//    public T getRecursive(int index){
//
//    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Deque)){
            return false;
        }
        if(o instanceof LinkedListDeque){
            LinkedListDeque<T> otherDeque = (LinkedListDeque<T>) o;

            if(otherDeque.size() != this.size()){
                return false;
            }

            Node temp1 = sentinel;
            Node temp2 = otherDeque.sentinel;
            while(temp1.next != sentinel){
                if(!temp1.item.equals(temp2.item)){
                    return false;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return true;
        }else{
            return false;
        }

    }

//    public Iterator<T> iterator(){
//
//    }

}
