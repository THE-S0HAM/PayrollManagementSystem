import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee emp) {
        String sql = """
            INSERT INTO employee
            (name, department, basic_salary, hra, da, pf, net_salary, status)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getBasicSalary());
            ps.setDouble(4, emp.getHra());
            ps.setDouble(5, emp.getDa());
            ps.setDouble(6, emp.getPf());
            ps.setDouble(7, emp.getNetSalary());
            ps.setString(8, emp.getStatus());

            ps.executeUpdate();
            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE status='ACTIVE'";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Employee e = mapEmployee(rs);
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE emp_id=? AND status='ACTIVE'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapEmployee(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee emp) {
        String sql = """
            UPDATE employee 
            SET name=?, department=?, basic_salary=?, hra=?, da=?, pf=?, net_salary=?
            WHERE emp_id=? AND status='ACTIVE'
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getBasicSalary());
            ps.setDouble(4, emp.getHra());
            ps.setDouble(5, emp.getDa());
            ps.setDouble(6, emp.getPf());
            ps.setDouble(7, emp.getNetSalary());
            ps.setInt(8, emp.getEmpId());

            ps.executeUpdate();
            System.out.println("Employee Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void applyIncrement(int empId, double percent) {
        String sql = """
            UPDATE employee 
            SET basic_salary = basic_salary + (basic_salary * ? / 100)
            WHERE emp_id=? AND status='ACTIVE'
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, percent);
            ps.setInt(2, empId);

            ps.executeUpdate();
            System.out.println("Increment Applied Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deactivateEmployee(int id) {
        String sql = "UPDATE employee SET status='INACTIVE' WHERE emp_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee Deactivated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Employee mapEmployee(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setEmpId(rs.getInt("emp_id"));
        e.setName(rs.getString("name"));
        e.setDepartment(rs.getString("department"));
        e.setBasicSalary(rs.getDouble("basic_salary"));
        e.setHra(rs.getDouble("hra"));
        e.setDa(rs.getDouble("da"));
        e.setPf(rs.getDouble("pf"));
        e.setNetSalary(rs.getDouble("net_salary"));
        e.setStatus(rs.getString("status"));
        return e;
    }
}
