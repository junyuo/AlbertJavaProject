package albert.practice.stringFormat;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringFormatExampleTest {

    private StringFormatExample stringFormat;
    private String unformatedMessage = "";
    private String phone = "";
    private String otp;
    private String anotherUnformatedMessage;
    private String error;
    
    @Before
    public void setup() {
        stringFormat = new StringFormatExample();
        unformatedMessage = "���ҽX�ǰe���\�C������X: {0}, ²�T���e�G���ҽX���G{1}";
        anotherUnformatedMessage = "���ҽX�ǰe���ѡA���ѭ�]�G{1}�C������X: {0}";
        phone = "0910123456";
        otp = "12345";
        error = "HTTP Server is down";
    }
    
    @Test
    public void testReturnWith1000Separator() {
        String str = stringFormat.returnWith1000Separator(1234567890);
        log.debug(str);
        assertEquals("1,234,567,890", str);
    }
    
    @Test
    public void testGetFormattedMessage() {
        String formatedMsg = stringFormat.getFormattedMessage(unformatedMessage, phone, otp);
        log.debug("formatedMsg = " + formatedMsg);
        assertEquals("���ҽX�ǰe���\�C������X: 0910123456, ²�T���e�G���ҽX���G12345", formatedMsg);
        
        String anotherFormatedMsg = stringFormat.getFormattedMessage(anotherUnformatedMessage, phone, error);
        log.debug("anotherFormatedMsg = " + anotherFormatedMsg);
        assertEquals("���ҽX�ǰe���ѡA���ѭ�]�GHTTP Server is down�C������X: 0910123456", anotherFormatedMsg);
    }

}
