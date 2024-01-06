


import java.util.List;

public class School {
    private List<Teacher> teachers; 
    private List<Student> students;
    private static int moneyEarned;
    private static int moneySpent;

    /**
     * 
     * @param teacher list of teacher in school
     * @param student list of students in school
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        moneyEarned = 0; 
        moneySpent = 0; 
    }

    public List<Teacher> getTeacher() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Student> getStudent() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getMoneyEarned() {
        return moneyEarned;
    }

    public static void updateMoneyEarned(int initMoneyEarned) {
        moneyEarned += initMoneyEarned;
    }

    public int getMoneySpent() {
        return moneySpent;
    }

    public static void updateMoneySpent(int initMoneySpent) {
        moneySpent -= initMoneySpent;
    }
    

}
