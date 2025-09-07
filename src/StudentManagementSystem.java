import java.util.*;

public class StudentManagementSystem {
    private static Scanner sc = new Scanner(System.in);
    private static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println(" Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Invalid choice!");
                    break;
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();
        
        Student student = new Student(0, name, age, grade);
        dao.addStudent(student);
    }

    private static void viewStudents() {
        List<Student> list = dao.getAllStudents();
        if (list.isEmpty()) {
            System.out.println(" No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : list) {
                System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge() + " | " + s.getGrade());
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Grade: ");
        String grade = sc.nextLine();

        Student student = new Student(id, name, age, grade);
        dao.updateStudent(student);
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        dao.deleteStudent(id);
    }
}
