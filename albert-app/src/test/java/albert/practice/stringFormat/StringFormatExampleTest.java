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
        unformatedMessage = "驗證碼傳送成功。手機號碼: {0}, 簡訊內容：驗證碼為：{1}";
        anotherUnformatedMessage = "驗證碼傳送失敗，失敗原因：{1}。手機號碼: {0}";
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
        assertEquals("驗證碼傳送成功。手機號碼: 0910123456, 簡訊內容：驗證碼為：12345", formatedMsg);
        
        String anotherFormatedMsg = stringFormat.getFormattedMessage(anotherUnformatedMessage, phone, error);
        log.debug("anotherFormatedMsg = " + anotherFormatedMsg);
        assertEquals("驗證碼傳送失敗，失敗原因：HTTP Server is down。手機號碼: 0910123456", anotherFormatedMsg);
    }

}
