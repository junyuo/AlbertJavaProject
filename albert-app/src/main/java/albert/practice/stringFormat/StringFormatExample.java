package albert.practice.stringFormat;

public class StringFormatExample {

    public String returnWith1000Separator(int amount) {
        return String.format("%,d", amount);
    }
    
}
