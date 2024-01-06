


public class Teacher {
    private int id; 
    private String name;
    private int salary; 
    private int salaryEarned;

    /**
     * 
     * @param id
     * @param name
     * @param salary
     */
    public Teacher(int id, String name, int salary) { 
        this.id = id; 
        this.name = name; 
        this.salary = salary;
        salaryEarned = 0; 
    }

    // Creates getter and setter methods for the given field variables
    public int getID() { 
        return id; 
    }
    public String getName() { 
        return name;
    }
    public int getSalary() { 
        return salary;
    }
    // updates the teachers salary if they get a raise
    public void setSalary(int salary) { 
        this.salary = salary;
    }
    public void receiveSalary(int salary) { 
        salaryEarned+=salary;
        School.updateMoneySpent(salary);
    }
    public String toString() { 
        return "Teacher name: " + name + "\n Salary earned: " + salaryEarned;
    }

}
