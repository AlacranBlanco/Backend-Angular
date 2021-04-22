package tech.crud.employeemanager.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.crud.employeemanager.exception.UserNotFoundException;
import tech.crud.employeemanager.model.Employee;
import tech.crud.employeemanager.repository.EmployeeRepo;


@Service
@Transactional
public class EmplyoeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmplyoeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                    .orElseThrow(() -> new UserNotFoundException("The employee was not found"));
    }


    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    } 
}
