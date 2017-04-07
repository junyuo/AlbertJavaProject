package albert.practice.stringFormat;

import java.text.Format;
import java.text.MessageFormat;

public class StringFormatExample {

    public String returnWith1000Separator(int amount) {
        return String.format("%,d", amount);
    }
    
    public String getFormattedMessage(String message, String... values) {
       Format messageFormat = new MessageFormat(message);
       return messageFormat.format(values);
    }
    
}
