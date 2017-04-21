package albert.practice.validation;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.w3c.tidy.Tidy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {

    public static Boolean isHtmlValid(String htmlString) throws UnsupportedEncodingException {
        Boolean isValid = Boolean.FALSE;

        Tidy tidy = new Tidy();
        
        StringWriter writer = new StringWriter();
        tidy.parse(new StringReader(htmlString), writer);
        int errors = tidy.getParseErrors();
        int warnings = tidy.getParseWarnings();
        
        log.debug("errors = " + errors + ", warnings = " + warnings);
        log.debug("writer = " + writer.toString());
        
        if (errors == 0) {
            isValid = Boolean.TRUE;
        }
        
        return isValid;
    }
    
    
    
}
