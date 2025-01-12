package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_book")
    public String getAllBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "bookList";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        service.save(book);
        return "redirect:/available_book";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        Book book = service.getBookById(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute Book book) {
        book.setId(id);
        service.save(book);
        return "redirect:/available_book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        service.delete(id);
        return "redirect:/available_book";
    }
}
