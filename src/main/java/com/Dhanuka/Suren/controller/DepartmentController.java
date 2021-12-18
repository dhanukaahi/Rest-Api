package com.Dhanuka.Suren.controller;

import com.Dhanuka.Suren.exception.ResourceNotFoundException;
import com.Dhanuka.Suren.model.Department;
import com.Dhanuka.Suren.model.HRM;
import com.Dhanuka.Suren.repository.DepartmentRepository;
import com.Dhanuka.Suren.repository.HRMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    //get all Department
    @GetMapping("/department")
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    //create Department
    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    //get Department by Id
    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department Not Exsit with id :"+id));
        return ResponseEntity.ok(department);
    }

    //update Department by Id
    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,@RequestBody Department departmentDtails){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department Not Exsit with id :"+id));

        department.setDeparmentId(departmentDtails.getDeparmentId());
        department.setDepartmentName(departmentDtails.getDepartmentName());

        Department updateDepartment = departmentRepository.save(department);

        return ResponseEntity.ok(updateDepartment);
    }

    //delete Department
    @DeleteMapping("/Department/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteDepartment(@PathVariable Long id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department Not Exsit with id :"+id));

        departmentRepository.delete(department);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
