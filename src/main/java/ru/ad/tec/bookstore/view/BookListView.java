package ru.ad.tec.bookstore.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ComponentRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ad.tec.bookstore.model.Book;
import ru.ad.tec.bookstore.service.IBookstoreService;

import java.util.List;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
@Component
@UIScope
public class BookListView extends Panel implements View, NavigatorAware<BookstoreNavigator> {

    private BookstoreNavigator navigator;

    @Autowired
    private IBookstoreService service;
    private VerticalLayout root = new VerticalLayout();

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        display();
    }

    private void display() {
        VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        Button addBook = new Button("add");
        addBook.addClickListener(e -> navigator.navigateToBookEditorForCreate());
        root.addComponent(addBook);

        setCaption("Book list");
        setContent(root);

        List<Book> books = service.findAllBooks();
        Grid<Book> booksGrid = new Grid<>("Books");
        booksGrid.setItems(books);
        booksGrid.addColumn(Book::getTitle).setCaption("Title");
        booksGrid.addColumn(Book::getAuthors).setCaption("Authors");
        booksGrid.addColumn(Book::getIsbn).setCaption("ISBN");
        booksGrid.addColumn(this::buildButtonBar, new ComponentRenderer()).setCaption("Actions");
        booksGrid.setSizeFull();
        root.addComponent(booksGrid);
    }

    private HorizontalLayout buildButtonBar(Book book) {
        HorizontalLayout bar = new HorizontalLayout();
        Button view = new Button("view");
        view.addClickListener(event -> navigator.navigateToBookEditorForPreview(book));
        Button edit = new Button("edit");
        edit.addClickListener(event -> navigator.navigateToBookEditorForEdit(book));
        Button delete = new Button("delete");
        delete.addClickListener(event -> {
            service.delete(book);
            display();
        });
        bar.addComponents(view, edit, delete);
        return bar;
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
