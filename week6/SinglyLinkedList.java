package week6;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    // Returns the number of elements in the list
    public int size() {
        return size;
    }

    // Returns true if the list is empty, and false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the first element in the list
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    // Returns (but does not remove) the last element in the list
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getData();
    }

    // Adds a new element to the front of the list
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
            size++;
        }
    }

    // Adds a new element to the end of the list
    public void addLast(E e) {
        Node<E> newElement = new Node<>(e, null);
        if (isEmpty()) {
            head = newElement;
        } else {
            tail.setNext(newElement);
            tail = newElement;
            size++;
        }
    }

    // Removes and returns the first element of the list.
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E result = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println("Is this list empty? " + list.isEmpty());
        list.addFirst(9);
        list.addLast(10);
        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());
        list.addFirst(8);
        System.out.println("First element after using addFirst() method: " + list.first());
        System.out.println("List size: " + list.size());
        list.removeFirst();
        System.out.println("First element after using removeFirst() method: " + list.first());
        System.out.println("-----------------------------------------------------");
    }
}
