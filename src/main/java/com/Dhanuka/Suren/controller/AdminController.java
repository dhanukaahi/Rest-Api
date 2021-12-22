package com.Dhanuka.Suren.controller;

import com.Dhanuka.Suren.exception.ResourceNotFoundException;
import com.Dhanuka.Suren.model.Admin;
import com.Dhanuka.Suren.model.Employee;
import com.Dhanuka.Suren.repository.AdminRepository;
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
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    //get all Admin
    @GetMapping("/admin")
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    //create Admin
    @PostMapping("/admin")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

    //get Admin by Id
    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin Not Exsit with id :"+id));
        return ResponseEntity.ok(admin);
    }

    //update Admin by Id
    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,@RequestBody Admin adminDtails){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin Not Exsit with id :"+id));

        admin.setFirstName(adminDtails.getFirstName());
        admin.setLastName(adminDtails.getLastName());
        admin.setEmailId(adminDtails.getEmailId());
        admin.setPassword(adminDtails.getPassword());

        Admin updateAdmin = adminRepository.save(admin);

        return ResponseEntity.ok(updateAdmin);
    }

//    //delete Admin
//    @DeleteMapping("/admin/{id}")
//    public ResponseEntity<Map<String,Boolean>> deleteAdmin(@PathVariable Long id){
//        Admin admin = adminRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Admin Not Exsit with id :"+id));
//
//        adminRepository.delete(admin);
//        Map<String,Boolean> response = new HashMap<>();
//        response.put("delete",Boolean.TRUE);
//
//        return ResponseEntity.ok(response);
//    }

}
