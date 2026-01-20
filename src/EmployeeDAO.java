import java.util.List;

public interface EmployeeDAO {
    // CRUD Operations, this is the Data Access Object interface

    void addEmployee(Employee emp);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    void updateEmployee(Employee emp);

    void applyIncrement(int empId, double percent);

    void deactivateEmployee(int id);
}
