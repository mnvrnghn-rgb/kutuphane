package com.example.kutuphane.controller;

import com.example.kutuphane.model.Book;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Tüm kitapları listeleyen endpoint
    @GetMapping
    public DataResult<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Yeni kitap ekleyen endpoint
    @PostMapping
    public DataResult<Book> createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}