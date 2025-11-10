public class SaleStaff extends Employee{
    public SaleStaff(String name, String country, double salary) {
        super(name, country, salary);
    }
    private int numbersOfSale ;

    public SaleStaff() {
        super();
    }

    public SaleStaff(String name, String country, double salary, int numbersOfSale) {
        super(name, country, salary);
        this.numbersOfSale = numbersOfSale;
    }

    public int getNumbersOfSale() {
        return numbersOfSale;
    }

    public void setNumbersOfSale(int numbersOfSale) {
        this.numbersOfSale = numbersOfSale;
    }
    @Override
    public void work(){
        System.out.println("làm việc 3");
    }
}
