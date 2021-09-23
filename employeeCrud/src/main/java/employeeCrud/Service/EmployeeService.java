package employeeCrud.Service;

import java.util.List;

import employeeCrud.Beans.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee) throws Exception;

	public  Employee getEmployee(Integer empID) throws Exception;

	public Employee deleteEmployee(int empId) throws Exception;

	public List<Employee> filteredEmployee(String department) throws Exception;
}