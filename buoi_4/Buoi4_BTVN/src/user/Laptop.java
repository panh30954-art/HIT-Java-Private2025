package user;

public class Laptop extends Product{
    private String ram;
    private String cpu;

    public Laptop() {
    }

    public Laptop(int id, String name, String description, double price, String ram, String cpu) {
        super(id, name, description, price);
        this.ram = ram;
        this.cpu = cpu;
    }
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(" | RAM: %s | CPU: %s", ram, cpu);
    }


}
