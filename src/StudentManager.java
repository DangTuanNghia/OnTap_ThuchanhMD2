import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDAO studentDAO;

    public StudentManager() {
        studentDAO = new StudentDAO();
        studentList = studentDAO.read();
    }

    public void addStudent() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("studentId =" + id);
        String name = inputName();
        int age = inputAge();
        String address = inputAddress();
        float gpa = inputGpa();
        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentDAO.write(studentList);
    }

    public void editStudent(int id) {
        boolean isExited = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExited = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExited) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentDAO.write(studentList);
        }
    }

    public void deleteStudent(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentDAO.write(studentList);
        } else {
            System.out.printf("id = %d not exited. \n", id);
        }
    }

    public void sortStudentByGpa(){
        Collections.sort(studentList, new SortStudentByName());
    }

    public void sortStudentByName(){
        Collections.sort(studentList, new SortStudentByName());
    }

    public void showAllStudent(){
        for (Student student: studentList){
            System.out.format("%5d |", student.getId());
            System.out.format("%20s |", student.getName());
            System.out.format("%5d |", student.getAge());
            System.out.format("%20s |", student.getAddress());
            System.out.format("%10.1f%n |", student.getGpa());
        }
    }

    public int inputId() {
        System.out.println("input Student Id:");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException e) {
                System.out.println("invalid! Input student id again:");
            }
        }
    }

    private String inputName() {
        System.out.println("Input Student Name:");
        return scanner.nextLine();
    }

    private int inputAge() {
        System.out.println("Input Student Age:");
        while (true) {
            try {
                int age = Integer.parseInt((scanner.nextLine()));
                if (age < 0 || age > 80) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("invalid! Input student age again:");
            }
        }
    }

    private String inputAddress() {
        System.out.println("Input Student Address:");
        return scanner.nextLine();
    }

    private float inputGpa() {
        System.out.println("Input Student Gpa");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException e) {
                System.out.println("invalid! Input student gpa again:");
            }
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
