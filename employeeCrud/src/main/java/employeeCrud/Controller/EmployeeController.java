package employeeCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import employeeCrud.Beans.Employee;
import employeeCrud.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired 
	EmployeeService empService;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity addEmployee(@RequestBody Employee employee) 	{
		Employee emp = null;

		try {
			emp =  empService.addEmployee(employee);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body("Employee " + emp.getEmpId() +" Added Successfully");
	}

	@GetMapping("/getEmployee")	
	public ResponseEntity getEmployee(@RequestParam Integer empId) 
	{
		Employee emp =null;
		try
		{
			emp =  empService.getEmployee(empId);	
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(emp);
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@RequestParam("empId") int empId) {
		Employee emp = null;
		try {
			emp =  empService.deleteEmployee(empId);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body("Employee " + emp.getEmpId() +" Deleted Successfully : ");
	}
	
	@RequestMapping(value = "/filterEmployee", method = RequestMethod.GET)
	public ResponseEntity filteredEmployee(@RequestParam("dpt") String department) {
		List<Employee> emps = null;
		try {
			 emps =  empService.filteredEmployee(department);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(emps);
	}
}
