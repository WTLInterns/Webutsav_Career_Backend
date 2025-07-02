package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.AppliedEmployee;

@Repository
public interface AppliedEmployeeRepo extends JpaRepository<AppliedEmployee, Integer>{
    
}
