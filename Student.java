
import java.util.List;
import java.util.ArrayList;

//This student class keeps track of student fees paid/total, id#, name and grade

public class Student { 
    private int id;
    private String name; 
    private int grade; 
    private int feesPaid;
    private int feesTotal;
    private List<String> courses;


    // constructs a new student object by initializing
    /**
     * total fee for the school year is $20,000/year
     * fees paid starts at 0
     * @param id id for the new student, unique #
     * @param name name of the new student
     * @param grade grade of the new student 
     */
    public Student(int id, String name, int grade) { 
        this.id = id; 
        this.name = name;
        this.grade = grade;
        feesPaid = 0; 
        feesTotal = 20000;
        this.courses = new ArrayList<>();
    }

    // Can change a students grade when the school year ends 
    public void setGrade(int grade) { 
        this.grade = grade;
    }
    // keeps track of fees paid
    public void updateFeesPaid(int fees) { 
        feesPaid += fees;
        School.updateMoneyEarned(feesPaid);

    }

    // Getter methods for the Student fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public int getRemainingFees() { 
        return feesTotal-feesPaid;
    }
    public String toString() { 
        return "Students name: " + name +
         "\n Current total amount of fees paid $" + feesPaid;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(String course) {
        courses.add(course);
        feesTotal+=600; // each additional course costs $600
    }
}