public class PayrollService {

    public void calculateSalary(Employee emp) {

        // this method calculates the salary components
        double basic = emp.getBasicSalary();
        double hra = basic * 0.20;
        double da = basic * 0.10;
        double pf = basic * 0.12;

        double netSalary = basic + hra + da - pf;

        emp.setHra(hra);
        emp.setDa(da);
        emp.setPf(pf);
        emp.setNetSalary(netSalary);
    }
}
