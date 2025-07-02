package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppliedEmployee {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int applicationId;

    private String fullName;

    private String email;

    private String phone;

    private String jobRole;

    private String resume;

    private String department;

    private String experience;

     private LocalDate appliedDate;


    public AppliedEmployee(int applicationId, String department, String email, String experience, String fullName, String jobRole, String phone, String resume, LocalDate appliedDate) {
        this.applicationId = applicationId;
        this.department = department;
        this.email = email;
        this.experience = experience;
        this.fullName = fullName;
        this.jobRole = jobRole;
        this.phone = phone;
        this.resume = resume;
        this.appliedDate = appliedDate;
    }

    public  AppliedEmployee(){
        super();
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
















}





