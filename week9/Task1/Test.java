package week9.Task1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("22DTA", "Nguyen Van A", 2022);
        Student s2 = new Student("21DTB", "Nguyen Van B", 2021);
        Student s3 = new Student("22DTC", "Nguyen Van C", 2022);
        Student s4 = new Student("19DTB", "Tran Van C", 2019);

        Course c1 = new Course("200201", "Data Stuctures", "Practice", new ArrayList<>(), "Dr. Nguyen Van Du");
        Course c2 = new Course("200202", "Human-computer Interaction", "Theory", new ArrayList<>(),
                "Dr. Tran Thi Thanh Nga");
        Course c3 = new Course("200203", "Communication skills", "Pratice", new ArrayList<>(), "Dr Ha Thi Ngoc Thuong");

        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);

        c2.addStudent(s2);
        c2.addStudent(s3);

        c3.addStudent(s2);
        c3.addStudent(s4);

        Faculty fit = new Faculty("Falcuty of Information Technology", "Nong Lam University");

        fit.addCourse(c1);
        fit.addCourse(c2);

        System.out.println("Faculty info: " + fit);
        System.out.println("The practical course with most students is: " + fit.getMaxPracticalCourse());
        System.out.println("Students groupped by year: " + fit.groupStudentByYear());
        System.out.println("The practice courses sorted by student count: " + fit.filterCourses("Practice"));
    }
}
