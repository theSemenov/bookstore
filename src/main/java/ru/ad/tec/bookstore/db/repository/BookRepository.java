package ru.ad.tec.bookstore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.ad.tec.bookstore.db.entity.BookEntity;

/**
 * @author Semenov Alexey on 23.08.17  {@literal <theSemenov@gmail.com>}.
 */
public interface BookRepository extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

}
