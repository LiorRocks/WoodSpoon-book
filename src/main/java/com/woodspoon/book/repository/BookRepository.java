package com.woodspoon.book.repository;

import com.woodspoon.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {

    public static List<Book> books = Arrays.asList(
            new Book("Adventures of Huckleberry Finn", "Mark Twain", "9780520228382"),
            new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "9780330316118"),
            new Book("Dirk Gently's Holistic Detective Agency", "Douglas Adams", "9780434009008")
    );

    public static boolean isIsbnExists(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).count() == 1;
    }
}
