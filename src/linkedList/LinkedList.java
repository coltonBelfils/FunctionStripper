package linkedList;

import java.util.Iterator;

/**
 *
 * @author CJDB
 */
public class LinkedList<E> implements Iterable<E>{
    int size;
    Node head;
    Node curent;

    @Override
    public Iterator<E> iterator() {
        curent = this.head.next;
        return new linkedListIterator();
    }
    
    private class Node {
        public Node next;
        public E data;
        
        public Node(final Node next, final E data) {
            this.next = next;
            this.data = data;
        }
        
        public Node(final E data) {
            this.data = data;
            this.next = null;
        }
        
        public Node() {
            this.data = null;
            this.next = null;
        }
    }
    
    public LinkedList() {
        this.head = new Node();
        this.size = 0;
    }
    
    public void add(E data) {
        Node cur;
        for(cur = this.head.next; cur.next != null; cur = cur.next);
        cur.next = new Node(data);
        size++;
    }
    
    public void remove(Comparable data) {
        Node cur, pre;
        for(cur = this.head.next, pre = this.head; cur != null; pre = cur, cur = cur.next) {
            if(this.head.data ==  data) {
                pre.next =  cur.next;
                size--;
                break;
            }
        }
    }
    
    public E get(int index) {
        Node cur = this.head.next;
        for(int i = 0; i < index; i++, cur = cur.next);
        return cur.data;
    }
    
    public class linkedListIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            if(curent == null) {
                return false;
            } else if(curent.next == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public E next() {
            E temp = curent.data;
            curent = curent.next;
            return temp;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported.");
        }
    }
}
