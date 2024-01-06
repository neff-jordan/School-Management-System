import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 

        System.out.println("-----------------------------------------");
        System.out.println("Welcome to the WCU Management Portal");
        System.out.println("-----------------------------------------");

        List<Student> studentsList = new ArrayList<>();
        List<Teacher> teachersList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1) See School Finances");
            System.out.println("2) Add a Teacher");
            System.out.println("3) Student Portal");
            System.out.println("4) Exit");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    schoolFinances(studentsList, teachersList);
                    break;
                case 2:
                    teacherPortal(teachersList, scan);
                    break;
                case 3:
                    studentPortal(studentsList);
                    break;
                case 4:
                    System.out.println("Exiting WCU Management Portal. Goodbye!");
                    System.exit(0); // This terminates the program
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
   
    public static void schoolFinances(List<Student> studentsList, List<Teacher> teachersList) { 
        School wcu = new School(teachersList, studentsList);
        System.out.println("Total money WCU has earned: $" + wcu.getMoneyEarned());
        System.out.println("Total money WCU has spent: $" + wcu.getMoneySpent());
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: \n1) List All Students \n2) List All Teachers \n3) Return to Main Menu");
        int option = scanner.nextInt();
    
        switch (option) {
            case 1:
                listAllStudents(wcu.getStudent());
                break;
            case 2:
                listAllTeachers(wcu.getTeacher());
                break;
            case 3:
                // User chose to return to the main menu
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    private static void listAllStudents(List<Student> students) {
        System.out.println("List of All Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Grade: " + student.getGrade());
        }
    }
    private static void listAllTeachers(List<Teacher> teachers) {
        System.out.println("List of All Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("ID: " + teacher.getID() + ", Name: " + teacher.getName() + ", Salary: $" + teacher.getSalary());
        }
    }
   
    public static void teacherPortal(List<Teacher> teachersList, Scanner sc) { 
        System.out.println("Options: \n1) Add Teachers \n2) Check Salary \n3) Update Salary");
        int secondCheck = sc.nextInt();
        if(secondCheck == 1) { 
            System.out.println("How many teachers do you want to add?");
            int teacherCount = sc.nextInt();
            for(int i = 0; i < teacherCount; i++) { 
                System.out.println("Enter name and salary: ");
                String name = sc.next();
                int salary = sc.nextInt();
                // Assuming you have a constructor for Teacher that takes name and salary parameters
                Teacher newTeacher = new Teacher(teachersList.size() + 1, name, salary);
                teachersList.add(newTeacher);
            }
            System.out.println("Teachers added successfully!");
        } else if(secondCheck == 2) { 
            System.out.println("Enter the name of the teacher whose salary you want to check:");
            String nameSearch = sc.next();
            boolean found = false;
            for (Teacher teacher : teachersList) {
                if (teacher.getName().equalsIgnoreCase(nameSearch)) {
                    System.out.println("Salary of " + nameSearch + ": $" + teacher.getSalary());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Teacher not found.");
            }
        } else if(secondCheck == 3) { 
            System.out.println("Enter the name of the teacher whose salary you want to update:");
            String nameSearch = sc.next();
            boolean found = false;
            for (Teacher teacher : teachersList) {
                if (teacher.getName().equalsIgnoreCase(nameSearch)) {
                    System.out.println("Enter the new salary for " + nameSearch + ": ");
                    int newSalary = sc.nextInt();
                    teacher.setSalary(newSalary);
                    System.out.println(nameSearch + "'s salary updated successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Teacher not found.");
            }
        } else { 
            // Invalid option
            System.out.println("Invalid option.");
        }
        // Add return option to main portal 
    }
   
    public static void studentPortal(List<Student> studentsList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Options: \n1) Add Courses \n2) Check Fees \n3) Update Grade \n4) Add Student");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                addCourses(studentsList, sc);
                break;
            case 2:
                checkFees(studentsList, sc);
                break;
            case 3:
                updateGrade(studentsList, sc);
                break;
            case 4:
                addStudent(studentsList, sc);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    private static void addCourses(List<Student> studentsList, Scanner sc) {
        System.out.println("Enter student's name to add courses:");
        String studentName = sc.next();
        boolean found = false;
        for (Student student : studentsList) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Enter the course to add:");
                String course = sc.next();
                student.setCourses(course);
                System.out.println("Course added successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    private static void checkFees(List<Student> studentsList, Scanner sc) {
        System.out.println("Enter student's name to check fees:");
        String studentName = sc.next();
        boolean found = false;
        for (Student student : studentsList) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Total fees paid by " + studentName + ": $" + student.getFeesPaid());
                System.out.println("Remaining fees: $" + student.getRemainingFees());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    private static void updateGrade(List<Student> studentsList, Scanner sc) {
        System.out.println("Enter student's name to update grade:");
        String studentName = sc.next();
        boolean found = false;
        for (Student student : studentsList) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Enter the new grade for " + studentName + ": ");
                int newGrade = sc.nextInt();
                student.setGrade(newGrade);
                System.out.println(studentName + "'s grade updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    private static void addStudent(List<Student> studentsList, Scanner sc) {
        System.out.println("Enter new student's name:");
        String name = sc.next();
        System.out.println("Enter new student's grade:");
        int grade = sc.nextInt();

        int newStudentID = studentsList.size() + 1; // Assuming student ID is based on the size of the list
        Student newStudent = new Student(newStudentID, name, grade);
        studentsList.add(newStudent);

        System.out.println("Student added successfully!");
    }
}