package week7;

import java.util.*;
import java.util.function.Predicate;

public class MyPredicates {
    // Remove every obj from coll for which p.test(obj) is true. (This does the same
    // thing as coll.removeIf(p))
    public static <T> void remove(Collection<T> coll, Predicate<T> p) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (p.test(item)) {
                iterator.remove();
            }
        }
    }

    // Remove every obj from coll for which pr.test(obj) is false. (That is, retain
    // the objects for which the predicate is true.)
    public static <T> void retain(Collection<T> coll, Predicate<T> p) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (!p.test(item)) {
                iterator.remove();
            }
        }
    }

    // Return a Set that contains all unique objects, obj, from the collection,
    // coll, such that p.test(obj) is true.
    public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
        Set<T> set = new HashSet<>();
        for (T item : coll) {
            if (p.test(item)) {
                set.add(item);
            }
        }
        return set;
    }

    // Return the index of the first item in list for which the predicate is true,
    // if any. If there is no such item, return -1.
    public static <T> int find(Collection<T> coll, Predicate<T> p) {
        int index = 0;
        for (T item : coll) {
            if (p.test(item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<Integer>();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);
        coll.add(5);
        coll.add(6);
        System.out.println("Original coll: " + coll);
        Even isEven = new Even();
        Collection<Integer> coll1 = new ArrayList<Integer>();
        coll1.add(1);
        coll1.add(2);
        coll1.add(3);
        coll1.add(4);
        coll1.add(5);
        coll1.add(6);
        MyPredicates.remove(coll1, isEven);
        System.out.println("Coll after removing even numbers: " + coll1);
        Collection<Integer> coll2 = new ArrayList<Integer>();
        coll2.add(1);
        coll2.add(2);
        coll2.add(3);
        coll2.add(4);
        coll2.add(5);
        coll2.add(6);
        MyPredicates.retain(coll2, isEven);
        System.out.println("Coll after retaining even numbers: " + coll2);
        Set<Integer> set = MyPredicates.collect(coll, isEven);
        System.out.println("Coll after collecting even numbers: " + set);
        int index = MyPredicates.find(coll, isEven);
        System.out.println("Index of the first even number: " + index);
    }
}
