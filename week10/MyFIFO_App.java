package week10;

import java.util.*;

public class MyFIFO_App {
    // accepts a queue of integers as a parameter and replaces every element of the
    // queue with two copies of that element
    public static <E> void stutter(Queue<E> input) {
        Queue<E> temp = new LinkedList<>();
        while (!input.isEmpty()) {
            E e = input.remove();
            temp.add(e);
            temp.add(e);
        }
        input.clear();
        input.addAll(temp);
    }

    //accepts a queue of strings as a parameter and appends the queue's contents to itself in reverse order
    public static <E> void mirror(Queue<E> input) {
        Stack<E> temp = new Stack<>();
        for (int i = 0; i < input.size(); i++) {
            E e = input.remove();
            temp.push(e);
            input.add(e);
        }
        while (!temp.isEmpty()) {
            input.add(temp.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);
        System.out.println("--------------------------");
        System.out.println("Original queue: " + queue1);
        stutter(queue1);
        System.out.println("Stuttered queue: " + queue1);
        System.out.println("--------------------------");
        System.out.println("Original queue: " + queue2);
        mirror(queue2);
        System.out.println("Mirrored queue: " + queue2);
        System.out.println("--------------------------");
    }
}
