package ru.ad.tec.bookstore.view;

import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ad.tec.bookstore.model.Book;
import ru.ad.tec.bookstore.service.IBookstoreService;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
@Component
@UIScope
public class BookEditorView extends Panel implements View, NavigatorAware<BookstoreNavigator> {

    private Book book;

    private BookstoreNavigator navigator;

    private boolean readOnly = false;

    @Autowired
    IBookstoreService service;

    public BookEditorView() {

    }

    public BookEditorView(Book book) {
        this.book = book;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if (book == null) {
            Notification.show("Book not selected");
            navigator.navigateToBookList();
        }
        display();
    }

    public void display() {
        VerticalLayout root = new VerticalLayout();
        String bookId = Optional.ofNullable(book).map(book -> book.getIsbn()).orElse("Новая книга");
        setCaption("Book editor " + bookId);
        setContent(root);

        HorizontalLayout buttonBar = new HorizontalLayout();
        Button commit = new Button("commit");
        commit.addClickListener(event -> {
            service.updateOrCreate(book);
            setBook(null);
            navigator.navigateToBookList();
        });
        if (readOnly) {
            commit.setEnabled(false);
        }
        Button chancel = new Button("chancel");
        chancel.addClickListener(event -> {
            setBook(null);
            setReadOnly(false);
            navigator.navigateToBookList();
        });

        buttonBar.addComponents(commit, chancel);
        TextField titleField = new TextField("title");
        TextField isbnField = new TextField("isbn");
        TextField authorsField = new TextField("authors");
        DateField pubDateField = new DateField("publishing date");
        TextField pageCountField = new TextField("page count");
        TextField genreField = new TextField("genre");
        TextField publishingHouse = new TextField("publishing house");

        Binder<Book> binder = new Binder<>(Book.class);
        binder.bind(titleField, Book::getTitle, Book::setTitle);
        binder.bind(isbnField, Book::getIsbn, Book::setIsbn);
        binder.bind(authorsField, Book::getAuthors, Book::setAuthors);
        binder.bind(pubDateField, Book::getPublishDate, Book::setPublishDate);
        binder.forField(pageCountField)
            .withValidator(inputString -> {
                try {
                    return Integer.valueOf(inputString) > 0;
                } catch (NumberFormatException ignored) {
                    return false;
                }
            }, "Input value should be a positive integer")
            .bind(
                book -> book.getPageCount() == null ? "" : Integer.toString(book.getPageCount()),
                (book, formValue) -> book.setPageCount(Integer.valueOf(formValue))
            );
        binder.bind(genreField, Book::getGenre, Book::setGenre);
        binder.bind(publishingHouse, Book::getPublishingHouse, Book::setPublishingHouse);
        binder.setBean(book);

        Stream.of(titleField, isbnField, authorsField,
            pubDateField, pageCountField, genreField, publishingHouse).forEach(f -> f.setReadOnly(readOnly));
        root.addComponents(buttonBar, titleField, isbnField, authorsField,
            pubDateField, pageCountField, genreField, publishingHouse);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public BookstoreNavigator getNavigator() {
        return navigator;
    }

    @Override
    public void setNavigator(BookstoreNavigator navigator) {
        this.navigator = navigator;
    }
}
