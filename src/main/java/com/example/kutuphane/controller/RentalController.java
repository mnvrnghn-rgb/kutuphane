package com.example.kutuphane.controller;

import com.example.kutuphane.result.Result;
import com.example.kutuphane.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent/{bookId}")
    public Result rentBook(@PathVariable Long bookId) {
        return rentalService.rentBook(bookId);
    }
}