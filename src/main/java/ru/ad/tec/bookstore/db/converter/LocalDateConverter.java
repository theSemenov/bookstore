package ru.ad.tec.bookstore.db.converter;

import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Semenov Alexey on 24.08.17  {@literal <theSemenov@gmail.com>}.
 */

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return Jsr310Converters.LocalDateToDateConverter.INSTANCE.convert(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Jsr310Converters.DateToLocalDateConverter.INSTANCE.convert(date);
    }
}