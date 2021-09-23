package employeeCrud.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import employeeCrud.Beans.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

	public Employee addEmployee(Employee employee) throws Exception
	{

		if(employeeMap.containsKey(employee.getEmpId())) {
			throw new Exception("Employee already exists");
		}
		else {
			employeeMap.put(employee.getEmpId(), employee);
		}
		
		return employee;
	}

	public Employee getEmployee(Integer empID) throws Exception {

		if(employeeMap.containsKey(empID)) {
			return employeeMap.get(empID);
		}
		else {
			throw new Exception("Employee not found");
		}
	}

	public Employee deleteEmployee(int empId) throws Exception {

		if(employeeMap.containsKey(empId)) {
			return employeeMap.remove(empId);
		}
		else {
			throw new Exception("Employee not found");
		}
	}
	
	public List<Employee> filteredEmployee(String department){
		
		 List<Employee> filterEmployee = employeeMap.entrySet().stream()
		.filter(x->x.getValue().getDepartment().equalsIgnoreCase(department))
		.map(x->x.getValue()).collect(Collectors.toList());
		
		return filterEmployee;
	}
}
