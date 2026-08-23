package com.example.kutuphane.service;

import com.example.kutuphane.dto.CreateRentalRequest;
import com.example.kutuphane.dto.RentalResponseDto;
import com.example.kutuphane.model.Book;
import com.example.kutuphane.model.Rental;
import com.example.kutuphane.repository.BookRepository;
import com.example.kutuphane.repository.RentalRepository;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookRepository bookRepository;

    public DataResult<RentalResponseDto> rentBook(CreateRentalRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı!"));

        Rental rental = new Rental();
        rental.setBook(book);
        rental.setCustomerName(request.getCustomerName());

        Rental savedRental = rentalRepository.save(rental);

        RentalResponseDto responseDto = new RentalResponseDto(
                savedRental.getId(),
                savedRental.getCustomerName(),
                savedRental.getBook().getTitle()
        );

        return new SuccessDataResult<>(responseDto, "Kitap başarıyla kiralandı.");
    }

    public DataResult<List<RentalResponseDto>> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();

        List<RentalResponseDto> dtoList = rentals.stream().map(rental ->
                new RentalResponseDto(
                        rental.getId(),
                        rental.getCustomerName(),
                        rental.getBook().getTitle()
                )
        ).collect(Collectors.toList());

        return new SuccessDataResult<>(dtoList, "Kiralamalar listelendi.");
    }
}