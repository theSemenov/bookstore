package ru.ad.tec.bookstore.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ad.tec.bookstore.model.Book;

import javax.annotation.PostConstruct;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
@Component
@UIScope
public class BookstoreNavigator extends Navigator {

    public static final String BOOK_LIST_LINK = "bookList";
    public static final String BOOK_EDITOR_LINK = "bookEditor";

    @Autowired
    private BookListView bookList;

    @Autowired
    private BookEditorView bookEditor;

    public BookstoreNavigator() {
    }

    @PostConstruct
    public void initLink() {
        addView(BOOK_LIST_LINK, bookList);
        addView(BOOK_EDITOR_LINK, bookEditor);

        bookList.setNavigator(this);
        bookEditor.setNavigator(this);
    }

    public void navigateToBookList() {
        navigateTo(BOOK_LIST_LINK);
    }

    public void navigateToBookEditorForEdit(Book book) {
        bookEditor.setBook(book);
        bookEditor.setReadOnly(false);
        navigateTo(BOOK_EDITOR_LINK);
    }

    public Book navigateToBookEditorForCreate() {
        Book book = new Book();
        bookEditor.setBook(new Book());
        bookEditor.setReadOnly(false);
        navigateTo(BOOK_EDITOR_LINK);
        return book;
    }

    public void navigateToBookEditorForPreview(Book book) {
        bookEditor.setBook(book);
        bookEditor.setReadOnly(true);
        navigateTo(BOOK_EDITOR_LINK);
    }

    public void initUi(UI ui) {
        init(ui, null, new SingleComponentContainerViewDisplay(ui));
    }

}
