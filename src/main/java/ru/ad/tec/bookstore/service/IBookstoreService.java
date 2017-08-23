package ru.ad.tec.bookstore.service;

import ru.ad.tec.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */

public interface IBookstoreService {
    List<Book> findAllBooks();
    Optional<Book> updateOrCreate(Book book);
    Optional<Book> delete(Book book);
}
