package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, String> {
    
}