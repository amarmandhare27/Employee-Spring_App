package employeeCrud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import employeeCrud.Beans.Employee;
import employeeCrud.Controller.EmployeeController;
import employeeCrud.Service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeCRUDTest {

	@Autowired
	private EmployeeController controller;
	
	@MockBean
	private EmployeeService service;
	
	@Test
	public void getEmployee() throws Exception
	{
		when(service.getEmployee(1)).thenReturn(new Employee(1, "Dev", 10000.00));
		
		System.out.println(controller.getEmployee(1).getBody());
		assertNotNull(controller.getEmployee(1).getBody().toString());
	}
	
	@Test
	public void addEmployee() throws Exception
	{
		Employee emp = new Employee(1, "Dev", 1000.00);
		when(service.addEmployee(emp)).thenReturn(new Employee(1, "Dev", 10000.00));
		assertEquals(1, service.addEmployee(emp).getEmpId());
	}
	
	@Test
	public void deleteEmployee() throws Exception
	{
		when(service.getEmployee(1)).thenReturn(new Employee(1, "Dev", 10000.00));
		assertEquals(1, service.getEmployee(1).getEmpId());
	}
}
