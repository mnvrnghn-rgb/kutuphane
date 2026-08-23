package com.example.kutuphane.controller;

import com.example.kutuphane.dto.CreateRentalRequest;
import com.example.kutuphane.dto.RentalResponseDto;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent")
    public DataResult<RentalResponseDto> rentBook(@RequestBody CreateRentalRequest request) {
        return rentalService.rentBook(request);
    }

    @GetMapping("/getall")
    public DataResult<List<RentalResponseDto>> getAllRentals() {
        return rentalService.getAllRentals();
    }
}