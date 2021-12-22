package com.Dhanuka.Suren.model;

import javax.persistence.*;

@Entity
@Table(name = "Leave_Type")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Leave_Type")
    private String LeaveType;
    @Column(name = "Description")
    private String Description;

    public LeaveType() {

    }

    public LeaveType(Long id, String leaveType, String description) {
        this.id = id;
        LeaveType = leaveType;
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
