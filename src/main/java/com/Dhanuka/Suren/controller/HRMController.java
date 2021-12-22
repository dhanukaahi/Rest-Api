package com.Dhanuka.Suren.controller;

import com.Dhanuka.Suren.exception.ResourceNotFoundException;
import com.Dhanuka.Suren.model.HRM;
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
public class HRMController {

    @Autowired
    private HRMRepository hrmRepository;

    //get all HRM
    @GetMapping("/hrm")
    public List<HRM> getAllHRM(){
        return hrmRepository.findAll();
    }

    //create HRM
    @PostMapping("/hrm")
    public HRM createHRM(@RequestBody HRM hrm){
        return hrmRepository.save(hrm);
    }

    //get HRM by Id
    @GetMapping("/hrm/{id}")
    public ResponseEntity<HRM> getHRMById(@PathVariable Long id){
        HRM hrm = hrmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HRM Not Exsit with id :"+id));
        return ResponseEntity.ok(hrm);
    }

    //update Employee by Id
    @PutMapping("/hrm/{id}")
    public ResponseEntity<HRM> updateHRM(@PathVariable Long id,@RequestBody HRM hrmDtails){
        HRM hrm = hrmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HRM Not Exsit with id :"+id));

        hrm.setFirstName(hrmDtails.getFirstName());
        hrm.setLastName(hrmDtails.getLastName());
        hrm.setEmailId(hrmDtails.getEmailId());
        hrm.setPassword(hrmDtails.getPassword());

        HRM updateHRM = hrmRepository.save(hrm);

        return ResponseEntity.ok(updateHRM);
    }

    //delete HRM
    @DeleteMapping("/hrm/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteHRM(@PathVariable Long id){
        HRM hrm = hrmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HRM Not Exsit with id :"+id));

        hrmRepository.delete(hrm);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
