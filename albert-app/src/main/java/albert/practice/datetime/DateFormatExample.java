package albert.practice.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {

    public Date convertStringToDate(String dateStr, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date;
        try {
            dateFormat.setLenient(false);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
           throw e;
        }
        return date;
    }
    
}
