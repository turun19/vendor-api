package com.example.technicaltestptsisi.controller;

import com.example.technicaltestptsisi.dto.request.VendorRequest;
import com.example.technicaltestptsisi.dto.response.BaseResponse;
import com.example.technicaltestptsisi.service.VendorService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;

@Slf4j
@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    private final Bucket bucket = Bucket.builder()
            .addLimit(Bandwidth.classic(5, Refill.greedy(5, Duration.ofSeconds(20))))
            .build();

    @GetMapping
    @Operation(summary = "for get name vendor all")
    public ResponseEntity<BaseResponse<?>> getVendor() {
        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(BaseResponse.success(vendorService.getAllVendors(), "Success Get All Vendors"));
        } else {
            log.info("Too many Requests");
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(BaseResponse.failure(429, "Too many requests - please try again later"));
        }
    }

    @PostMapping("/add")
    @Operation(summary = "for add name vendor")
    public ResponseEntity<BaseResponse<?>> addNameVendor(@RequestBody @Valid VendorRequest vendorRequest) {
        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(BaseResponse.success(vendorService.addVendor(vendorRequest), "Vendor added successfully"));
        } else {
            log.info("Too many Requests");
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(BaseResponse.failure(429, "Too many requests - please try again later"));
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "for update name vendor by id")
    public ResponseEntity<BaseResponse<?>> updateNameVendor(@PathVariable Long id, @RequestBody @Valid VendorRequest vendorRequest) throws Exception {
        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(BaseResponse.success(vendorService.updateVendor(id, vendorRequest), "Vendor updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(BaseResponse.failure(429, "Too many requests - please try again later"));
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "for delete name vendor by id")
    public ResponseEntity<BaseResponse<?>> deleteVendor(@PathVariable Long id) {
        if (bucket.tryConsume(1)) {
            vendorService.deleteVendor(id);
            return ResponseEntity.ok(BaseResponse.success(null, "Vendor Berhasil Dihapus"));
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(BaseResponse.failure(429, "Too many requests - please try again later"));
        }
    }
}
