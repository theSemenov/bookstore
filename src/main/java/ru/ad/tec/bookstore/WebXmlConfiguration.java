package ru.ad.tec.bookstore;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * @author Semenov Alexey on 24.08.17  {@literal <theSemenov@gmail.com>}
 */
public class WebXmlConfiguration {

    @WebServlet(value = "/*", asyncSupported = true)
    public static class BookstoreServlet extends SpringVaadinServlet {

    }

    @WebListener
    public static class BookstoreLoaderListener extends ContextLoaderListener {

    }

    @Configuration
    @EnableVaadin
    public static class BookstoreConfiguration {
    }
}
