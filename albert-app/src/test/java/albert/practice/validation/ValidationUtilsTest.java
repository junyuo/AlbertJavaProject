package albert.practice.validation;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtilsTest extends ValidationUtils {

    private StringBuilder html1 = new StringBuilder();
    private StringBuilder html2 = new StringBuilder();

    @Before
    public void setup() {
        html1.append(" <html> ");
        html1.append("    <body> ");
        html1.append("       <p>親愛的客戶您好:</p> ");
        html1.append("       <p>您的驗證碼為 ${otp} ，請於收到e-mail 10分鐘內完成驗證，逾時或認證後此驗證碼將自動失效</p> ");
        html1.append("       <P>本信件由系統直接發送，請勿直接回覆，謝謝！</p> ");
        html1.append("    </body> ");
        html1.append(" </html> ");

        html2.append("       <p>親愛的客戶您好:</p> ");
        html2.append("       <p>您的驗證碼為 ${otp} ，請於收到e-mail 10分鐘內完成驗證，逾時或認證後此驗證碼將自動失效</p> ");
        html2.append("       <P>本信件由系統直接發送，請勿直接回覆，謝謝！</p> ");
    }

    @Test
    public void testIsHtmlValid() throws UnsupportedEncodingException {
        assertTrue(isHtmlValid(html1.toString()) == Boolean.TRUE);
        assertTrue(isHtmlValid(html2.toString()) == Boolean.TRUE);
    }
    
}
