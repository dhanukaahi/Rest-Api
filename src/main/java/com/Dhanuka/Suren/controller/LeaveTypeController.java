package com.Dhanuka.Suren.controller;

import com.Dhanuka.Suren.exception.ResourceNotFoundException;
import com.Dhanuka.Suren.model.HRM;
import com.Dhanuka.Suren.model.LeaveType;
import com.Dhanuka.Suren.repository.HRMRepository;
import com.Dhanuka.Suren.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    //get all LeaveType
    @GetMapping("/leavetype")
    public List<LeaveType> getAllLeaveType(){
        return leaveTypeRepository.findAll();
    }

    //create LeaveType
    @PostMapping("/leavetype")
    public LeaveType createLeaveType(@RequestBody LeaveType leaveType){
        return leaveTypeRepository.save(leaveType);
    }

    //get LeaveType by Id
    @GetMapping("/leavetype/{id}")
    public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable Long id){
        LeaveType leaveType = leaveTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveType Not Exsit with id :"+id));
        return ResponseEntity.ok(leaveType);
    }

    //update Employee by Id
    @PutMapping("/leavetype/{id}")
    public ResponseEntity<LeaveType> updateLeaveType(@PathVariable Long id,@RequestBody LeaveType leaveTypeDtails){
        LeaveType leaveType = leaveTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HRM Not Exsit with id :"+id));

        leaveType.setLeaveType(leaveTypeDtails.getLeaveType());
        leaveType.setDescription(leaveTypeDtails.getDescription());

        LeaveType updateLeaveType = leaveTypeRepository.save(leaveType);

        return ResponseEntity.ok(updateLeaveType);
    }

    //delete HRM
    @DeleteMapping("/leavetype/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteLeaveType(@PathVariable Long id){
        LeaveType leaveType = leaveTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveType Not Exsit with id :"+id));

        leaveTypeRepository.delete(leaveType);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
