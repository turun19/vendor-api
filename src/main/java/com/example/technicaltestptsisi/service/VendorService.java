package com.example.technicaltestptsisi.service;

import com.example.technicaltestptsisi.dto.request.VendorRequest;
import com.example.technicaltestptsisi.entity.Vendor;
import com.example.technicaltestptsisi.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ValidationService validationService;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor addVendor(VendorRequest vendorRequest) {
        validationService.validate(vendorRequest);
        Vendor vendor = new Vendor();
        vendor.setNameVendor(vendorRequest.getVendorName());
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, VendorRequest vendorRequest)throws Exception{
        validationService.validate(vendorRequest);
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new Exception("Invalid ID"));
        vendor.setNameVendor(vendorRequest.getVendorName());
        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
