package com.bookStore.service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book book) {
        bRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bRepo.findAll();
    }

    public Book getBookById(int id) {
        return bRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        bRepo.deleteById(id);
    }
}
