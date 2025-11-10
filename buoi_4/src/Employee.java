import java.util.UUID;

public class Employee {
    private String id ;
    private String name ;
    private String country ;
    private double salary ;

    public Employee(String name, String country, double salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.country = country;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void work(){
        System.out.println("làm việc ");

    }
}
