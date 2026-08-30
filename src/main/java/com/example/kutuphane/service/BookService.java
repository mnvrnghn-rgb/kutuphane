package com.example.kutuphane.service;

import com.example.kutuphane.model.Book;
import com.example.kutuphane.result.DataResult;
import java.util.List;

public interface BookService {
    DataResult<List<Book>> getBooksByCategory(String categoryId);
}