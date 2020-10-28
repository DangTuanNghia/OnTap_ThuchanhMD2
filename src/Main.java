import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String chose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;
        showMenu();
        while (true){
            chose = s.nextLine();
            switch (chose){
                case "1":
                    studentManager.addStudent();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.editStudent(studentId);
                    break;
                case "3":
                    studentId = studentManager.inputId();
                    studentManager.deleteStudent(studentId);
                    break;
                case "4":
                    studentManager.sortStudentByGpa();
                    break;
                case "5":
                    studentManager.sortStudentByName();
                    break;
                case "6":
                    studentManager.showAllStudent();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }if (exit){
                break;
            }
            showMenu();
        }
    }

    public static void showMenu(){
        System.out.println("-------------------MENU------------------");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student By Id");
        System.out.println("3. Delete Student By Id");
        System.out.println("4. Sort Student By GPA");
        System.out.println("5. Sort Student By Name");
        System.out.println("6. Show Student");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------");
    }

}
