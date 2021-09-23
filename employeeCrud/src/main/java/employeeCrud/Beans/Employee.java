package employeeCrud.Beans;

public class Employee {

	
	private Integer empId;
	private String department;
	private Double salary;

	public Employee(Integer empId, String department, Double salary) {
		super();
		this.empId = empId;
		this.department = department;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}
	
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", department=" + department + ", salary=" + salary + "]";
	}
	
}
