package ru.ad.tec.bookstore.db.entity;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import ru.ad.tec.bookstore.db.converter.LocalDateConverter;
import ru.ad.tec.bookstore.model.Book;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
@Entity
@Table(name = "books_tbl")
public class BookEntity {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String authors;
    @Column(name = "PUBLISH_DATE")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate publishDate;
    @Column(name = "PAGE_COUNT")
    private Integer pageCount;
    private String genre;
    @Column(name = "PUBLISHING_HOUSE")
    private String publishingHouse;

    public BookEntity() {

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

    public static BookEntity fromBook(Book book) {
        BookEntity entity = new BookEntity();
        entity.setId(book.getId());
        entity.setTitle(book.getTitle());
        entity.setIsbn(book.getIsbn());
        entity.setAuthors(book.getAuthors());
        entity.setPublishDate(book.getPublishDate());
        entity.setPageCount(book.getPageCount());
        entity.setGenre(book.getGenre());
        entity.setPublishingHouse(book.getPublishingHouse());
        return entity;
    }
}
