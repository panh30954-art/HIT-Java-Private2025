import java.util.UUID;

public class User {
    private String name  ;
    private int id ;
    private double balance ;
    public User() {
    }



    public User(String name, int id, double balance) {
        this.name = name;
        this.id = UUID.randomUUID().toString() ;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }
    public void deposit(double amount ){
        if(amount > 0 ){
            balance += amount ;
            System.out.println(name + " đã nạp " + amount );
            System.out.println("tổng số tiền có trong tài khoản là " + balance);
        }
        else
            System.out.println(" số tiền không hợp lệ ");

    }
    public void withDraw(double amount ){
        if (balance > amount ){
            balance -=amount ;


        }
    }


}
