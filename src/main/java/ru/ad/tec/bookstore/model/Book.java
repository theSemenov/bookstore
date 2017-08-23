package ru.ad.tec.bookstore.model;

import ru.ad.tec.bookstore.db.entity.BookEntity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
public class Book implements Serializable {

    private Long id;
    private String title;
    private String isbn;
    private String authors;
    private LocalDate publishDate;
    private Integer pageCount;
    private String genre;
    private String publishingHouse;


    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public static Book fromBookEntity (BookEntity entity) {
        Book book = new Book();
        book.setId(entity.getId());
        book.setTitle(entity.getTitle());
        book.setIsbn(entity.getIsbn());
        book.setAuthors(entity.getAuthors());
        book.setPublishDate(entity.getPublishDate());
        book.setPageCount(entity.getPageCount());
        book.setGenre(entity.getGenre());
        book.setPublishingHouse(entity.getPublishingHouse());
        return book;
    }
}
