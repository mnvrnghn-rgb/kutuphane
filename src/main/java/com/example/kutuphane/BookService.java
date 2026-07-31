package com.example.kutuphane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Tüm kitapları listeleyen metot
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Yeni kitap kaydeden metot
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}