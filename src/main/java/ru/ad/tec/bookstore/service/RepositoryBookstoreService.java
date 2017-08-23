package ru.ad.tec.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.ad.tec.bookstore.db.entity.BookEntity;
import ru.ad.tec.bookstore.db.repository.BookRepository;
import ru.ad.tec.bookstore.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
@Service
@Primary
public class RepositoryBookstoreService implements IBookstoreService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll().stream().map(Book::fromBookEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<Book> updateOrCreate(Book book) {
        return Optional.ofNullable(bookRepository.saveAndFlush(BookEntity.fromBook(book))).map(Book::fromBookEntity);
    }

    @Override
    public Optional<Book> delete(Book book) {
        bookRepository.delete(book.getId());
        return Optional.ofNullable(book);
    }
}
