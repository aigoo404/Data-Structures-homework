package week6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
  public static final int DEFAULT_CAPACITY = 10;
  private E[] elements;
  private int size;

  public MyArrayList() {
    this.elements = (E[]) new Object[DEFAULT_CAPACITY];
  }

  public MyArrayList(int capacity) {
    this.elements = (E[]) new Object[capacity];
  }

  // creates an array of double-size if the array of elements is full
  public void growSize() {
    int newCapacity = this.elements.length * 2;
    E[] newArr = (E[]) new Object[newCapacity];
    for (int i = 0; i < this.elements.length; i++) {
      newArr[i] = this.elements[i];
    }
    this.elements = newArr;
  }

  // Returns the number of elements in this list
  public int size() {
    return this.size;
  }

  // Returns whether the list is empty
  public boolean isEmpty() {
    return this.size == 0;
  }

  // Returns (but does not remove) the element at index i
  public E get(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + i + " is out of reach");
    }
    return this.elements[i];
  }

  // Replaces the element at index i with e, and returns the replaced element
  public E set(int i, E e) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + i + " is out of reach");
    }
    E replacedElement = this.elements[i];
    this.elements[i] = e;
    return replacedElement;
  }

  // Used to append the specified element at the end of a list.
  public boolean add(E e) {
    if (this.size == this.elements.length) {
      growSize();
    }
    this.elements[this.size] = e;
    this.size++;
    return true;
  }

  // Inserts element e to be at index i, shifting all subsequent elements later
  public void add(int i, E e) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + i + " is out of reach");
    }
    if (this.size == this.elements.length) {
      growSize();
    }
    for (int j = this.size - 1; j >= i; j--) {
      this.elements[j + 1] = this.elements[j];
    }
    this.elements[i] = e;
    this.size++;
  }

  // Removes and returns the element at index i, shifting subsequent elements
  // earlier
  public E remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + i + " is out of reach");
    }
    E removedElement = this.elements[i];
    for (int j = i + 1; j < this.size; j++) {
      this.elements[j - 1] = this.elements[j];
    }
    this.size--;
    return removedElement;
  }

  // Used to clear all elements in the list
  public void clear() {
    for (int i = 0; i < this.size; i++) {
      this.elements[i] = null;
    }
    this.size = 0;
  }

  // Used to return the index in this list of the last occurrence of the specified
  // element, or -1 if the list does not contain this element.
  public int lastIndexOf(Object o) {
    for (int i = this.size - 1; i >= 0; i--) {
      if (this.elements[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  // Used to return an array containing all of the elements in this list in the
  // correct order
  public E[] toArray() {
    E[] arr = (E[]) new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elements[i];
    }
    return arr;
  }

  // Used to return a shallow copy of an ArrayList
  public MyArrayList<E> clone() {
    MyArrayList<E> copy = new MyArrayList<>(this.elements.length);
    for (int i = 0; i < this.size; i++) {
      copy.add(this.elements[i]);
    }
    return copy;
  }

  // This method returns true if the list contains the specified element
  public boolean contains(E o) {
    for (int i = 0; i < this.size; i++) {
      if (this.elements[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  // Used to return the index in this list of the first occurrence of the
  // specified element, or -1 if the List does not contain this element.
  public int indexOf(E o) {
    for (int i = 0; i < this.size; i++) {
      if (this.elements[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  // It is used to remove the first occurrence of the specified element
  public boolean remove(E e) {
    int index = indexOf(e);
    if (index != -1) {
      remove(index);
      return true;
    }
    return false;
  }

  // It is used to sort the elements of the list on the basis of specified
  // comparator
  public void sort(Comparator<E> c) {
    Arrays.sort(this.elements, 0, size, c);
  }

  // Used to print the list out
  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.print(elements[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MyArrayList<Integer> list = new MyArrayList<>();
    System.out.println("Generated list: ");
    for (int i = 0; i < DEFAULT_CAPACITY; i++) {
      list.add(i);
    }
    list.print();
    int index = 5;
    System.out.println("List size: " + list.size());
    System.out.println("Is the list empty? " + list.isEmpty());
    System.out.println("Element at index " + index + " :" + list.get(index));
    list.set(index, 50);
    System.out.println("Element at index " + index + " after setting: " + list.get(index));
    list.add(6, 20);
    System.out.println("Element at index 6 after adding: " + list.get(6));
    System.out.println("Element removed at index 7: " + list.remove(7));
    list.add(12);
    System.out.println("Grow sized list: ");
    list.print();
    MyArrayList<Integer> clonedList = list.clone();
    System.out.println("Cloned list: ");
    clonedList.print();
    System.out.println("Clear clone list: ");
    clonedList.clear();
    clonedList.print();
    System.out.println("Last index of Object 12 :" + list.indexOf(12));
    Object[] arr = list.toArray();
    System.out.println("toArray method: " + Arrays.toString(arr));
    System.out.println("Is list contain element 12? " + list.contains(12));
    System.out.println("Is element 6 removed? " + list.remove(Integer.valueOf(7)));
    System.out.println("Sorted list: ");
    list.sort(Comparator.naturalOrder());
    list.print();
  }
}
