package project20280.stacksqueues;

import project20280.interfaces.Queue;
import project20280.list.DoublyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private DoublyLinkedList<E> ll;

    public static void main(String[] args) {
    }

    public LinkedQueue() {
        this.ll = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        ll.add(size(),e);
    }

    @Override
    public E first() {
        if(isEmpty()) {
            return null;
        }
        return ll.get(0);
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            return null;
        }
        return ll.removeFirst();
    }

    public String toString() {
        return ll.toString();
    }
}
