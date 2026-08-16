package com.example.kutuphane.controller;

import com.example.kutuphane.model.Rental;
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

    @PostMapping("/rent/{bookId}")
    public DataResult<Rental> rentBook(@PathVariable Long bookId) {
        Rental rental = new Rental();
        rental.setBookId(bookId);
        rental.setCustomerName("Test Kullanici");
        return rentalService.rentBook(rental);
    }

    @GetMapping("/getall")
    public DataResult<List<Rental>> getAllRentals() {
        return rentalService.getAllRentals();
    }
}