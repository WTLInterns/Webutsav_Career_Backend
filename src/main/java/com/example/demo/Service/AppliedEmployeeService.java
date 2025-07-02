package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.AppliedEmployee;
import com.example.demo.Repo.AppliedEmployeeRepo;

@Service
public class AppliedEmployeeService {
    

    @Autowired
    private AppliedEmployeeRepo appliedEmployeeRepo;

    public AppliedEmployee createAppliedEmployee(AppliedEmployee appliedEmployee){
        return this.appliedEmployeeRepo.save(appliedEmployee);
    }

    public AppliedEmployee getAppliedEmployeeById(int applicationId){
        return this.appliedEmployeeRepo.findById(applicationId).orElse(null);
    }

    public void deleteAppliedEmployee(int applicationId){
        this.appliedEmployeeRepo.deleteById(applicationId);
    }

   public List<AppliedEmployee> getAllAppliedEmployee(){
        return this.appliedEmployeeRepo.findAll();
    }
    

}
