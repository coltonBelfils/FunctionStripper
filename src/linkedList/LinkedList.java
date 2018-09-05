package linkedList;

import java.util.Iterator;

/**
 *
 * @author CJDB
 */
public class LinkedList<E> implements Iterable<E>{
    private int size;
    private boolean isEmpty;
    private Node head;
    private Node curent;
    private E last;

    @Override
    public Iterator<E> iterator() {
        curent = this.head.next;
        return new linkedListIterator();
    }
    
    public boolean isEmpty() {
        return isEmpty;
    }
    
    public int size() {
        return this.size;
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
        this.isEmpty = true;
    }
    
    public void addLast(E data) {
        if(this.head.next == null) {
            this.addFirst(data);
        } else {
            Node cur;
            for(cur = this.head.next; cur.next != null; cur = cur.next);
            cur.next = new Node(data);
            size++;
            this.isEmpty = false;
            this.last = data;
        }
    }
    
    public void addFirst(E data) {
        if(this.head.next == null) {
            this.last = data;
        }
        Node temp = this.head.next;
        this .head.next = new Node(temp, data);
        this.size++;
        this.isEmpty = false;
    }
    
    public void addIndex(int index, E data) {
        if(this.head.next == null && index == 0) {
            this.addFirst(data);
        } else if(index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        } else {
            Node cur, pre;
            int i;
            for(i = 0, cur = this.head.next, pre = this.head; i < index; pre = cur, cur = cur.next, i++);
            Node temp = pre.next;
            pre.next = new Node(temp, data);
            this.size++;
            this.isEmpty = false;
        }
    }
    
    public void remove(Comparable data) {
        Node cur, pre;
        for(cur = this.head.next, pre = this.head; cur != null; pre = cur, cur = cur.next) {
            if(this.head.data ==  data) {
                pre.next =  cur.next;
                this.size--;
                break;
            }
        }
        if(cur != null && cur.next == null) {
            this.last = pre.data;
        }
        if(this.head.next == null) {
            this.isEmpty = true;
        }
    }
    
    public void removeFirst() {
        if(this.head.next == null) {
            
        } else {
            this.head.next = this.head.next.next;
            size--;
        }
        if(this.head.next == null) {
            this.isEmpty = true;
        }
    }
    
    public void removeLast() {
        if(this.head.next == null) {
            
        } else {
            Node cur, pre;
            for(cur = this.head.next, pre = this.head; cur.next != null; pre = cur, cur = cur.next);
            pre.next = cur.next;
            this.size--;
            if(this.head.next == null) {
                this.isEmpty = true;
            }
            this.last = pre.data;
        }
    }
    
    public void removeIndex(int index) {
        if(this.head.next == null) {
            
        } else if(index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        } else {
            Node cur, pre;
            int i;
            for(i = 0, cur = this.head.next, pre = this.head; i < index; pre = cur, cur = cur.next, i++);
            pre.next = cur.next;
            this.size--;
            if(this.head.next == null) {
                this.isEmpty = true;
            }
        }
    }
    
    public void clear() {
        this.head = new Node();
        this.size = 0;
        this.isEmpty = true;
    }
    
    public E get(int index) {
        if(this.head.next == null) {
            throw new IllegalStateException("List is empty");
        }
        if(index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        }
        Node cur = this.head.next;
        for(int i = 0; i < index; i++, cur = cur.next);
        if(cur == null) {
            return null;
        }
        return cur.data;
    }
    
    public E getLast() {
        if(this.head.next == null) {
            throw new IllegalStateException("List is empty");
        }
        return this.last;
    }
    
    public E getFirst() {
        if(this.head.next == null) {
            throw new IllegalStateException("List is empty");
        }
        return this.head.next.data;
    }
    
    public class linkedListIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            if(curent == null) {
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
