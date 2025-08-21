package com.example.demo.Controller;

import com.example.demo.Entity.Inquiry;
import com.example.demo.Service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "*")
public class InquiryController {
    
    // Test endpoint
    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Backend is running");
        response.put("timestamp", new java.util.Date().toString());
        return ResponseEntity.ok(response);
    }
    
    @Autowired
    private InquiryService inquiryService;
    
    // Submit new inquiry (for website contact form)
    @PostMapping("/submit")
    public ResponseEntity<Map<String, Object>> submitInquiry(@RequestBody Inquiry inquiry) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Validate required fields
            if (inquiry.getName() == null || inquiry.getName().trim().isEmpty() ||
                inquiry.getEmail() == null || inquiry.getEmail().trim().isEmpty() ||
                inquiry.getPhoneNumber() == null || inquiry.getPhoneNumber().trim().isEmpty() ||
                inquiry.getCountry() == null || inquiry.getCountry().trim().isEmpty()) {
                
                response.put("success", false);
                response.put("message", "All fields except message are required");
                return ResponseEntity.badRequest().body(response);
            }
            
            Inquiry savedInquiry = inquiryService.saveInquiry(inquiry);
            response.put("success", true);
            response.put("message", "Your inquiry has been submitted successfully!");
            response.put("inquiryId", savedInquiry.getId());
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to submit inquiry. Please try again.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    // Get all inquiries (for admin panel)
    @GetMapping("/all")
    public ResponseEntity<List<Inquiry>> getAllInquiries() {
        try {
            List<Inquiry> inquiries = inquiryService.getAllInquiries();
            System.out.println("Fetched " + inquiries.size() + " inquiries");
            return ResponseEntity.ok(inquiries);
        } catch (Exception e) {
            System.err.println("Error fetching inquiries: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    // Get unread inquiries (for admin panel)
    @GetMapping("/unread")
    public ResponseEntity<List<Inquiry>> getUnreadInquiries() {
        try {
            List<Inquiry> inquiries = inquiryService.getUnreadInquiries();
            System.out.println("Fetched " + inquiries.size() + " unread inquiries");
            return ResponseEntity.ok(inquiries);
        } catch (Exception e) {
            System.err.println("Error fetching unread inquiries: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    // Get inquiry by ID
    @GetMapping("/{id}")
    public ResponseEntity<Inquiry> getInquiryById(@PathVariable Long id) {
        Optional<Inquiry> inquiry = inquiryService.getInquiryById(id);
        if (inquiry.isPresent()) {
            return ResponseEntity.ok(inquiry.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    // Mark inquiry as read
    @PutMapping("/{id}/mark-read")
    public ResponseEntity<Map<String, Object>> markAsRead(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        
        Inquiry updatedInquiry = inquiryService.markAsRead(id);
        if (updatedInquiry != null) {
            response.put("success", true);
            response.put("message", "Inquiry marked as read");
            return ResponseEntity.ok(response);
        }
        
        response.put("success", false);
        response.put("message", "Inquiry not found");
        return ResponseEntity.notFound().build();
    }
    
    // Get unread count
    @GetMapping("/unread/count")
    public ResponseEntity<Map<String, Long>> getUnreadCount() {
        Map<String, Long> response = new HashMap<>();
        response.put("count", inquiryService.getUnreadCount());
        return ResponseEntity.ok(response);
    }
    
    // Delete inquiry
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteInquiry(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        
        boolean deleted = inquiryService.deleteInquiry(id);
        if (deleted) {
            response.put("success", true);
            response.put("message", "Inquiry deleted successfully");
            return ResponseEntity.ok(response);
        }
        
        response.put("success", false);
        response.put("message", "Inquiry not found");
        return ResponseEntity.notFound().build();
    }
    
    // Get inquiries by country
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Inquiry>> getInquiriesByCountry(@PathVariable String country) {
        List<Inquiry> inquiries = inquiryService.getInquiriesByCountry(country);
        return ResponseEntity.ok(inquiries);
    }
}