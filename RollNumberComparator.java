import java.util.Comparator;

public class RollNumberComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getRollNumber(),student2.getRollNumber());
    }
    
}
