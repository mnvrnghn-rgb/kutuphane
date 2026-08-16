package com.example.kutuphane.service;

import com.example.kutuphane.model.Rental;
import com.example.kutuphane.repository.RentalRepository;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public DataResult<Rental> rentBook(Rental rental) {
        Rental savedRental = rentalRepository.save(rental);
        return new SuccessDataResult<Rental>(savedRental, "Kitap başarıyla kiralandı.");
    }

    public DataResult<List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return new SuccessDataResult<List<Rental>>(rentals, "Kiralanan kitaplar listelendi.");
    }
}