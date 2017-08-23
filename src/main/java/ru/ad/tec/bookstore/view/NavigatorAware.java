package ru.ad.tec.bookstore.view;

import com.vaadin.navigator.Navigator;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
public interface NavigatorAware<T extends Navigator> {

    T getNavigator();
    void setNavigator(T navigator);
}
