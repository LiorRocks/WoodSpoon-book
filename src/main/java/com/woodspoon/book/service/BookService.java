package com.woodspoon.book.service;

import com.woodspoon.book.model.Book;
import com.woodspoon.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return BookRepository.books;
    }

    public Optional<Book> getBook(String isbn) throws Exception {
        try {
            URL url = new URL("http://localhost:3030/book_analytics/add_analytics/" + isbn);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        } catch (Exception e) {

        }
        return BookRepository.books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    public void addBook(Book book) {
        if(BookRepository.isIsbnExists(book.getIsbn())) {

        } else {
            BookRepository.books.add(book);
        }
    }
}
