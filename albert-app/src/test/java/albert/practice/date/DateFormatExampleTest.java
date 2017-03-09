package albert.practice.date;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateFormatExampleTest {

    DateFormatExample dateFormatExample;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        dateFormatExample = new DateFormatExample();
    }

    @Test
    public void testDateFormat() throws ParseException {
        Date date = dateFormatExample.convertStringToDate("2017/03/9", "yyyy/MM/dd");
        log.debug("date = " + date);
    }
    
    @Test
    public void testWithWrongDateFormat() throws ParseException  {
        thrown.expect(ParseException.class);
        dateFormatExample.convertStringToDate("2017/13/9", "yyyy/MM/dd");
    }
    
}
