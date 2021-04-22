package tech.crud.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.crud.employeemanager.model.Employee;
import tech.crud.employeemanager.service.EmplyoeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmplyoeeService emplyoeeService;

    public EmployeeResource(EmplyoeeService emplyoeeService) {
        this.emplyoeeService = emplyoeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllemployee(){
        List<Employee> employees = emplyoeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = emplyoeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    } 

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = emplyoeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = emplyoeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        emplyoeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
