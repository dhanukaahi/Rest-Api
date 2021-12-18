package com.Dhanuka.Suren.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name = "Department_id")
    private long DeparmentId;
    @Column(name = "Department_Name")
    private String DepartmentName;

    public Department() {

    }
    public Department(long deparmentId, String departmentName) {
        DeparmentId = deparmentId;
        DepartmentName = departmentName;
    }

    public long getDeparmentId() {
        return DeparmentId;
    }

    public void setDeparmentId(long deparmentId) {
        DeparmentId = deparmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
