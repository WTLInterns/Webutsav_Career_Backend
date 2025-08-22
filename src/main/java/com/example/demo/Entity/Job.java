package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ElementCollection;

@Entity
public class Job {
    
 @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String jobId;

    private String jobProfile;

    private String jobRole;

    @Lob
    @Column(columnDefinition = "TEXT")  // for MySQL / PostgreSQL
    private String description;

    private String experience;

    private String shift;

    private String department;

    private String employmentType;

    private String isActive;

    private String expectedSalary;

    private LocalDate postedDate;

    // For List<String>, you should map separately using @ElementCollection
    // Example:
    @ElementCollection
    private List<String> keyword;

    @ElementCollection
    private List<String> rolesAndResponsibility;

    private String vacancy;


    public Job(String department, String description, String employmentType, String experience, String jobId, String jobProfile, String jobRole, String shift, String isActive,String expectedSalary, LocalDate postedDate, List<String> keyword, List<String> rolesAndResponsibility, String vacancy) {
        this.department = department;
        this.description = description;
        this.rolesAndResponsibility=rolesAndResponsibility;
        this.expectedSalary=expectedSalary;
        this.vacancy=vacancy;
        this.keyword=keyword;
        this.isActive=isActive;
        this.employmentType = employmentType;
        this.postedDate=postedDate;
        this.experience = experience;
        this.jobId = jobId;
        this.jobProfile = jobProfile;
        this.jobRole = jobRole;
        this.shift = shift;
    }


    public Job(){
        super();
    }

    

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }
    

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getemploymentType() {
        return employmentType;
    }

    public void setemploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    public List<String> getRolesAndResponsibility() {
        return rolesAndResponsibility;
    }

    public void setRolesAndResponsibility(List<String> rolesAndResponsibility) {
        this.rolesAndResponsibility = rolesAndResponsibility;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }










}

