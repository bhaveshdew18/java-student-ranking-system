import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentRanking {

    public static void printMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Display Student");
        System.out.println("3. Search Student");
        System.out.println("4. Update Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Sort by Marks");
        System.out.println("7. Sort by Name");
        System.out.println("8. Exit");
        System.out.println();
    }

    public static void createSampleStudents(ArrayList<Student> students) {
        Student student1 = new Student(101, "Steve", 92);
        Student student2 = new Student(102, "John", 47);
        Student student3 = new Student(103, "Mark", 81);
        Student student4 = new Student(104, "Alice", 76);
        Student student5 = new Student(105, "Bob", 88);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    public static void displayStudent(Student student) {
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Name: " + student.getName());
        System.out.println("Marks: " + student.getMarks());
    }

    public static void displayStudents(ArrayList<Student> students) {
        for(Student student : students) {
            displayStudent(student);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students  = new ArrayList<>();
        createSampleStudents(students);
        Collections.sort(students);
        displayStudents(students);
        scanner.close();
    }
}
