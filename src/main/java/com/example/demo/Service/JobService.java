package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Job;
import com.example.demo.Repo.JobRepo;

@Service
public class JobService {
    

    @Autowired
    private JobRepo jobRepo;


    public Job createJob(Job job){
return this.jobRepo.save(job);
    }


    public void deleteJob(String jobId){
this.jobRepo.deleteById(jobId);
}

public Job updateJob(String jobId, Job updatedJob) {
        Optional<Job> existingJob = jobRepo.findById(jobId);
        
        if (existingJob.isPresent()) {
            Job job = existingJob.get();
            
            // Update all fields
            job.setJobProfile(updatedJob.getJobProfile());
            job.setJobRole(updatedJob.getJobRole());
            job.setDescription(updatedJob.getDescription());
            job.setExperience(updatedJob.getExperience());
            job.setShift(updatedJob.getShift());
            job.setDepartment(updatedJob.getDepartment());
            job.setemploymentType(updatedJob.getemploymentType());
            // job.setE(updatedJob.getemploymentType());
            job.setExpectedSalary(updatedJob.getExpectedSalary());
            job.setKeyword(updatedJob.getKeyword());
            job.setRolesAndResponsibility(updatedJob.getRolesAndResponsibility());
            job.setVacancy(updatedJob.getVacancy());
            
            return jobRepo.save(job);
        } else {
            throw new RuntimeException("Job not found with ID: " + jobId);
        }
    }





public Job getJobById(String jobId){
    return this.jobRepo.findById(jobId).orElse(null);
}




    public List<Job> getAllJob(){
        return this.jobRepo.findAll();
    }
    



}



