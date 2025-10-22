package sectionb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * StudentRecordManager
 * ---------------------
 * Manages Student records using Generics and Collections.
 */
public class StudentRecordManager {

    static class Student {
        private int id;
        private String name;
        private double marks;

        public Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getMarks() { return marks; }

        @Override
        public String toString() {
            return name + " (" + (int)marks + ")";
        }
    }

    public static void displayTopStudents(List<Student> students) {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Top 3 Students:");
        for (int i = 0; i < Math.min(3, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 85));
        students.add(new Student(2, "Bob", 91));
        students.add(new Student(3, "Charlie", 78));
        students.add(new Student(4, "David", 92));

        displayTopStudents(students);
    }
}
