import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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
        System.out.println("8. Sort by Roll Number");
        System.out.println("9. Exit");
        System.out.println();
    }

    public static void addStudent(ArrayList<Student> students, Scanner scanner) {
        int rollNumber;
        String name;
        double marks;

        System.out.println("Enter Roll Number: ");
        rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Name: ");
        name = scanner.nextLine();

        System.out.println("Enter Marks: ");
        marks = scanner.nextDouble();

        students.add(new Student(rollNumber, name, marks));
        System.out.println("Student added successfully.");
    }

    public static Student findByRollNumber(ArrayList<Student> students, int rollNumber) {
        for(Student student : students) {
            if(student.getRollNumber() == rollNumber){
                return student;
            }
        }
        return null;

    }

    public static void searchStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findByRollNumber(students, rollNumber);
        if(student != null) {
            displayStudent(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void updateMarks(ArrayList<Student> students, Scanner scanner) {
        System.out.println("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findByRollNumber(students, rollNumber);
        if(student != null) {
            System.out.println("Enter new Marks: ");
            try {
            double marks = scanner.nextDouble();
            student.setMarks(marks);
            System.out.println("Marks updated successfully.");
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void deleteStudent(ArrayList<Student> students, Scanner scanner) {
         System.out.println("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findByRollNumber(students, rollNumber);
        if(student != null) {
            students.remove(student);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void performOperation(int choice, ArrayList<Student> students, Scanner scanner) {
        switch (choice) {
            case 1:
                addStudent(students, scanner);
                break;
            
            case 2:
                displayStudents(students);
                break;

            case 3:
                searchStudent(students, scanner);
                break;

            case 4:
                updateMarks(students, scanner);
                break;

            case 5:
                deleteStudent(students, scanner);
                break;

            case 6:
                Collections.sort(students);
                displayStudents(students);
                break;

            case 7:
                Collections.sort(students, new NameComparator());
                displayStudents(students);
                break;

            case 8:
                Collections.sort(students, new RollNumberComparator());
                displayStudents(students);
                break;

            case 9:
                System.out.println("Exitining");
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void createSampleStudents(ArrayList<Student> students) {
        students.add(new Student(101, "Steve", 92));
        students.add(new Student(102, "John", 47));
        students.add(new Student(103, "Mark", 81));
        students.add(new Student(104, "Alice", 76));
        students.add(new Student(105, "Bob", 88));
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
        int choice;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students  = new ArrayList<>();
        createSampleStudents(students);
        do {
            printMenu();
            choice = scanner.nextInt();
            performOperation(0, students, scanner);
        } while (choice != 9);
        scanner.close();
    }
}
