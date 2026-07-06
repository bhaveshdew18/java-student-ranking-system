public class Student implements Comparable<Student> {
    private int rollNumber;
    private String name;
    private double marks;

    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        setMarks(marks);
    }

    public int getRollNumber() {
        return rollNumber;
    }
    public String getName() {
        return name;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 to 100");
        }
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getMarks(), this.getMarks());
    }
}