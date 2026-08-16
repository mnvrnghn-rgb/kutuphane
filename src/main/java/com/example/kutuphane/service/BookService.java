package com.example.kutuphane.service;

import com.example.kutuphane.model.Book;
import com.example.kutuphane.repository.BookRepository;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public DataResult<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new SuccessDataResult<List<Book>>(books, "Kitaplar listelendi.");
    }

    public DataResult<Book> createBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return new SuccessDataResult<Book>(savedBook, "Kitap başarıyla eklendi.");
    }

    public DataResult<List<Book>> getBooksByCategory(String category) {
        List<Book> books = bookRepository.findByCategory(category);
        return new SuccessDataResult<List<Book>>(books, "Kategoriye göre kitaplar listelendi.");
    }
}