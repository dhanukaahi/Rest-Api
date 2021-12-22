package com.Dhanuka.Suren.model;

import javax.persistence.*;

@Entity
@Table(name = "HRM")
public class HRM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "HRM_Id")
    private String HRM_Id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column (name = "password")
    private String password;

    public HRM() {

    }

    public HRM(String firstName, String lastName, String emailId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.HRM_Id = HRM_Id;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHRM_Id() {return HRM_Id;}

    public void setHRM_Id(String HRM_Id){this.HRM_Id = HRM_Id;}


}
