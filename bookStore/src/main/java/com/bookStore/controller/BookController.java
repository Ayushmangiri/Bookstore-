package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
    
	 @GetMapping ("/")
	 public String home () {
		 return "home";
	 }
	 @GetMapping("/book_register")
	 public String bookRegister() {
	 return "bookRegister";
	 }
	 @GetMapping("/available_book")
	 public String getAllBook() {
		 return "bookList";
		 
	 }
	 @PostMapping("/save")
	 public String addBook(@ModelAttribute Book b) {
	     service.save(b);
	     return "redirect:/available_book";
	 }
}