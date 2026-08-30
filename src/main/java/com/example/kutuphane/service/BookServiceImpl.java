package com.example.kutuphane.service;

import com.example.kutuphane.model.Book;
import com.example.kutuphane.repository.BookRepository;
import com.example.kutuphane.result.DataResult;
import com.example.kutuphane.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public DataResult<List<Book>> getBooksByCategory(String categoryId) {
        List<Book> books = bookRepository.findByCategory(categoryId);
        return new SuccessDataResult<List<Book>>(books, "Kategoriye ait kitaplar listelendi");
    }
}