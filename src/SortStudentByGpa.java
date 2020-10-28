import java.util.Comparator;

public class SortStudentByGpa implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getGpa() > student2.getGpa()) {
            return 0;
        } else return -1;
    }
}
