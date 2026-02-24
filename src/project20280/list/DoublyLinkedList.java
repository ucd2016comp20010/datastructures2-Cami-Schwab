package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    private static class Node<E> {
    //    private final E data;
        private  E data;
        private Node<E> next;
    //    private final Node<E> prev;
        private  Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }

        public void setPrev(Node<E> p) {
            this.prev = p;
        }

    }

    //private final Node<E> head;
    private Node<E> head;
    //private final Node<E> tail;
    private Node<E> tail;
    //private final int size = 0;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.next = tail;
    }

    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
    }

    @Override
    public int size() {
        if(head.getNext() == tail) {
            return 0;
        }
        int i = 0;
        Node<E> last = head;
        while (last.getNext() != tail) { // advance to the last node
            last = last.getNext();
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        if(head.getNext() == tail) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public E get(int i) {
        Node<E> gotten = head.getNext();
        for(int j = 0; j < i; j++) {
            gotten = gotten.getNext();
        }
        return gotten.getData();
    }

    @Override
    public void add(int i, E e) {
        Node<E> prev = head;
        for(int j = 0; j < i; j++) {
            prev = prev.getNext();
        }
        Node<E> next = prev.getNext();
        addBetween(e, prev, next);
        return;
    }

    @Override
    public E remove(int i) {
        Node<E> prev = head.getNext();
        for(int j = 0; j < (i-1); j++) {
            prev = prev.getNext();
        }
        Node<E> removed = head.getNext();
        for(int j = 0; j < i; j++) {
            removed = removed.getNext();
        }
        Node<E> next = head.getNext();
        for(int j = 0; j < (i+1); j++) {
            next = next.getNext();
        }
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return removed.getData();
    }

    private class DoublyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head.next;

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.data;
            curr = curr.next;
            return res;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator<E>();
    }

    private E remove(Node<E> n) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        size--;
        return n.getData();
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.next.getData();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.prev.getData();
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null; // nothing to remove
        return remove(head.getNext()); // first element is beyond header
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null; // nothing to remove
        return remove(tail.getPrev()); // last element is before trailer
    }

    @Override
    public void addLast(E e) {
        Node<E> added = new Node<E>(e, tail.getPrev(), tail);
        tail.getPrev().setNext(added);
        tail.setPrev(added);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> added = new Node<E>(e, head, head.getNext());
        head.getNext().setPrev(added);
        head.setNext(added);
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head.next;
        while (curr != tail) {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(-1);
        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }
    }
}