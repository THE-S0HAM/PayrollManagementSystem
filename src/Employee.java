public class Employee {

    private int empId;
    private String name;
    private String department;
    private double basicSalary;
    private double hra;
    private double da;
    private double pf;
    private double netSalary;
    private String status; // ACTIVE / INACTIVE

    public Employee() {}

    public Employee(String name, String department, double basicSalary) {
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
        this.status = "ACTIVE";
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }

    public double getDa() { return da; }
    public void setDa(double da) { this.da = da; }

    public double getPf() { return pf; }
    public void setPf(double pf) { this.pf = pf; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return empId + " | " + name + " | " + department +
                " | Basic: " + basicSalary +
                " | Net: " + netSalary +
                " | Status: " + status;
    }
}
