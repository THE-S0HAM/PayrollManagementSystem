import java.util.List;
import java.util.Scanner;

public class PayrollApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();
        PayrollService service = new PayrollService();

        while (true) {
            System.out.println("\n--- Payroll Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Apply Salary Increment");
            System.out.println("6. Deactivate Employee");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Basic Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(name, dept, salary);
                    service.calculateSalary(emp);
                    dao.addEmployee(emp);
                }

                case 2 -> dao.getAllEmployees().forEach(System.out::println);

                case 3 -> {
                    System.out.print("Employee ID: ");
                    Employee e = dao.getEmployeeById(sc.nextInt());
                    System.out.println(e != null ? e : "Employee Not Found");
                }

                case 4 -> {
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Employee e = dao.getEmployeeById(id);
                    if (e == null) {
                        System.out.println("Employee Not Found");
                        break;
                    }

                    System.out.print("New Name: ");
                    e.setName(sc.nextLine());
                    System.out.print("New Department: ");
                    e.setDepartment(sc.nextLine());
                    System.out.print("New Basic Salary: ");
                    e.setBasicSalary(sc.nextDouble());

                    service.calculateSalary(e);
                    dao.updateEmployee(e);
                }

                case 5 -> {
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Increment %: ");
                    dao.applyIncrement(id, sc.nextDouble());
                }

                case 6 -> {
                    System.out.print("Employee ID: ");
                    dao.deactivateEmployee(sc.nextInt());
                }

                case 7 -> {
                	System.out.print("Exited......");
                	System.exit(0);
                }

                default -> System.out.println("Invalid Choice");
            }
        }
    }
}
