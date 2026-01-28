package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    private static class Node<E> {

        private final E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            this.next = n;
        }
    } //----------- end of nested Node class -----------

    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)


    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    //@Override
    public int size() {
        if(head == null) {
            return 0;
        }
        int i = 1;
        Node <E> last = head;
        while (last.getNext() != null) { // advance to the last node
            last = last.getNext();
            i++;
        }
        return i;
    }

    //@Override
    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public E get(int position) {
        if(0 > position || position >= size) {
            return null;
        }
        Node <E> currentNode = head;
        for(int i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        if(currentNode == null) {
            return null;
        }
        return currentNode.getElement();
    }

    @Override
    public void add(int position, E e) {
        if(0 > position || position > size) {
            return;
        }
        Node <E> walk = head;
        if(position == 0) {
            head = new Node<E>(e, head);
            size++;
            return;
        }
        for(int i = 0; i < (position-1); i++) {
            walk = walk.getNext();
        }
        Node<E> inserted = new Node<E>(e, walk.getNext());
        walk.setNext(inserted);
        size++;
    }


    @Override
    public void addFirst(E e) {
        head = new Node<E>(e, head); // create and link a new node
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newest = new Node<E>(e, null); // node will eventually be the tail
        Node<E> last = head;
        if(last == null) {
            head = newest;
        }
        else {
            while (last.getNext() != null) { // advance to the last node
                last = last.getNext();
            }
            last.setNext(newest); // new node after existing tail
        }
        size++;
    }

    @Override
    public E remove(int position) {
        if(head == null) {
            return null;
        }
        int i = 1;
        Node <E> last = head;
        while (last.getNext() != null) { // advance to the last node
            last = last.getNext();
            i++;
        }
        if(!(0<=position && position<i) ) {
            return null;
        }
        if(position == 0) {
            Node<E> originalHead = head;
            head = head.getNext();
            size--;
            return originalHead.getElement();
        }
        Node <E> a = head; //a is position before one removed
        Node <E> b = head; //b is position being removed
        for(int j = 0; j < (position-1); j++) {
            a = a.getNext();
        }
        for(int k = 0; k < position; k++) {
            b = b.getNext();
        }
        a.setNext(b.getNext());
        size--;
        return b.getElement();
    }

    @Override
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        Node<E> originalHead = head;
        head = head.next;
        size--;
        return originalHead.getElement();
    }

    @Override
    public E removeLast() {
        Node<E> last = head;
        E r = null;
        if(head == null) {
            return null;
        }
        if(head.getNext() == null) {
            r = head.getElement();
            head = null;
            size--;
            return r;
        }
        int i = 1; //length
        while (last.getNext() != null) { // advance to the last node
            last = last.getNext();
            i++;
        }
        r = last.getElement();
        Node<E> secondLast = head;
        for(int j = 0; j < i-2; j++) {
            secondLast = secondLast.getNext();
        }
        secondLast.setNext(null);
        size--;
        return r;
    }

    //@Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E res = curr.getElement();
            curr = curr.next;
            return res;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.getElement());
            if (curr.getNext() != null)
                sb.append(", ");
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
        System.out.println("ll " + ll + " isEmpty: " + ll.isEmpty());
        //LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(-1);
        //ll.removeLast();
        //ll.removeFirst();
        //System.out.println("I accept your apology");
        //ll.add(3, 2);
        System.out.println(ll);
        ll.remove(5);
        System.out.println(ll);

    }
}
