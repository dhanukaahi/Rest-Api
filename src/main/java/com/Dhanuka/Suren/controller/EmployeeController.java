package com.Dhanuka.Suren.controller;

import com.Dhanuka.Suren.exception.ResourceNotFoundException;
import com.Dhanuka.Suren.model.Employee;
import com.Dhanuka.Suren.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create Employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get Employee by Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Exsit with id :"+id));
        return ResponseEntity.ok(employee);
    }

    //update Employee by Id
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDtails){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Exsit with id :"+id));

        employee.setFirstName(employeeDtails.getFirstName());
        employee.setLastName(employeeDtails.getLastName());
        employee.setEmailId(employeeDtails.getEmailId());
        employee.setPassword(employeeDtails.getPassword());

        Employee updateEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updateEmployee);
    }

    //delete Employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Exsit with id :"+id));

        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
