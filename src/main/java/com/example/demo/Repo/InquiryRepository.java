package com.example.demo.Repo;

import com.example.demo.Entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    
    // Find all inquiries ordered by creation date (newest first)
    List<Inquiry> findAllByOrderByCreatedAtDesc();
    
    // Find unread inquiries
    List<Inquiry> findByIsReadFalseOrderByCreatedAtDesc();
    
    // Count unread inquiries
    long countByIsReadFalse();
    
    // Find inquiries by country
    List<Inquiry> findByCountryOrderByCreatedAtDesc(String country);
}