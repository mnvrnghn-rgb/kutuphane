package com.example.kutuphane.service;

import com.example.kutuphane.model.Book;
import com.example.kutuphane.repository.BookRepository;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.result.Result;
import com.example.kutuphane.result.SuccessDataResult;
import com.example.kutuphane.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    @Autowired
    private BookRepository bookRepository;

    // Kitap kiralama metodu
    public Result rentBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book == null) {
            return new Result(false, "Kitap bulunamadı");
        }

        if (!book.getAvailable()) {
            return new Result(false, "Bu kitap zaten kiralanmış");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        return new SuccessResult("Kitap başarıyla kiralandı");
    }
}