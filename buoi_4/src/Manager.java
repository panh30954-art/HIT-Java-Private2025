import java.util.ArrayList;

public class Manager extends Employee{
    public ArrayList<SaleStaff> saleStaff ;
    public ArrayList<Technician> technician ;

    public Manager(String name, String country, double salary) {
        super(name, country, salary);
    }
    public SaleStaff getSaleStaffById(int saleStaffid){
        System.out.println("getSaleStaffById");
        return saleStaff.get(saleStaffid);
    }
    public Technician  getTechnicianById(int technicianid ){
        System.out.println("getTechnicianById");
        return technician.get(technicianid);
    }

    public Manager(String name, String country, double salary, ArrayList<SaleStaff> saleStaff, ArrayList<Technician> technician) {
        super(name, country, salary);
        this.saleStaff = saleStaff;
        this.technician = technician;
    }
}
