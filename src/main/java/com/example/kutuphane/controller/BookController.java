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

    @GetMapping("/getall")
    public DataResult<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public DataResult<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/category/{category}")
    public DataResult<List<Book>> getBooksByCategory(@PathVariable String category) {
        return bookService.getBooksByCategory(category);
    }
}