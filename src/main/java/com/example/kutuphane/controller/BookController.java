package com.example.kutuphane.controller;

import com.example.kutuphane.model.Book;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.service.BookService;
import com.example.kutuphane.result.Result;
import com.example.kutuphane.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private RentalService rentalService;

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
    // Kategoriye göre kitapları listeleyen endpoint
    @GetMapping("/category/{category}")
    public DataResult<List<Book>> getBooksByCategory(@PathVariable String category) {
        return bookService.getBooksByCategory(category);
    }

    // Kitap kiralama endpoint'i
    @PostMapping("/rent/{bookId}")
    public Result rentBook(@PathVariable Long bookId) {
        return rentalService.rentBook(bookId);
    }
}