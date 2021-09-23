package employeeCrud;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.ArgumentMatchers.*;
import employeeCrud.Beans.Employee;
import employeeCrud.Controller.EmployeeController;
import employeeCrud.Service.EmployeeService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMVC;
	
	@InjectMocks
	private EmployeeController controller;
	
	@MockBean
	private EmployeeService service;
	
	@Before
	public void setup() throws Exception
	{
		Mockito.when(service.getEmployee(1)).thenReturn(new Employee(1, "Dev", 10000.00));
		Mockito.when(service.addEmployee(any(Employee.class))).thenReturn(new Employee(1, "Dev", 10000.00));
	}
	
	@Test
	public void getEmployee() throws Exception
	{
		mockMVC.perform(MockMvcRequestBuilders.get("/api/getEmployee").param("empId", "1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void addEmployee() throws Exception
	{
		ObjectMapper om = new ObjectMapper();
		Employee emp = new Employee(1, "Dev", 10000.00);
		String request = om.writeValueAsString(emp);

		mockMVC.perform(MockMvcRequestBuilders.post("/api/addEmployee")
				.content(request).contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());

	}
}
