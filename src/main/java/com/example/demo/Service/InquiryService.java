package com.example.demo.Service;

import com.example.demo.Entity.Inquiry;
import com.example.demo.Repo.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquiryService {
    
    @Autowired
    private InquiryRepository inquiryRepository;

    public Inquiry saveInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAllByOrderByCreatedAtDesc();
    }
    

    public List<Inquiry> getUnreadInquiries() {
        return inquiryRepository.findByIsReadFalseOrderByCreatedAtDesc();
    }
    

    public Optional<Inquiry> getInquiryById(Long id) {
        return inquiryRepository.findById(id);
    }

    public Inquiry markAsRead(Long id) {
        Optional<Inquiry> inquiryOpt = inquiryRepository.findById(id);
        if (inquiryOpt.isPresent()) {
            Inquiry inquiry = inquiryOpt.get();
            inquiry.setIsRead(true);
            return inquiryRepository.save(inquiry);
        }
        return null;
    }
    

    public long getUnreadCount() {
        return inquiryRepository.countByIsReadFalse();
    }
    

    public boolean deleteInquiry(Long id) {
        if (inquiryRepository.existsById(id)) {
            inquiryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Inquiry> getInquiriesByCountry(String country) {
        return inquiryRepository.findByCountryOrderByCreatedAtDesc(country);
    }
}