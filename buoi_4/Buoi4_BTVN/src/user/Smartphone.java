package user;

public class Smartphone extends Product{
    private boolean has5G;

    public Smartphone() {
    }

    public Smartphone(int id, String name, String description, double price, boolean has5G) {
        super(id, name, description, price);
        this.has5G = has5G;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(" | 5G: %s", has5G ? "Yes" : "No");
    }


}
