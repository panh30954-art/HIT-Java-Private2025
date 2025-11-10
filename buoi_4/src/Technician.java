public class Technician extends Employee{
    private String techSkill ;

    public Technician(String name, String country, double salary) {
        super(name, country, salary);
    }

    public String getTechSkill() {
        return techSkill;
    }

    public void setTechSkill(String techSkill) {
        this.techSkill = techSkill;
    }
    @Override
    public void work()
    {
        System.out.println("làm việc 2");
    }
}
