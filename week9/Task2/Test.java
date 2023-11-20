package week9.Task2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Publication p1 = new Magazine("Science", 50, 2020, "John Smith", 100, "Science");
        Publication p2 = new ReferenceBook("Java Programming", 300, 2021, "Alice Lee", 200, "Computer Science",
                new ArrayList<>());
        Publication p3 = new ReferenceBook("Mathematics for Engineers", 400, 2021, "Bob Chen", 250, "Mathematics",
                new ArrayList<>());

        ((ReferenceBook) p2).addChapter("Introduction", 10);
        ((ReferenceBook) p2).addChapter("Variables and Data Types", 20);
        ((ReferenceBook) p2).addChapter("Control Structures", 30);
        ((ReferenceBook) p2).addChapter("Methods and Classes", 40);
        ((ReferenceBook) p2).addChapter("Arrays and Collections", 50);

        ((ReferenceBook) p3).addChapter("Linear Algebra", 100);
        ((ReferenceBook) p3).addChapter("Calculus", 100);
        ((ReferenceBook) p3).addChapter("Differential Equations", 100);
        ((ReferenceBook) p3).addChapter("Probability and Statistics", 100);

        Catalog catalog = new Catalog(new ArrayList<>());
        catalog.addPublication(p1);
        catalog.addPublication(p2);
        catalog.addPublication(p3);

        System.out.println("Total price: " + catalog.getTotalPrice());
        System.out.println("The reference book with the longest chapter: " + catalog.findLongestChapter());
        System.out.println("Return if have a magazine name Science: " + catalog.containsMagazine("Science"));
        System.out.println("The magazines published in 2020 are: " + catalog.getMagazinesByYear(2020));
        System.out.println("The number of publications by year are: " + catalog.countPublicationsByYear());
    }
}