package ru.ad.tec.bookstore.view;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("Bookstore")
@SpringUI
public class BookstoreUI extends UI{

	@Autowired
	BookstoreNavigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		setSizeFull();
		navigator.initUi(this);
		navigator.navigateToBookList();
	}
}
