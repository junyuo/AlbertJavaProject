package albert.practice.stringFormat;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringFormatExampleTest {

    private StringFormatExample stringFormat;
    
    @Before
    public void setup() {
        stringFormat = new StringFormatExample();
    }
    
    @Test
    public void testReturnWith1000Separator() {
        String str = stringFormat.returnWith1000Separator(1234567890);
        log.debug(str);
        assertEquals("1,234,567,890", str);
    }

}
