package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Job;
import com.example.demo.Service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {
    

    @Autowired
    private JobService jobService;

   @PostMapping("/create")
public Job createJob(@RequestBody Job job) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    String currentDateString = LocalDate.now().format(formatter);
        LocalDate currentDate = LocalDate.parse(currentDateString, formatter);
    job.setPostedDate(currentDate);
    // job.setIsActive("Y");
    
    return this.jobService.createJob(job);
}


@GetMapping("/getById/{id}")
public Job getJobById(@PathVariable String id) {
    return this.jobService.getJobById(id);
}




@GetMapping("/getAllJob")
public List<Job> getAllJob(){
    return this.jobService.getAllJob();
}

@DeleteMapping("/delete/{id}")
public void deleteJob(@PathVariable String id){
    this.jobService.deleteJob(id);
}

@PutMapping("/update/{id}")
public Job updateJob(@PathVariable String id, @RequestBody Job updatedJob) {
    return this.jobService.updateJob(id, updatedJob);
}

}
