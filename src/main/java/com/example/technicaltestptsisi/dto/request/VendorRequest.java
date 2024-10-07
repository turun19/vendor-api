package com.example.technicaltestptsisi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VendorRequest {
    @NotEmpty(message = "Must Not Empty")
    private String vendorName;
}
