package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.AppliedEmployee;
import com.example.demo.Service.AppliedEmployeeService;
import com.example.demo.Service.CloudinaryService;

@RestController
@RequestMapping("employees")
public class AppliedEmployeeController {
    
@Autowired
private AppliedEmployeeService appliedEmployeeService;

@Autowired
private CloudinaryService cloudinaryService;


 @PostMapping("/apply")
    public ResponseEntity<AppliedEmployee> submitApplication(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("jobRole") String jobRole,
            @RequestParam("department") String department,
            @RequestParam("experience") String experience,
            @RequestParam("resume") MultipartFile resume) throws IOException {

        // Create the AppliedEmployee object from form data
        AppliedEmployee employee = new AppliedEmployee();
        employee.setFullName(fullName);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setJobRole(jobRole);
        employee.setDepartment(department);
        employee.setExperience(experience);

         if (resume != null && !resume.isEmpty()) {
                // resume.setResume(cloudinaryService.upload(resume));
                employee.setResume(cloudinaryService.upload(resume));
            }

        // Call service to handle resume upload and DB save
        AppliedEmployee savedEmployee = appliedEmployeeService.createAppliedEmployee(employee);

        return ResponseEntity.ok(savedEmployee);
    }



    @GetMapping("/getAllAppliedEmployees")
    public List<AppliedEmployee> getAllAppliedEmployee(){
        return this.appliedEmployeeService.getAllAppliedEmployee();
    }

    /**
     * Get employee by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<AppliedEmployee> getEmployeeById(@PathVariable int id) {
        AppliedEmployee employee = appliedEmployeeService.getAppliedEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update employee resume
     */
    // @PutMapping("/{id}/resume")
    // public ResponseEntity<?> updateEmployeeResume(
    //         @PathVariable int id,
    //         @RequestParam("resume") MultipartFile resumeFile) {

    //     try {
    //         AppliedEmployee updatedEmployee = appliedEmployeeService.updateEmployeeResume(id, resumeFile);
    //         return ResponseEntity.ok(updatedEmployee);
    //     } catch (IOException e) {
    //         return ResponseEntity.status(500).body("Error uploading resume: " + e.getMessage());
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    /**
     * Delete employee with resume cleanup
     */
    

     

}
