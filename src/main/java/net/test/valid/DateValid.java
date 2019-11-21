package net.test.valid;

import org.hibernate.boot.MappingException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateValid {

    private static final String DD_MM_YYYY = "dd.MM.yyyy";

    public Date parseDate(String stringDate) throws MappingException, ParseException {
        Date date = new Date();

        try {
            date = new SimpleDateFormat(DD_MM_YYYY).parse(stringDate);
        } catch (ParseException e) {
            throw new ParseException("Всё упало", 1);
        }

        return date;
    }


}
