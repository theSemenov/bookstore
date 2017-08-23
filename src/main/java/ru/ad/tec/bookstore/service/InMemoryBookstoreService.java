package ru.ad.tec.bookstore.service;

import org.springframework.stereotype.Service;
import ru.ad.tec.bookstore.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.PostConstruct;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
@Service
public class InMemoryBookstoreService implements IBookstoreService {

    private List<Book> bookList;

    @PostConstruct
    public void init() {
        bookList = new ArrayList<>();
        for (int i = 0 ; i < 10; i++) {
            Book book = new Book();
            book.setId(Double.valueOf(Math.random()).longValue());
            book.setIsbn(UUID.randomUUID().toString());
            book.setTitle("title");
            book.setPublishDate(LocalDate.now());
            book.setGenre("detective");
            book.setPublishingHouse("Esmo");
            book.setAuthors("alexey, alexandrova");
            bookList.add(book);
        }
    }

    @Override
    public List<Book> findAllBooks() {
        return bookList;
    }

    @Override
    public Optional<Book> updateOrCreate(Book book) {
        if (book.getId() == null) {
            return createBook(book);
        } else {
            return updateBook(book);
        }
    }

    private Optional<Book> updateBook(Book book) {
        return Optional.ofNullable(book);
    }

    private Optional<Book> createBook(Book book) {
        book.setId(Double.valueOf(Math.random()).longValue());
        bookList.add(book);
        return Optional.ofNullable(book);
    }

    @Override
    public Optional<Book> delete(Book book) {
        bookList.remove(book);
        return Optional.ofNullable(book);
    }
}
