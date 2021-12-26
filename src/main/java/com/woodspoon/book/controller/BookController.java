package com.woodspoon.book.controller;

import com.woodspoon.book.model.Book;
import com.woodspoon.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{isbn}")
    @ResponseBody
    public Optional<Book> getBookByIsbn(@PathVariable String isbn) throws Exception {
        return bookService.getBook(isbn);
    }

    @PostMapping("/books")
    public void addBook(Book book) {
        this.bookService.addBook(book);
    }
}
